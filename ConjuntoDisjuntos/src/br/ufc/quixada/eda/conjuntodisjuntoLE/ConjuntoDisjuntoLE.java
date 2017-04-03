package br.ufc.quixada.eda.conjuntodisjuntoLE;

public class ConjuntoDisjuntoLE {
	private Node[] mainList;
	private int numSets;
	public ConjuntoDisjuntoLE(int numSets) {
		this.mainList = new Node[numSets];
		this.numSets = numSets;
		makeSet();
	}
	public void makeSet(){
		for(int i = 0; i < numSets; i++){
			mainList[i] = new Node(1);
			mainList[i].setNext(new Node(i));
		}
	}
	public void union(int set1, int set2){
		if(mainList[set1].getValue() < mainList[set2].getValue()){
			link(set1, set2);
			mainList[set1].setValue(mainList[set1].getValue() + 1);
		}
		else if(mainList[set1].getValue() > mainList[set2].getValue()){
			link(set2, set1);
			mainList[set2].setValue(mainList[set2].getValue() + 1);
		}
		else{
			link(set1, set2);
			mainList[set1].setValue(mainList[set1].getValue() + 1);
		}
	}
	private void link(int minorSet, int greaterSet){
		this.findLast(greaterSet).setNext(mainList[minorSet].getNext());
		this.update(mainList[minorSet], greaterSet);
	}
	private void update(Node init, int newValue){
		while(init != null){
			init.setValue(newValue);
			init = init.getNext();
		}
	}
	private Node findLast(int index){
		Node node = mainList[index];
		while(node != null){
			if(node.getNext() == null){
				return node;
			}
			node = node.getNext();
		}
		return null;
	}
	public int findSet(int index){
		return mainList[index].getNext().getValue();
	}
}
