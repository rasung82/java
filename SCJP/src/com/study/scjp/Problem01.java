package com.study.scjp;

public class Problem01 {

	public static void main(String[] args) {
		A a = new A();
		A b = new B();
		System.out.println(a.greeting() + " has name " + a.getName());
		System.out.println(b.greeting() + " has name " + b.getName());
	}
}

class A {
	String name = "A";

	String getName() {
		return name;
	}

	String greeting() {
		return "class A";
	}
}

class B extends A {
	String name = "B";

	@Override
	String greeting() {
		return "class B";
	}
}
