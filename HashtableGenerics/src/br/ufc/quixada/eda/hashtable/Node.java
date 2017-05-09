package br.ufc.quixada.eda.hashtable;

public class Node<T> {
	private T value;
	private int key;
	public Node(T value, int key) {
		this.value = value;
		this.key = key;
	}
//	public void setValue(String value) {
//		this.value = value;
//	}
//	public void setKey(int index) {
//		this.key = index;
//	}
	public T getValue() {
		return value;
	}
	public int getKey() {
		return key;
	}
	public boolean equals(Node<T> node){
		return this.key == node.key;
	}
}
