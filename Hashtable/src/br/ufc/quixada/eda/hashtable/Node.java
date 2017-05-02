package br.ufc.quixada.eda.hashtable;

public class Node {
	private String value;
	private int key;
	public Node(String value, int key) {
		this.value = value;
		this.key = key;
	}
//	public void setValue(String value) {
//		this.value = value;
//	}
//	public void setKey(int index) {
//		this.key = index;
//	}
	public String getValue() {
		return value;
	}
	public int getKey() {
		return key;
	}
	public boolean equals(Node node){
		return this.key == node.key;
	}
}
