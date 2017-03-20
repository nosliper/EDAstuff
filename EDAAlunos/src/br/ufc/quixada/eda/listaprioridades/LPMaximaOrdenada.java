package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

/**
 * Implementa a lista de prioridade usando vetor ordenado.
 * Reparem que aqui voc� devem utilizar obrigat�riamente o quickSort 
 * para realizar a ordena��o, quando for necess�rio.
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
		for(int i = 0; i < entrada.size(); i++){
			this.vetor[i] = entrada.get(i);
		}
		n = entrada.size();
		this.quickSort(0, n-1);
	}
	
	public int getMaximaPrioridade(){
		return this.vetor[n-1];
	}
	
	public int remove(){
		return 0;
	}	
	
	public void inserir(int prioridade){
		if(n + 1 < this.nMaximo){
			this.vetor[n] = prioridade;
			n = n + 1;
		}
		this.quickSort(0, n-1);
	}

	public void alterarPrioridade(int prioridade, int novaPrioridade){
		
	}
	
	private void quickSort(int ini, int fim){
		int esq = ini;
		int dir = fim;
		int pivot = this.vetor[(ini + fim)/2];
		while(esq <= dir){
			while(this.vetor[esq] < pivot && esq < fim)
				esq = esq + 1;
			while(this.vetor[dir] > pivot && dir > ini)
				dir = dir - 1;
			if(esq <= dir){
				int aux = this.vetor[esq];
				this.vetor[esq] = this.vetor[dir];
				this.vetor[dir] = aux;
				esq = esq + 1;
				dir = dir - 1;
			}
		}
		if(ini < dir){
			this.quickSort(ini, dir);
		}
		if(esq < fim){
			this.quickSort(esq, fim);
		}
	}
	
	private int particiona(int p, int r){		
		return 0;
	}
}
