package com.yzj.zpjie.builder;

public class Test {
	public static void main(String[] args) {
		
		Person person = new Person.Builder(1000, "sss").address("ºñµÂÆ·Ô°").age(23).builder();
		System.out.println(person.toString());
	}
}
