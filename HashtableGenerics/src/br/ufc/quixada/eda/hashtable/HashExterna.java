package br.ufc.quixada.eda.hashtable;

import java.util.LinkedList;
import java.util.function.Predicate;

public class HashExterna<T> extends Hash<T>{
	private LinkedList<Node<T>>[] table = null;
	private int maxSize;
	private int size = 0;
	@SuppressWarnings("unchecked")
	public HashExterna(int maxSize) {
		this.maxSize = maxSize;
		table = new LinkedList[maxSize];
		for (int i = 0; i < table.length; i++) {
			table[i] = new LinkedList<Node<T>>();
		}
	}
	protected int hash(int key) {
		return key % maxSize;
	}
	public boolean existsKey(int key) {
		int index = hash(key);
		for (Node<T> node : table[index]) {
			if (node.getKey() == key) {
				return true;
			}
		}
		return false;
	}
	class RemoveFilter<G> implements Predicate<G> { //basic jerry-rig a.k.a gambiarra
		private G node;
		public boolean test(G node2) {
			if (node.equals(node2)) {
				return true;
			}
			return false;
		}
		public void setNode(G node) {
			this.node = node;
		}
	}
	public boolean insert(T value, int key) {
		int index = hash(key);
		if (!existsKey(key)) { //yep, esses calls custam caro xD
			table[index].add(new Node<T>(value, key));
			size += 1;
			return true;
		}
		return false;
	}
	public boolean remove(int key) {
		int index = hash(key);
		RemoveFilter<Node<T>> nodeIsEqual = new RemoveFilter<Node<T>>();
		nodeIsEqual.setNode(getNode(key));
		return table[index].removeIf(nodeIsEqual);
	}
	public T get(int key) {
		int index = hash(key);
		for(Node<T> node : table[index]) {
			if (node.getKey() == key) {
				return node.getValue();
			}
		}
		return null;
	}
	private Node<T> getNode(int key){
		int index = hash(key);
		for(Node<T> node : table[index]) {
			if (node.getKey() == key) {
				return node;
			}
		}
		return null;
	}
}