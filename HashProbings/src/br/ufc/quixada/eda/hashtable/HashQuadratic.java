package br.ufc.quixada.eda.hashtable;

public class HashQuadratic<T> extends HashLinear<T> {
	public HashQuadratic(int maxSize) {
		super(maxSize); //TODO: set it not to ever reach over half full
		int ex = maxSize - nearestPrime(maxSize);
		for (int i = 0; i < ex; i++) {
			table.add(empty());
		}
	}
	public boolean isPrime(int number){ //processou o primo 999 999 999 989 em 0.186 segundos na minha máquina, em python xD
		if (number == 1 || number % 2 == 0)
			return number != 2? false : true;
		double root = Math.sqrt(number);
		for (int div = 3; div <= root; div += 2) {
			if (number % div == 0) {
				return false;
			}
		}
		return true;
	}
	private int nearestPrime(int number){
		if (!isPrime(number)) {
			while(!isPrime(number)){
				number += number % 2 == 0? 1 : 2;
			}
		}
		return number;
	}
	@Override
	protected int hash(int key) {
		int index = key % maxSize;
		int currKey = table.get(index).getKey();
		int i = 1;
		while (currKey != -1 && currKey != key) {
			index = (key + i * i) % maxSize;
		}
		return index;
	}
}
