package br.ufc.quixada.eda.hashtable;

public class FullTableException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	@Override
	public String getMessage(){
		return "Table is full!";
	}

}