package com.yzj.zpjie.builder;

public class Person {
	
	private int gender;
	
	private int age;
	
	private long id;
	
	private String name;

	private String address;
	
	private String email;
	
	static class Builder{
		
		private int gender;
		
		private int age;
		
		private long id;
		
		private String name;

		private String address;
		
		private String email;
		
		public Builder(long id, String name) {
			this.id = id;
			this.name = name;
		}
		
		public Builder age(int age){
			this.age = age;
			return this;
		}
		
		public Builder gender(int gender){
			this.gender = gender;
			return this;
		}
		
		public Builder address(String address){
			this.address = address;
			return this;
		}
		
		public Builder email(String email){
			this.email = email;
			return this;
		}
		
		public Person builder(){
			return new Person(this);
		}	
	}
	
	public Person(Builder builder){
		
		this.gender = builder.gender;
		this.age = builder.age;
		this.id = builder.id;
		this.name = builder.name;
		this.address = builder.address;
		this.email = builder.email;
		
	}

	@Override
	public String toString() {
		return "Person [gender=" + gender + ", age=" + age + ", id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + "]";
	}
	
	

}
