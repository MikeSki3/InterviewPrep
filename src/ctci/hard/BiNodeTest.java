package ctci.hard;

public class BiNodeTest {

	public static void main(String[] args) {
		BiNode root = createTree();
//		root.inOrder();
		System.out.println(root);
		root = root.transformToLinkedList();
		System.out.println(root);
	}

	private static BiNode createTree() {
		BiNode thisRoot = new BiNode(6);
		thisRoot.add(2);
		thisRoot.add(12);
		thisRoot.add(5);
		thisRoot.add(12);
		thisRoot.add(3);
		thisRoot.add(10);
		thisRoot.add(13);
		thisRoot.add(11);
		
		return thisRoot;
	}

}
