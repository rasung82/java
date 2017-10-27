package com.study.scjp;

import java.io.IOException;

public class Problem05 {
	
	class A {
		public void process(){
			System.out.println("A");
		}
	}
	
	class B extends A {
		@Override
		public void process() throws IOException {
			super.process();
			System.out.println("B");
			throw new IOException();
		}
		
		
	}

}
