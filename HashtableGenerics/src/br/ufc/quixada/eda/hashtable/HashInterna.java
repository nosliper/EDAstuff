package br.ufc.quixada.eda.hashtable;

public class HashInterna<T> extends Hash<T>{
	private Node<T>[] table = null;
	private int size = 0;
	private int emptyKey = -1;
	public HashInterna(int maxSize) {
		this.maxSize = maxSize;
		this.table = new Node<T>[this.maxSize];
		for (int i = 0; i < table.length; i++) {
			table[i] = empty();
		}
	}
	private Node<T> empty() {
		return new Node<T>(null, emptyKey);
	}
	protected int hash(int key) {
		int index = key % maxSize;
		while(table[index].getKey() != emptyKey) { //TODO: fix error with keys bigger than the maxSize
			index = (index + 1) % maxSize;
		}
		return index;
	}
	public boolean existsKey(int key) {
		return table[hash(key)].getKey() != emptyKey;
	}
	public T get(int key) {
		return table[hash(key)].getValue();
	}
	public boolean insert(T value, int key) throws FullTableException {
		try{
			int index = hash(key);
			if (getSize() == maxSize) {
				throw new FullTableException();
			}
			else if (table[index].getKey() == emptyKey) {
				table[index] = new Node<T>(value, key);
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
	@SuppressWarnings("unchecked")
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
