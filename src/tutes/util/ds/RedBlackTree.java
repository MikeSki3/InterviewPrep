package tutes.util.ds;

public class RedBlackTree {

	Node root;

	public RedBlackTree(int data) {
		root = new Node(data, type.BLACK);
	}

	public void traverse() {
		traverse(root);
		System.out.println();
	}

	private void traverse(Node currNode) {
		if (currNode.left != null)
			traverse(currNode.left);
		System.out.print(currNode.data + " ");
		if (currNode.right != null)
			traverse(currNode.right);
	}

	public void insert(int data) {
		root = insert(null, root, data);
	}

	private Node insert(Node parent, Node currNode, int data) {
		if (currNode == null) {
			currNode = new Node(data);
			currNode.parent = parent;
			return currNode;
		}
		if (currNode.data > data) {
			currNode.left = insert(currNode, currNode.left, data);
			// currNode.left.parent = currNode;
		} else if (currNode.data < data) {
			currNode.right = insert(currNode, currNode.right, data);
			// currNode.right.parent = currNode;
		} else {
			return currNode;
		}

		currNode = rebalance(currNode, data);

		return currNode;
	}

	private Node rebalance(Node gp, int data) {
		Node parent = (gp.data < data) ? gp.right : gp.left;
		Node sibling = (gp.data < data) ? gp.left : gp.right;
		Node child = (parent.left != null && parent.left.data == data) ? parent.left : parent.right;
		if (parent != null && child != null) {
			if (breaksRedProp(parent, child)) {
				if (sibling != null && sibling.color == type.RED) {
					sibling.color = type.BLACK;
					parent.color = type.BLACK;
					if(gp.parent == null)
						gp.color = type.BLACK;
					else
						gp.color = (gp.color == type.BLACK) ? type.RED : type.BLACK;
				} else {
					if(parent.data < gp.data && child.data < parent.data){
						return recolor(rotateRight(gp));
					} else if(parent.data > gp.data && child.data > parent.data){
						return recolor(rotateLeft(gp));
					} else if(parent.data < gp.data && child.data > parent.data){
						gp.left = rotateLeft(parent);
						return recolor(rotateRight(gp));
					} else if(parent.data > gp.data && child.data < parent.data){
						gp.right = rotateRight(parent);
						return recolor(rotateLeft(gp));
					}
				}
			}
		}

		return gp;
	}

	private Node recolor(Node parent) {
		parent.color = type.BLACK;
		if(parent.left != null)
			parent.left.color = type.RED;
		if(parent.right != null)
			parent.right.color = type.RED;
		return parent;
	}

	// private Node rebalance(Node currNode, int data) {
	// Node child = (currNode.left != null && currNode.left.data == data) ?
	// currNode.left : currNode.right;
	// Node sibling;
	// if (breaksRedProp(currNode, child)) {
	// sibling = getSibling(currNode);
	// if (sibling != null && sibling.color == type.RED) {
	// sibling.color = type.BLACK;
	// currNode.color = type.BLACK;
	// swapColorsUpTree(currNode.parent);
	// } else {
	// if (currNode.data < currNode.parent.data && child.data < currNode.data) {
	// return rotateRight(currNode.parent);
	// } else if (currNode.data > currNode.parent.data && child.data >
	// currNode.data) {
	// return rotateLeft(currNode.parent);
	// } else if (currNode.data < currNode.parent.data && child.data >
	// currNode.data) {
	// currNode.parent.left = rotateLeft(currNode);
	// return rotateRight(currNode.parent);
	// } else if (currNode.data > currNode.parent.data && child.data <
	// currNode.data) {
	// currNode.parent.right = rotateRight(currNode);
	// return rotateLeft(currNode.parent);
	// }
	// }
	// }
	// return currNode;
	// }

	private Node rotateLeft(Node oldRoot) {
		Node newRoot = oldRoot.right;
		Node newChildRight = newRoot.left;
		oldRoot.right = newChildRight;
		newRoot.parent = oldRoot.parent;
		newRoot.left = oldRoot;
		oldRoot.parent = newRoot;

		return newRoot;
	}

	private Node rotateRight(Node oldRoot) {
		Node newRoot = oldRoot.left;
		Node newChildLeft = newRoot.right;
		oldRoot.left = newChildLeft;
		newRoot.parent = oldRoot.parent;
		newRoot.right = oldRoot;
		oldRoot.parent = newRoot;

		return newRoot;
	}

	private void swapColorsUpTree(Node currNode) {
		if (currNode != null) {
			currNode.color = (currNode.color == type.BLACK && currNode.parent != null) ? type.RED : type.BLACK;
			swapColorsUpTree(currNode.parent);
		}
	}

	private Node getSibling(Node currNode) {
		if (currNode.parent != null)
			return (currNode.parent.left == currNode) ? currNode.parent.right : currNode.parent.left;
		return null;
	}

	private boolean breaksRedProp(Node currNode, Node leftChild) {
		return leftChild != null && leftChild.color == type.RED && currNode != null && currNode.color == type.RED;
	}
	
	public Node getRoot() {
		return root;
	}

	class Node {
		int data;
		type color;
		Node parent;
		Node left, right;

		public Node(int data) {
			this.data = data;
			color = type.RED;
		}

		public Node(Node parent, int data) {
			this.data = data;
			this.parent = parent;
			color = type.RED;
		}

		// Use mostly as a nice to have for initiating the tree
		public Node(int data, type color) {
			this.data = data;
			this.color = color;
		}

		@Override
		public String toString() {
			return "[data=" + data + ", color=" + color + ", parent=" + (parent != null ? parent.data : null)
					+ ", left=" + left + ", right=" + right + "]";
		}

	}

	private enum type {
		RED, BLACK
	}
}
