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

	public Node find(int target) {
		return find(root, target);
	}

	private Node find(Node curr, int target) {
		if (curr.data == target)
			return curr;
		else if (curr.data > target && curr.left != null)
			return find(curr.left, target);
		else if (curr.data < target && curr.right != null)
			return find(curr.right, target);
		return null;
	}

	public void delete(int data) {
		delete(find(data));
	}

	private void delete(Node currNode) {
		if (currNode.left != null && currNode.right != null) {
			Node min = findMin(currNode.right);
			currNode.data = min.data;
			delete(min);
		} else {
			Node parent = currNode.parent;
			Node child = (currNode.left != null) ? currNode.left : currNode.right;
			assignParentChild(parent, currNode, child);
			rebalanceDelete(currNode);
		}
	}
	
	private void rebalanceDelete(Node deleted){
		if(deleted.parent == null){
			root.color = type.BLACK;
			return;
		}
		Node parent = deleted.parent;
		Node sibling = getSibling(deleted);
		Node LSibling = sibling.left;
		Node RSibling = sibling.right;
		Node gp;
		if((LSibling == null || LSibling.color == type.BLACK) && (RSibling == null || RSibling.color == type.BLACK) && (sibling != null && sibling.color == type.RED) && parent.color == type.BLACK){
			gp = parent.parent;
			boolean left = deleted.data < parent.data; 
			Node rotated;
			if(left){
				 rotated = rotateLeft(parent);
			} else {
				rotated = rotateRight(parent);
			}
			if(gp == null)
				root = rotated;
			else {
				if(left)
					gp.left = rotated;
				else
					gp.right = rotated;
			}
			sibling.color = type.BLACK;
			parent.color = type.RED;
			sibling = getSibling(deleted);
		}
		if(parent.color == type.BLACK && (sibling != null && sibling.color == type.BLACK) && (LSibling == null || LSibling.color == type.BLACK) && (RSibling == null || RSibling.color == type.BLACK)){
			sibling.color = type.RED;
			rebalanceDelete(parent);
		}
		if(parent.color == type.RED && (sibling != null && sibling.color == type.BLACK) && (LSibling == null || LSibling.color == type.BLACK) && (RSibling == null || RSibling.color == type.BLACK)) {
			parent.color = type.BLACK;
			sibling.color = type.RED;
			return;
		}
		if((sibling != null && sibling.color == type.BLACK) && (LSibling != null && LSibling.color == type.RED) && (RSibling != null && RSibling.color == type.BLACK)) {
			sibling = rotateRight(sibling);
		}
		if((sibling != null && sibling.color == type.BLACK) && (RSibling != null && RSibling.color == type.RED)){
			gp = parent.parent;
			rotateLeft(parent);
			parent.color = type.BLACK;
			RSibling.color = type.BLACK;
			return;
		}
	}

	private void eliminateDoubleBlack(Node currNode) {
		Node parent = currNode.parent;
		Node child = (currNode.left != null) ? currNode.left : currNode.right;
		if (child != null && (currNode.color == type.RED || child.color == type.RED)) {
			child.color = type.BLACK;
		} else if (parent != null) {
			Node sibling = (parent.data > currNode.data) ? parent.right : parent.left;
			if (sibling != null) {
				if (sibling.color == type.BLACK && ((sibling.right != null && sibling.right.color == type.RED)
						|| (sibling.left != null && sibling.left.color == type.RED))) {
					Node gp = parent.parent;
					// set sibling color to red to force break of red property
					// and
					// can make use of the rebalance method
					sibling.color = type.RED;
					if (sibling.left != null) {
						assignParents(gp, rebalance(parent, sibling.left.data));
					} else {
						assignParents(gp, rebalance(parent, sibling.right.data));
					}
				} else if (sibling.color == type.BLACK) {
					if (parent.color == type.BLACK) {
						parent = recolor(parent);
						eliminateDoubleBlack(parent);
					} else {
						parent = recolor(parent);
					}
				} else if(sibling.color == type.RED){
					if(sibling.data > parent.data){
						assignParents(parent.parent, rotateLeft(parent));
					} else {
						assignParents(parent.parent, rotateRight(parent));
					}
				}
			}
		}
	}

	private void assignParents(Node gp, Node rotated) {
		if (gp == null) {
			root = rotated;
		} else if (gp.data < rotated.data) {
			gp.right = rotated;
			rotated.parent = gp;
		} else {
			gp.left = rotated;
			rotated.parent = gp;
		}
	}

	private Node findMin(Node currNode) {
		if (currNode.left != null)
			findMin(currNode.left);
		return currNode;
	}

	private void assignParentChild(Node parent, Node currNode, Node child) {
		if (parent == null) {
			root = child;
		} else {
			if (parent.data > currNode.data) {
				parent.left = child;
			} else if (parent.data < currNode.data) {
				parent.right = child;
			} else{
				if(parent.left.data == currNode.data){
					parent.left = child;
				} else {
					parent.right = child;
				}
			}
		}
		if(child != null)
			child.parent = parent;
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
					if (gp.parent == null)
						gp.color = type.BLACK;
					else
						gp.color = (gp.color == type.BLACK) ? type.RED : type.BLACK;
				} else {
					if (parent.data < gp.data && child.data < parent.data) {
						return recolor(rotateRight(gp));
					} else if (parent.data > gp.data && child.data > parent.data) {
						return recolor(rotateLeft(gp));
					} else if (parent.data < gp.data && child.data > parent.data) {
						gp.left = rotateLeft(parent);
						return recolor(rotateRight(gp));
					} else if (parent.data > gp.data && child.data < parent.data) {
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
		if (parent.left != null)
			parent.left.color = type.RED;
		if (parent.right != null)
			parent.right.color = type.RED;
		return parent;
	}

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
			return (currNode.parent.data > currNode.data) ? currNode.parent.right : currNode.parent.left;
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
