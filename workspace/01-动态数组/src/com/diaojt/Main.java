package com.diaojt;


public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> ints = new ArrayList<>();
		ints.add(99);
		ints.add(88);
		ints.add(77);
		ints.add(66);
		ints.add(55);
		ints.add(44);
		System.out.println(ints);

		
		ArrayList<Person> persons = new ArrayList<Person>();
		persons.add(new Person(10, "Jack"));
		persons.add(new Person(12, "James"));
		persons.add(new Person(2, "Rose"));
		System.out.println(persons);
		persons.clear();
		
		// 提醒JVM进行垃圾回收 JVM垃圾回收是不定时的
		System.gc();
		
	}

}
