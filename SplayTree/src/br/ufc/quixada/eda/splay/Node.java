package br.ufc.quixada.eda.splay;

import java.util.Objects;

public class Node<T extends Comparable<T>> {
	private T value;
	private Node<T> right = null;
	private Node<T> left = null;
	public Node() {
		this.value = null;
	}
	public Node(T value) {
		this.value = value;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public Node<T> getRight() {
		return right;
	}
	public void setRight(Node<T> right) {
		this.right = right;
	}
	public Node<T> getLeft() {
		return left;
	}
	public void setLeft(Node<T> left) {
		this.left = left;
	}
	@SuppressWarnings("unchecked")
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null) {
			return false;
		}
		if (getClass() != other.getClass()) {
			return false;
		}
		Node<T> node = (Node<T>) other; //TODO: check if this xit works properly
		return Objects.equals(value, node);
	}
}
