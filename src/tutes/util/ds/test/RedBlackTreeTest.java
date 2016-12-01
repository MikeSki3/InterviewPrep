package tutes.util.ds.test;

import java.util.Random;

import tutes.util.ds.RedBlackTree;

public class RedBlackTreeTest {

	public static void main(String[] args) {
		printRandTree();
//		RedBlackTree tree = new RedBlackTree(1);
//		tree.insert(10);
//		tree.insert(11);
//		tree.insert(4);
//		tree.insert(5);
//		tree.insert(2);
//		tree.traverse();
//		System.out.println(tree.getRoot());
	}

	private static void printRandTree() {
		Random rand = new Random();
		int bound = 300 + 1;
		RedBlackTree tree = new RedBlackTree(rand.nextInt(bound));
		for(int i = 0; i < 10; i++){
			tree.insert(rand.nextInt(bound));
		}
		tree.traverse();
		System.out.println(tree.getRoot());
	}

}
