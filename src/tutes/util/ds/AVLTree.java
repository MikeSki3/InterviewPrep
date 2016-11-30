package tutes.util.ds;

public class AVLTree {

	Node root;

	public AVLTree(int root) {
		this.root = new Node(root);
	}

	public Node insert(int newVal) {
		Node newNode = new Node(newVal);
		return insert(root, newNode);
	}

	public Node insert(Node currNode, Node newNode) {
		if (currNode.data > newNode.data) {
			if (currNode.left != null)
				currNode = insert(currNode.left, newNode);
			else
				currNode.left = newNode;
		} else if (currNode.data < newNode.data) {
			if (currNode.right != null)
				currNode = insert(currNode.right, newNode);
			else
				currNode.right = newNode;
		}
		currNode.height += getMaxHeight(currNode.left, currNode.right);

		return newNode;
	}

	private int getMaxHeight(Node left, Node right) {
		if(left != null && right != null)
			return Math.max(left.height, right.height);
		else if(left != null)
			return left.height;
		else if(right != null)
			return right.height;
		else
			return 1;
	}

	class Node {
		int data;
		int height;
		Node left;
		Node right;

		public Node(int d) {
			data = d;
			height = 1;
		}

		public boolean hasChildren() {
			return left != null || right != null;
		}
	}
}
