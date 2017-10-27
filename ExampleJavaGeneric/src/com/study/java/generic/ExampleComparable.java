package com.study.java.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExampleComparable {
	
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("74450", "Cho", 80, 90, 90));
		list.add(new Student("74421", "Woo", 100, 90, 90));
		list.add(new Student("74422", "Kim", 100, 80, 90));
		list.add(new Student("74423", "Yon", 100, 100, 90));
		
		Collections.sort(list);
		// Collections.sort 함수의 시그니처
		// public static <T extends Comparable<? super T>> void sort(List<T> list) { ... }
		
		for (Student s : list) {
			System.out.println(s);
		}
	} 

}


class Student extends Person implements Comparable<Student>{
	protected String name;
	protected int korean;
	protected int math;
	protected int english;
	protected int total;
	
	public Student(String id, String name){
		super(id, name);
	}
	
	public Student(String id, String name, int korean, int math, int english) {
		super(id, name);
		this.name = name;
		this.korean = korean;
		this.math = math;
		this.english = english;
		this.total = korean + math + english;
	}

	@Override
	public int compareTo(Student s) {
		return this.total - s.total;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", korean=" + korean + ", math=" + math + ", english=" + english + ", total=" + total + "]";
	}

}


class Person {
	protected String id;
	protected String name;
	
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
}
