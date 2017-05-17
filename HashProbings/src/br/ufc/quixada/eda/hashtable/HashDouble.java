package br.ufc.quixada.eda.hashtable;

public class HashDouble<T> extends HashLinear<T> {

	public HashDouble(int maxSize) {
		super(maxSize);
	}
	@Override
	protected int hash(int key) {
		int index = hash1(key);
		int currKey = table.get(index).getKey();
		int k = 1;
		while (currKey != -1 && currKey != key) {
			index = hash1(key) - k * hash2(key, k);
			k += 1;
		}
		return index;
	}
	private int hash1(int key){
		return key % maxSize;
	}
	private int hash2(int key, int k){
		return ((key + k) % maxSize) + 1;
	}
	
}
