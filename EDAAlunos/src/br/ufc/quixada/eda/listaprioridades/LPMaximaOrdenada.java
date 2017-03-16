package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

/**
 * Implementa a lista de prioridade usando vetor ordenado.
 * Reparem que aqui você devem utilizar obrigatóriamente o quickSort 
 * para realizar a ordenação, quando for necessário.
 * @author fabio
 *
 */
public class LPMaximaOrdenada {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int n = 0;
	
	public LPMaximaOrdenada(int Nmaximo){
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo];
	}
	
	public void contruir(List<Integer> entrada){
	}
	
	public int getMaximaPrioridade(){
		return 0;
	}
	
	public int remove(){
		return 0;
	}	
	
	public void inserir(int prioridade){
	}
	
	public void alterarPrioridade(int prioridade, int novaPrioridade){
	}
	
	private void quickSort(int ini, int fim){

	}
	
	private int particiona(int p, int r){		
		return 0;
	}
}
