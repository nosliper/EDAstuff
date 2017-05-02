package br.ufc.quixada.eda.hashtable;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		HashInterna hashI = new HashInterna(10);
		HashExterna hashE = new HashExterna(100);
///*
		System.out.println(hashI.getSize());
		System.out.println(hashI.insert("item1", 5));
		System.out.println(hashI.insert("item2", 9));
		System.out.println(hashI.getSize());
		System.out.println(hashI.remove(5));
		System.out.println(hashI.getSize());
		System.out.println(hashI.existsKey(5));
		System.out.println(hashI.existsValue("item2"));
//*/
/*
		hashE.insert("item3", 67);
		hashE.insert("item4", 87);
		System.out.println(hashE .get(67).getValue());
		System.out.println(hashE.get(87).getValue());
		hashE.remove(87);
		System.out.println(hashE.insert("item3", 65));
		System.out.println(hashE.getSize());
 //*/
	}

}
