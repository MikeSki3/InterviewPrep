package tutes.util.ds;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable<K, V> {
	List<LinkedList<Entry<K, V>>> values;
	LinkedList<Entry<K, V>>[] entries;
	int maxSize;
	double size;
	double collisions;
	
	@SuppressWarnings("unchecked")
	public HashTable(){
		maxSize = 1000;
		values = new ArrayList<>(maxSize);
		entries = (LinkedList<HashTable<K, V>.Entry<K, V>>[]) Array.newInstance(LinkedList.class, maxSize);
		size = 0;
		collisions = 0;
	}
	
	public void put(K key, V value){
		long hash = hash(key);
		int index = getIndex(hash);
		if(entries[index] == null) {
			entries[index] = new LinkedList<>();
			entries[index].add(new Entry<K, V>(key, value));
		} else {
			Entry<K, V> temp = getEntry(key);
			if(temp == null) {
				entries[index].add(new Entry<K, V>(key, value));
				collisions++;
			}
			else
				temp.setValue(value);
		}
		size++;
	}
	
	private Entry<K, V> getEntry(K key) {
		long hash = hash(key);
		int index = getIndex(hash);
		if(entries[index] == null)
			return null;
//		for(Entry<K, V> curr : entries[index]){
		for(int i = 0; i < entries[index].size(); i++){
			Entry<K, V> curr = entries[index].get(i);
			if(curr.getKey().equals(key))
				return curr;
		}
		
		
		return null;
	}

	public V get(K key){
		Entry<K, V> res = getEntry(key);
		return (res == null) ? null : res.getValue();
	}
	
	public double getCollisionRatio(){
		return collisions / size;
	}

	private int getIndex(long hash) {
		return (int)hash % maxSize;
	}

	private long hash(K key) {
		return (key.hashCode()) * 17;
	}
	
	@SuppressWarnings("hiding")
	private class Entry<K, V>{
		K key;
		V value;
		public Entry(K key, V value){
			this.key = key;
			this.value = value;
		}
		public K getKey() {
			return key;
		}
		public void setKey(K key) {
			this.key = key;
		}
		public V getValue() {
			return value;
		}
		public void setValue(V value) {
			this.value = value;
		}
		
		
	}
}
