package com.yzj.zpjie.generic;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Main<T> extends ArrayList<T> {

	public static void main(String[] args) {

		List<Apple> apples = new ArrayList<>();
		apples.add(new Apple("apple1"));
		apples.add(new Apple("apple2"));

		List<Fruit> fruits = new ArrayList<>();
		fruits.add(new Apple("apple3")); // ���Է���Fruit���������
		fruits.add(new RedApple("redApple1")); // ���Է���Apple���������
		fruits.add(new Fruit("fruits1"));

		List<Plant> plants = new ArrayList<>();
		plants.add(new Plant("plant1"));
		plants.add(new Plant("plant2"));
		// ergodic(plants); //�������

		ergodicSubList(apples); // ���Ը�ֵ�� List<? super Fruit>
		ergodicSubList(fruits); // ���Ը�ֵ�� List<? super Fruit>
		// ergodicSubList(plants); // �������

		ergodicSuperList(fruits); // ���Ը�ֵ�� List<? super Fruit>
		ergodicSuperList(plants); // ���Ը�ֵ�� List<? super Fruit>
		// ergodicSuperList(apples); //�������

		
		// ˵��������ƥ��������������
		List<?> objects = plants;
		ergodicUnknownList(objects);
		objects = apples;
		ergodicUnknownList(objects);

		// ˵��T��ʵ����ʱ���� �ƶ�����
		Main<String> generic = new Main<>();
		generic.add("generic");
		generic.ergodicFixedList();
	}

	/**
	 * List<? extends Fruit> �����������ֻ��ΪFruit���࣬����list������ת��ΪFruit��
	 */
	private static void ergodicSubList(List<? extends Fruit> fruits) {
		System.out.println("***********ergodicSubList**************");
		for (Fruit fruit : fruits) {
			System.out.println(fruit.getName());
		}
	}

	/**
	 * List<? super Fruit> �����������ֻ��ΪFruit���࣬����list����Ҫ�����ͽ����ж�
	 */
	private static void ergodicSuperList(List<? super Fruit> fruits) {
		System.out.println("***********ergodicSuperList**************");
		for (Object fruit : fruits) {
			if (fruit instanceof Fruit) {
				System.out.println(((Fruit) fruit).getName());
			} else {
				System.out.println(((Plant) fruit).getName());
			}
		}
	}

	/**
	 * List<?>�޷�ȷ�����ͣ�����ֻ��ת��ΪObject
	 */
	private static void ergodicUnknownList(List<?> objects) {
		for (Object object : objects) {
			System.out.println(object.getClass().getName() + ": " + object);
		}
	}

	/**
	 * List<T>ȷ�����ͣ�����ֻ��ת��ΪT
	 */
	private void ergodicFixedList() {
		for (T t : this) {
			System.out.println(t.getClass().getName() + ": " + t);
		}

	}
}

class Plant {
	protected String name;

	public Plant() {
	}

	public Plant(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

class Fruit extends Plant {
	public Fruit() {
	}

	public Fruit(String name) {
		this.name = name;
	}
}

class Apple extends Fruit {
	public Apple() {
	}

	public Apple(String name) {
		this.name = name;
	}
}

class Pear extends Fruit {
	public Pear() {
	}

	public Pear(String name) {
		this.name = name;
	}
}

class RedApple extends Apple {
	public RedApple() {
	}

	public RedApple(String name) {
		this.name = name;
	}
}