package br.ufc.quixada.eda.hashtable;

import java.util.ArrayList;

public class HashLinear<T> extends Hash<T> {
	private int emptyKey = -1;
	protected ArrayList<Node<T>> table = null;
	public HashLinear(int maxSize) {
		this.maxSize = maxSize;
		this.table = new ArrayList<Node<T>>();
		for (int i = 0; i < this.maxSize; i++) {
			table.add(empty());
		}
	}
	@Override
	protected int hash(int key) {
		int index = key % maxSize;
		int currKey = table.get(index).getKey();
		while (currKey != -1 && currKey != key) {
			index = (key + 1) % maxSize;
		}
		return index;
	}
	@Override
	public boolean insert(T value, int key) {
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

	@Override
	public boolean remove(int key) { //TODO
		int index = hash(key);
		if (table.get(index).getKey() != emptyKey) { 
			table.set(index, empty());
			size -= 1;
			return true;
		}
		return false;
	}

	@Override
	public T get(int key) {
		return table.get(hash(key)).getValue();
	}

}
