package tutes.util.ds;

public class RedBlackTree {

	Node root;

	public RedBlackTree(int data) {
		root = new Node(data, type.BLACK);
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	private Node insert(Node currNode, int data) {
		if (currNode == null)
			return new Node(data);
		if (currNode.data > data) {
			currNode.left = insert(currNode.left, data);
			currNode.left.parent = currNode;
		} else if (currNode.data < data) {
			currNode.right = insert(currNode.right, data);
			currNode.right.parent = currNode;
		} else {
			return currNode;
		}

		currNode = rebalance(currNode, data);

		return currNode;
	}

	private Node rebalance(Node currNode, int data) {
		Node child = (currNode.left != null && currNode.left.data == data) ? currNode.left : currNode.right;
		Node sibling;
		if(breaksRedProp(currNode, child)){
			sibling = getSibling(currNode);
			if(sibling != null && sibling.color == type.RED){
				sibling.color = type.BLACK;
				currNode.color = type.BLACK;
				swapColorsUpTree(currNode.parent);
			} else {
				if(currNode.data < currNode.parent.data && child.data < currNode.data){
					return rotateRight(currNode.parent);
				} else if(currNode.data > currNode.parent.data && child.data > currNode.data){
					return rotateLeft(currNode.parent);
				}
			}
		} 
		return null;
	}

	private Node rotateLeft(Node oldRoot) {
		Node newRoot = oldRoot.right;
		Node newChildRight = newRoot.left;
		oldRoot.right = newChildRight;
		newRoot.parent = oldRoot.parent;
		oldRoot.parent = newRoot;
		newRoot.color = type.BLACK;
		oldRoot.color = type.RED;
		
		return newRoot;
	}

	private Node rotateRight(Node oldRoot) {
		Node newRoot = oldRoot.left;
		Node newChildLeft = newRoot.right;
		oldRoot.left = newChildLeft;
		newRoot.parent = oldRoot.parent;
		oldRoot.parent = newRoot;
		newRoot.color = type.BLACK;
		oldRoot.color = type.RED;
		
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
	}

	private enum type {
		RED, BLACK
	}
}
