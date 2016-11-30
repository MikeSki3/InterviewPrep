package tutes.util.ds;

import java.util.HashMap;

public class Trie {
	
	Node root;
	
	public Trie(){
		root = new Node(null);
	}
	
	public void addWord(String word){
		Node curr = root;
		for (char currLetter : word.toCharArray()) {
			if(curr.getChildNode(currLetter) == null){
				curr = curr.addChildNode(currLetter);
			} else {
				curr = curr.getChildNode(currLetter);
			}
			curr.incrementWords();
		}
	}
	
	public int findWordsWithPartial(String part){
		Node curr = root;
		for(char currLetter : part.toCharArray()){
			if(curr.getChildNode(currLetter) == null)
				return 0;
			else {
				curr = curr.getChildNode(currLetter);
			}
		}
		return curr.getWords();
	}
	
	private class Node {
		private HashMap<Character, Node> children;
		private Character data;
		private boolean isWord;
		private int wordCount;
		
		public Node(Character data) {			
			children = new HashMap<>();
			this.data = data;
			isWord = false;
			wordCount = 0;
		}
		
		public char getCharacter(){
			return data;
		}
		
		public void setIsWord(){
			isWord = true;
		}
		
		public int getWords(){
			return wordCount;
		}
		
		public void incrementWords(){
			wordCount++;
		}
		
		public Node addChildNode(char childData){
			Node newNode = new Node(childData);
			children.put(childData, newNode);
			return newNode;
		}
		
		public void addChildNode(char childData, Node childNode){
			children.put(childData, childNode);
		}
		
		public Node getChildNode(char childData){
			return children.get(childData);
		}
		
		public int getChildrenAmt(){
			return children.size();
		}
	}
}
