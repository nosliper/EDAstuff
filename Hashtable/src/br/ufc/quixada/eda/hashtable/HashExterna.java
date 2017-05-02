package br.ufc.quixada.eda.hashtable;

import java.util.LinkedList;
import java.util.function.Predicate;

public class HashExterna {
	private LinkedList<Node>[] table = null;
	private int maxSize;
	private int size = 0;
	@SuppressWarnings("unchecked")
	public HashExterna(int maxSize) {
		this.maxSize = maxSize;
		table = new LinkedList[maxSize];
		for (int i = 0; i < table.length; i++) {
			table[i] = new LinkedList<Node>();
		}
	}
	private int hash(int key) {
		return key % maxSize;
	}
	public boolean existsKey(int key) {
		int index = hash(key);
		for (Node node : table[index]) {
			if (node.getKey() == key) {
				return true;
			}
		}
		return false;
	}
	public boolean existsValue(String value) {
		for (int i = 0; i < table.length; i++) {
			for (Node node : table[i]) {
				if (node.getValue().equals(value)) {
					return true;
				}
			}
		}
		return false;
	}
	class RemoveFilter<T> implements Predicate<T> { //basic jerry-rig a.k.a gambiarra
		private T node;
		public boolean test(T node2) {
			if (node.equals(node2)) {
				return true;
			}
			return false;
		}
		public void setNode(T node) {
			this.node = node;
		}
	}
	public boolean insert(String value, int key) {
		int index = hash(key);
		if (!existsValue(value) && !existsKey(key)) { //yep, esses calls custam caro xD
			table[index].add(new Node(value, key));
			size += 1;
			return true;
		}
		return false;
	}
	public boolean remove(int key) {
		int index = hash(key);
		RemoveFilter<Node> nodeIsEqual = new RemoveFilter<>();
		nodeIsEqual.setNode(get(key));
		return table[index].removeIf(nodeIsEqual);
	}
	public int getSize() {
		return size;
	}
	public Node get(int key) {
		int index = hash(key);
		for(Node node : table[index]) {
			if (node.getKey() == key) {
				return node;
			}
		}
		return null;
	}
}