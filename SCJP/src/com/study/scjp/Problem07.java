package com.study.scjp;

public class Problem07 {
	
	public static final String FOO = "foo";
	
	public static void main(String[] args) {
		Problem07 problem07 = new Problem07();
		Sub s = new Sub();
		
		System.out.println(Problem07.FOO);
		System.out.println(Sub.FOO);
		System.out.println(problem07.FOO);
		System.out.println(s.FOO);
		System.out.println(((Problem07)s).FOO);
	}
}

class Sub extends Problem07 {
	public static final String FOO = "bar";
}

