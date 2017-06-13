package br.ufc.quixada.eda.splay;
/*
 * @author diegoavila
 * */
public class SplayTree<T extends Comparable<T>> {
	private Node<T> root = null;
	public SplayTree() {
		root = null;
	}
	public boolean isEmpty() {
		return root == null;
	}
	private Node<T> rotateLeft(Node<T> nodeA) {
		Node<T> nodeB = nodeA.getRight();
		nodeA.setRight(nodeB.getLeft());
		nodeB.setLeft(nodeA);
		return nodeB;
	}
	private Node<T> rotateRight(Node<T> nodeA) {
		Node<T> nodeB = nodeA.getLeft();
		nodeA.setLeft(nodeB.getRight());
		nodeB.setRight(nodeA);
		return nodeB;
	}
	public boolean insert(T value) {
		if (root == null) {
			root = new Node<T>(value);
			return true;
		}
		root = splay(root, value);
		if (value.compareTo(root.getValue()) < 0) {
			Node<T> newNode = new Node<T>(value);
			newNode.setLeft(root.getLeft());
			newNode.setRight(root);
			root.setLeft(null);
			root = newNode;
			return true;
		}
		else if (value.compareTo(root.getValue()) > 0) {
			Node<T> newNode = new Node<T>(value);
			newNode.setRight(root.getRight());
			newNode.setLeft(root);
			root.setRight(null);
			root = newNode;
			return true;
		}
		else {
			return false;
		}
	}
	public boolean remove(T value) {
		if (root == null) {
			return false; 
		}
		root = splay(root, value);
		if (value.compareTo(root.getValue()) == 0) {
			if (root.getRight() == null) {
				root = root.getLeft();
			}
			//brings up the closest key value to the removed key
			else {
				Node<T> aux = root.getLeft();
				root = root.getRight();
				splay(root, value);
				root.setLeft(aux);
			}
			return true;
		}
		return false;
	}
	public Node<T> search(T value) {
		root = splay(root, value);
		if (value.compareTo(root.getValue()) == 0) {
			return root; 
		}
		return null;
	}
	private Node<T> splay(Node<T> node, T value) { //TODO: reduce this method into small ones
		if (node == null) {
			return null;
		}
		//1. decide for left direction:
		if (value.compareTo(node.getValue()) < 0) {
			if (node.getLeft() == null) {
				return node;
			}
			//2. decides what rotations must be made:
			if (value.compareTo(node.getLeft().getValue()) < 0) {
				Node<T> newLeft = splay(node.getLeft().getLeft(), value);
				node.getLeft().setLeft(newLeft); 
				node = rotateRight(node);
			}
			else if (value.compareTo(node.getLeft().getValue()) > 0) {
				Node<T> newRight = splay(node.getLeft().getRight(), value);
				node.getLeft().setRight(newRight);
				if (node.getLeft().getRight() != null) {					
					node = rotateLeft(node);
				}
			}
			if (node.getLeft() == null) {
				return node;
			}
			else {
				return rotateRight(node);
			}
		}
		//1. '' '' '':
		else if (value.compareTo(node.getValue()) > 0) {
			if (node.getRight() == null) {
				return node;
			}
			//2. '' '' '':
			if (value.compareTo(node.getRight().getValue()) < 0) {
				Node<T> newLeft = splay(node.getRight().getLeft(), value);
				node.getRight().setLeft(newLeft);
				if (node.getRight().getLeft() != null) {
					node = rotateRight(node);
				}
			}
			else if (value.compareTo(node.getRight().getValue()) > 0) {
				Node<T> newRight = splay(node.getRight().getRight(), value);
				node.getRight().setRight(newRight);
				node = rotateLeft(node);
			}
			if (node.getRight() == null) {
				return node;
			}
			else {
				return rotateLeft(node);
			}
		}
		else {
			return node;
		}
	}
}
