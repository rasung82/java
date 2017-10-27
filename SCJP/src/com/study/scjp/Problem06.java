package com.study.scjp;

import java.util.ArrayList;

public class Problem06 {

	//intObj가 언제 GC가 되는가 ??
	public static void main(String[] args) {
		new Problem06().genNumbers();
	}
	
	
	public void genNumbers(){
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		for(int i=0 ; i<10 ; i++){
			int value = i * ((int)Math.random());
			Integer intObj = new Integer(value);
			numbers.add(intObj);
		}
		System.out.println(numbers);
	}
}
