package br.ufc.quixada.eda.hashtable;

public class HashInterna {
	private Node[] table = null;
	private int maxSize;
	private int size = 0;
	private int emptyKey = -1;
	private double reHashFactor = 0.75;
	public HashInterna(int maxSize) {
		this.maxSize = maxSize;
		this.table = new Node[this.maxSize];
		for (int i = 0; i < table.length; i++) {
			table[i] = empty();
		}
	}
	private Node empty() {
		return new Node(null, emptyKey);
	}
	private int hash(int key) {
		int index = key % maxSize;
		while(table[index].getKey() != emptyKey) { //TODO: fix error with keys bigger than the maxSize
			index = (index + 1) % maxSize;
		}
		return index;
	}
	private void reHash() { //TODO: this approach won't work on dam java
		Node[] newTable = new Node[2 * maxSize];
		for (int i = 0; i < maxSize; i++) {
			newTable[i] = table[i];
		}
		maxSize *= 2;
		table = newTable;
	}
	public boolean existsKey(int key) {
		return table[hash(key)].getKey() != emptyKey;
	}
	public boolean existsValue(String value) {
		for (Node node : table) {
			if (node.getValue() != null && node.getValue().equals(value)) {
				return true;
			}
		}
		return false;
	}
	public int getSize() {
		return size;
	}
	public Node get(int key) {
		return table[hash(key)];
	}
	public boolean insert(String value, int key) {
		int index = hash(key);
		if (table[index].getKey() == emptyKey) {
			table[index] = new Node(value, key);
			size += 1;
			if (size >= maxSize * reHashFactor) {
				reHash();
			}
			return true;
		}
		return false;
	}
	public boolean remove(int key) {
		int index = hash(key);
		if (table[index].getKey() != emptyKey) { 
			table[index] = empty();
			size -= 1;
			return true;
		}
		return false;
	}
}
