package br.ufc.quixada.eda.conjuntodisjuntoLE;

public class Main {

	public static void main(String[] args) {
		ConjuntoDisjuntoLE conjunto = new ConjuntoDisjuntoLE(10);
		
		conjunto.union(0, 2);
		conjunto.union(4, 2);
		
		System.out.println(conjunto.findSet(4) == conjunto.findSet(2)? "São do mesmo set" : "Não são do mesmo set");
	}

}
