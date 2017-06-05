package br.ufc.quixada.eda.avl;
//NOTE: I should use protected visibility instead of encapsulation, but well, whatever...
public class Tree<T extends Comparable<T>> {
	private Node<T> root;
	public Tree() {
		root = null;
	}
	public boolean isEmpty() {
		return root == null;
	}
	public void insert(T value) {
		insert(value, root);
	}
	private Node<T> insert(T value, Node<T> node) {
		if (node == null) {
			node = new Node<T>(value);
		}
		else if (value.compareTo(node.getValue()) < 0) {
			node.setLeft(insert(value, node.getLeft()));
			if (height(node.getLeft()) - height(node.getRight()) == 2) { //1. tests if must rotate
				if (value.compareTo(node.getLeft().getValue()) < 0) {    //2. tests direction of rotation
					node = rotateLeft(node);
				}
				else {
					node = doubleRotateLeft(node);
				}
			}
		}
		else if (value.compareTo(node.getValue()) > 0) {
			node.setRight(node.getRight());
			if (height(node.getRight()) - height(node.getLeft()) == 2) { //1. '' ''
				if (value.compareTo(node.getRight().getValue()) > 0) {   //2. '' '' (in order not to bug myself)
					node = rotateRight(node);
				}
				else {
					node = doubleRotateRight(node);
				}
			}
		}
		int lH = node.getLeft().getHeight();
		int rH = node.getRight().getHeight();
		node.setHeight(max(lH, rH) + 1);
		return node;
	}
	private int max(int a, int b) {
		return Math.max(a, b);
	}
	private int height(Node<T> node) {
		return node != null? node.getHeight() : -1;
	}
	private Node<T> rotateLeft(Node<T> nodeA) {
		Node<T> nodeB = nodeA.getRight();
		nodeB.setParent(nodeA.getParent());
		nodeA.setRight(nodeB.getLeft());
		nodeB.setLeft(nodeA);
		nodeA.setParent(nodeB);
		int aL = height(nodeA.getLeft());
		int aR = height(nodeA.getRight());
		nodeA.setHeight(max(aL, aR) + 1);
		int bR = height(nodeB.getRight());
		nodeB.setHeight(max(bR, nodeA.getHeight()) + 1);
		return nodeB;
	}
	private Node<T> rotateRight(Node<T> nodeA) {
		Node<T> nodeB = nodeA.getLeft();
		nodeB.setParent(nodeA);
		nodeA.setLeft(nodeB.getRight());
		nodeB.setRight(nodeA);
		nodeA.setParent(nodeB);
		int aL = height(nodeA.getLeft());
		int aR = height(nodeA.getRight());
		nodeA.setHeight(max(aL, aR) + 1);
		int bR = height(nodeB.getRight());
		nodeB.setHeight(max(bR, nodeA.getHeight()) + 1);
		return nodeB;
	}
	private Node<T> doubleRotateLeft(Node<T> nodeA) {
		nodeA.setLeft(rotateRight(nodeA).getLeft());
		return rotateLeft(nodeA);
	}
	private Node<T> doubleRotateRight(Node<T> nodeA) {
		nodeA.setRight(rotateLeft(nodeA).getRight());
		return rotateRight(nodeA);
	}
}
