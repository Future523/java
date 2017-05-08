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
		fruits.add(new Apple("apple3")); // 可以放入Fruit的子类对象
		fruits.add(new RedApple("redApple1")); // 可以放入Apple的子类对象
		fruits.add(new Fruit("fruits1"));

		List<Plant> plants = new ArrayList<>();
		plants.add(new Plant("plant1"));
		plants.add(new Plant("plant2"));
		// ergodic(plants); //编译出错

		ergodicSubList(apples); // 可以赋值给 List<? super Fruit>
		ergodicSubList(fruits); // 可以赋值给 List<? super Fruit>
		// ergodicSubList(plants); // 编译出错

		ergodicSuperList(fruits); // 可以赋值给 List<? super Fruit>
		ergodicSuperList(plants); // 可以赋值给 List<? super Fruit>
		// ergodicSuperList(apples); //编译出错

		
		// 说明？可以匹配任意类型容器
		List<?> objects = plants;
		ergodicUnknownList(objects);
		objects = apples;
		ergodicUnknownList(objects);

		// 说明T在实例化时必须 制定类型
		Main<String> generic = new Main<>();
		generic.add("generic");
		generic.ergodicFixedList();
	}

	/**
	 * List<? extends Fruit> 容器存放类型只能为Fruit子类，遍历list，向上转型为Fruit类
	 */
	private static void ergodicSubList(List<? extends Fruit> fruits) {
		System.out.println("***********ergodicSubList**************");
		for (Fruit fruit : fruits) {
			System.out.println(fruit.getName());
		}
	}

	/**
	 * List<? super Fruit> 容器存放类型只能为Fruit父类，遍历list，需要对类型进行判断
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
	 * List<?>无法确定类型，遍历只能转化为Object
	 */
	private static void ergodicUnknownList(List<?> objects) {
		for (Object object : objects) {
			System.out.println(object.getClass().getName() + ": " + object);
		}
	}

	/**
	 * List<T>确定类型，遍历只能转化为T
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