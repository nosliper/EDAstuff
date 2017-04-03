package br.ufc.quixada.eda.conjuntodisjunto;

public class ConjuntoDisjunto {
	private int[] mainList;
	private int[] depths;
	private int numSets;
	
	public ConjuntoDisjunto(int numSets) {
		this.mainList = new int[numSets];
		this.depths = new int[numSets];
	}
	public void makeSet(){
		for(int i = 0; i < numSets; i++){
			this.mainList[i] = i;
		}
	}
	public int findSet(int index){
		if(mainList[index] == index){
			return index;
		}
		mainList[index] = findSet(mainList[index]);
		return mainList[index];
	}
	public void union(int set1, int set2){
		int set1Root = this.findSet(set1);
		int set2Root = this.findSet(set2);
		
		if(set1Root == set2Root){
			return;
		}
		else if(depths[set1Root] > depths[set2Root]){
			mainList[set2Root] = set1Root; // set1 pai de set2.
		}
		else if(depths[set2Root] > depths[set1Root]){
			mainList[set1Root] = set2Root; // set2 pai de set1
		}
		else{
			mainList[set1Root] = set2Root;
			depths[set2Root] += 1;
		}
	}
}
