package tutes.util.ds;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	HashMap<Integer, Node> allNodes;
	HashSet<Node> visited;

	public Graph() {
		allNodes = new HashMap<>();
	}

	public int findConnection(int start, int end) {
		visited = new HashSet<>();
//		int weight = 0;
		Node startNode = getNode(start);
		Node endNode = getNode(end);
		if (startNode == null || endNode == null)
			return -1;
//		weight += BFS(startNode, endNode);
//		return weight;
		return BFSIterative(startNode, endNode);
	}
	
	private int BFSIterative(Node start, Node end){
		int weight = 0;
		Queue<HashMap<Integer, Node>> queue = new LinkedList<>();
		visited = new HashSet<>();
		HashMap<Integer, Node> temp = new HashMap<>();
		temp.put(start.getData(), start);
		queue.add(temp);
		while(!queue.isEmpty()){
			temp = queue.remove();
			if(temp.containsKey(end)){
				return weight;
			}
			for(Node curr : temp.values()){
				if(visited.contains(curr))
					continue;
				visited.add(curr);
				queue.add(curr.getChildren());
				weight += 6;
			}
		}
		return -1;
	}

	private int BFS(Node startNode, Node endNode) {
		Queue<HashMap<Integer, Node>> queue = new LinkedList<>();
		visited.add(startNode);
		if (startNode == endNode)
			return 0;
		else if (startNode.hasChild(endNode))
			return 6;
		else {
			queue.add(startNode.getChildren());
			return BFS(queue, endNode);
		}
		// return 0;
	}

	private int BFS(Queue<HashMap<Integer, Node>> queue, Node endNode) {
		if (queue.size() <= 0)
			return -1;
		HashMap<Integer, Node> nodes = queue.poll();
		int weight = 0;
		if (nodes.containsKey(endNode.getData()))
			return 6;
		else {
			for (Node curr : nodes.values()) {
				if (!visited.contains(curr)) {
					visited.add(curr);
					queue.add(curr.getChildren());
				}
			}
			weight = BFS(queue, endNode);
			return (weight == -1) ? weight : weight + 6;
		}
		// return weight;
	}

	private Node getNode(int key) {
		return allNodes.get(key);
	}

	private void addNode(Node newNode) {
		allNodes.put(newNode.getData(), newNode);
	}

	public boolean nodeExists(int nodeData) {
		return allNodes.containsKey(nodeData);
	}

	public void addEdge(int parentData, int childData) {
		if (nodeExists(parentData) && nodeExists(childData)) {
			getNode(parentData).addChild(getNode(childData));
			getNode(childData).addChild(getNode(parentData));
		} else if (nodeExists(parentData)) {
			Node child = new Node(childData);
			getNode(parentData).addChild(child);
			child.addChild(getNode(parentData));
			addNode(child);
		} else if (nodeExists(childData)) {
			Node parent = new Node(parentData);
			getNode(childData).addChild(parent);
			parent.addChild(getNode(childData));
			addNode(parent);
		} else {
			Node parent = new Node(parentData);
			Node child = new Node(childData);
			parent.addChild(child);
			child.addChild(parent);
			addNode(parent);
			addNode(child);
		}
	}

	public void addNode(int nodeData) {
		if (!allNodes.containsKey(nodeData))
			allNodes.put(nodeData, new Node(nodeData));
	}

	private class Node {
		private int data;
		private HashMap<Integer, Node> children;

		public Node(int data) {
			this.data = data;
			children = new HashMap<>();
		}

		public boolean hasChild(Node endNode) {
			return children.containsKey(endNode.getData());
		}

		public void addChild(Node node) {
			children.put(node.getData(), node);
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public HashMap<Integer, Node> getChildren() {
			return children;
		}

		public void setChildren(HashMap<Integer, Node> children) {
			this.children = children;
		}

	}
}
