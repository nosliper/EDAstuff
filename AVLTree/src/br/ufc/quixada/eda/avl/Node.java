package br.ufc.quixada.eda.avl;

import java.util.Objects;

public class Node<T extends Comparable<T>> {
	private T value;
	private int height;
	private Node<T> parent = null;
	private Node<T> right = null;
	private Node<T> left = null;
	public Node() {
		this.value = null;
	}
	public Node(T value) {
		this.value = value;
		this.height = 0;
	}
	public Node(T value, Node<T> parent) {
		this.parent = parent;
		this.value = value;
		this.height = 0;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
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
	public Node<T> getParent() {
		return parent;
	}
	public void setParent(Node<T> parent) {
		this.parent = parent;
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
