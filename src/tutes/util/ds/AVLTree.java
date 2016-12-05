package tutes.util.ds;

public class AVLTree {
	Node root;

	public AVLTree(int initData) {
		root = new Node(initData);
	}

	public Node getRoot() {
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

	public void delete(int data) {
		root = delete(root, data);
	}

	private Node delete(Node curr, int data) {
		if (curr == null)
			return curr;
		if (curr.data == data) {
			curr = deleteNode(curr);
		} else if (curr.data > data) {
			curr.left = delete(curr.left, data);
		} else {
			curr.right = delete(curr.right, data);
		}
		if(curr != null)
			curr.height = getNewHeight(curr);
		Node child = getLargerHeightChild(curr);
		Node grandChild = getLargerHeightChild(child);
		if (child != null && grandChild != null) {
			curr = rebalance(curr, grandChild.data);
		}
		return curr;
	}

	private Node getLargerHeightChild(Node curr) {
		if (curr == null)
			return null;
		if (curr.left != null && curr.right != null)
			return (curr.left.height > curr.right.height) ? curr.left : curr.right;
		else if (curr.left != null)
			return curr.left;
		else
			return curr.right;
	}

	private Node deleteNode(Node curr) {
		if (curr == null) {
			throw new IllegalArgumentException("Cannot delete a null node");
		} else {
			if (curr.left != null && curr.right != null) {
				Node min = findMin(curr.right);
				curr.data = min.data;
				curr.right = delete(curr.right, min.data);
			} else if (curr.left != null)
				curr = moveNodeUp(curr, curr.left);
			else if (curr.right != null)
				curr = moveNodeUp(curr, curr.right);
			else
				curr = null;
			return curr;
		}

	}

	private Node moveNodeUp(Node curr, Node child) {
		curr.data = child.data;
		curr.left = child.left;
		curr.right = child.right;
		return curr;
	}

	private Node findMin(Node curr) {
		if (curr.left != null)
			return findMin(curr.left);
		return curr;
	}

	private Node find(Node curr, int data) {
		if (curr == null)
			return null;
		if (curr.data == data)
			return curr;
		else if (curr.data > data)
			return find(curr.left, data);
		else
			return find(curr.right, data);
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

	private int getMaxHeight(Node currNode) {
		return Math.max(((currNode.left == null) ? 1 : currNode.left.height),
				((currNode.right == null) ? 1 : currNode.right.height));
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
