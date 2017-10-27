package com.study.scjp;

public class Problem04 {

	public static void main(String[] args) {
		A a = new B();
		a.process();
	}
	
	static class A {
		void process() throws Exception {
			throw new Exception();
		}
		
	}
	
	static class B extends A {
		void process(){
			System.out.println("B");
		}
	}
	
	class C extends A {
		@Override
		void process() throws Exception {
			System.out.println("C");
		}
	}
	
}


