package tutes.util.ds.test;

import tutes.util.ds.AVLTree;

public class AVLTreeTest {

	public static void main(String[] args) {
		AVLTree tree = new AVLTree(1);
		tree.insert(10);
		tree.insert(11);
		tree.insert(4);
		tree.insert(5);
		tree.insert(2);
		tree.traverse();
		System.out.println(tree.getRoot());
	}

}
