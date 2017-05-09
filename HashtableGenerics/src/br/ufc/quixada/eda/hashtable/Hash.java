package br.ufc.quixada.eda.hashtable;

public abstract class Hash<T>{
	protected int maxSize;
	protected int size = 0;
	protected abstract int hash(int key);
	public abstract boolean insert(T value, int key);
	public int getSize(){
		return size;
	}
	public abstract boolean remove(int key);
	public abstract T get(int key);
}
