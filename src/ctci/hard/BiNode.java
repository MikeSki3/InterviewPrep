package ctci.hard;

public class BiNode {

	public BiNode node1, node2;
	public int data;

	public BiNode(int data) {
		this.data = data;
	}
	
	public BiNode(){};

	public BiNode getNode1() {
		return node1;
	}

	public void setNode1(BiNode node1) {
		this.node1 = node1;
	}

	public BiNode getNode2() {
		return node2;
	}

	public void setNode2(BiNode node2) {
		this.node2 = node2;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BiNode transformToLinkedList() {
		return transform(this);
	}

	private BiNode transform(BiNode biNode) {
		if (biNode.node2 != null) {
			biNode.node2 = transform(biNode.node2);
		}
//		linkRightChild(biNode, biNode.node2);
		while (biNode.node1 != null) {
			biNode = rightRotate(biNode);
		}
		return biNode;
	}

	private BiNode rightRotate(BiNode biNode) {
		BiNode leftChild = biNode.node1;
		BiNode rightChild = biNode.node2;
		BiNode newParent = rightMost(leftChild);
		
		leftChild.node2 = newParent.node1;
		biNode.node1 = newParent;
		newParent.node2 = biNode;
		newParent.node1 = (leftChild == newParent) ? null : leftChild;
		rightChild.node1 = biNode;
		
		return newParent;
	}

	private BiNode rightMost(BiNode curr) {
		if (curr != null) {
			if (curr.node2 != null)
				return rightMost(curr.node2);
		}
		return curr;

	}
	
	public void inOrder(){
		inOrder(this);
	}

	private void inOrder(BiNode biNode) {
		if(biNode.node1 != null)
			inOrder(biNode.node1);
		System.out.print(biNode.data + " ");
		if(biNode.node2 != null)
			inOrder(biNode.node2);
	}
	
	public void add(int data){
		if(data > this.data){
			this.node2 = add(this.node2, data);
		} else if(data < this.data){
			this.node1 = add(this.node1, data);
		}
	}

	private BiNode add(BiNode biNode, int data) {
		if(biNode != null){
			if(biNode.data > data){
				biNode.node1 = add(biNode.node1, data);
			} else if(biNode.data < data){
				biNode.node2 = add(biNode.node2, data);
			}
		} else {
			return new BiNode(data);
		}
		return biNode;
	}

	@Override
	public String toString() {
		return "data=" + data + "[node1=" + ((node1 != null) ? node1.data : null) + ", node2=" + ((node2 != null) ? node2.data : null) + "]";
	}
	
	
}
