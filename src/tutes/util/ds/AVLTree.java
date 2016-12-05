package tutes.util.ds;

public class AVLTree {
	Node root;

	public AVLTree(int initData) {
		root = new Node(initData);
	}
	
	public Node getRoot(){
		return root;
	}

	public void traverse() {
		traverse(root);
		System.out.println();
	}

	private void traverse(Node currNode) {
		if (currNode.left != null) {
			traverse(currNode.left);
		}
		System.out.print(currNode.data + " ");
		if (currNode.right != null) {
			traverse(currNode.right);
		}
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	private Node insert(Node currNode, int data) {
		if (currNode == null)
			return new Node(data);
		if (currNode.data > data) {
			currNode.left = insert(currNode.left, data);
		} else if (currNode.data < data) {
			currNode.right = insert(currNode.right, data);
		} else {
			return currNode;
		}
		currNode.height = getNewHeight(currNode);
		currNode = rebalance(currNode, data);
		return currNode;
	}

	private Node rebalance(Node currNode, int data) {
		int balance = getBalance(currNode);
		if (balance < -1 && currNode.right.data < data) {
			return rotateLeft(currNode);
		} else if (balance > 1 && currNode.left.data > data) {
			return rotateRight(currNode);
		} else if (balance < -1 && currNode.right.data > data) {
			currNode.right = rotateRight(currNode.right);
			return rotateLeft(currNode);
		} else if (balance > 1 && currNode.left.data < data) {
			currNode.left = rotateLeft(currNode.left);
			return rotateRight(currNode);
		}
		return currNode;
	}

	private int getBalance(Node currNode) {
		int leftH = (currNode.left == null) ? 0 : currNode.left.height;
		int rightH = (currNode.right == null) ? 0 : currNode.right.height;
		return leftH - rightH;
	}

	private Node rotateLeft(Node oldRoot) {
		Node newRoot = oldRoot.right;
		Node newChildRight = newRoot.left;
		oldRoot.right = newChildRight;
		newRoot.left = oldRoot;
		oldRoot.height = getNewHeight(oldRoot);
		newRoot.height = getNewHeight(newRoot);
		return newRoot;
	}

	private Node rotateRight(Node oldRoot) {
		Node newRoot = oldRoot.left;
		Node newChildLeft = newRoot.right;
		oldRoot.left = newChildLeft;
		newRoot.right = oldRoot;
		oldRoot.height = getNewHeight(oldRoot);
		newRoot.height = getNewHeight(newRoot);
		return newRoot;
	}

	private int getNewHeight(Node currNode) {
		return Math.max(((currNode.left == null) ? 0 : currNode.left.height),
				((currNode.right == null) ? 0 : currNode.right.height)) + 1;
	}

	class Node {
		int height;
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.height = 1;
		}

		@Override
		public String toString() {
			// return "Node [height=" + height + ", data=" + data + "]";
			String result = "[data=" + data + ", left=" + left + ", right=" + right + "]";
			return result;
		}
	}
}
