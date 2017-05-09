package br.ufc.quixada.eda.hashtable;

import java.util.ArrayList;

public class HashInterna<T> extends Hash<T>{
	private ArrayList<Node<T>> table = null;
	private int size = 0;
	private int emptyKey = -1;
	public HashInterna(int maxSize) {
		this.maxSize = maxSize;
		this.table = new ArrayList<Node<T>>();
		for (int i = 0; i < this.maxSize; i++) {
			table.add(empty());
		}
	}
	private Node<T> empty() {
		return new Node<T>(null, emptyKey);
	}
	protected int hash(int key) {
		int index = key % maxSize;
		while(table.get(index).getKey() != emptyKey) { //TODO: fix error with keys bigger than the maxSize
			index = (index + 1) % maxSize;
		}
		return index;
	}
	public boolean existsKey(int key) {
		return table.get(hash(key)).getKey() != emptyKey;
	}
	public T get(int key) {
		return table.get(hash(key)).getValue();
	}
	public boolean insert(T value, int key) throws FullTableException {
		try{
			int index = hash(key);
			if (getSize() == maxSize) {
				throw new FullTableException();
			}
			else if (table.get(index).getKey() == emptyKey) {
				table.set(index, new Node<T>(value, key));
				size += 1;
				return true;
			}
		}
		catch (FullTableException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}
	public boolean remove(int key) {
		int index = hash(key);
		if (table.get(index).getKey() != emptyKey) { 
			table.set(index, empty());
			size -= 1;
			return true;
		}
		return false;
	}
}
