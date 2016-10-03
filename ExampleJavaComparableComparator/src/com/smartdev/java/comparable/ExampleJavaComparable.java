package com.smartdev.java.comparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ExampleJavaComparable {
	
	/**
	 * 지정된 정렬 순서에 맞춰 특정 리스트를 재배열하는 건 흔히 있는일이다.
	 * 리스트는 보통 작은수에서 큰 수로 또는 알파벳 순서 등의 자연스러운 순서로 정렬된다.
	 * 하지만 정렬할 때는 다른 기준을 요구할 수도 있다.
	 * 자바는 정렬을 돕기 위해 Comparable, Comparator 두가지 인터페이스를 제공한다.	 
	 * 
	 * 그럼, Comparable, Comparator 인터페이스의 차이는 무엇인가 ?
	 * Comparable 인터페이스는 자연스로운 순서로 정렬할 때 사용하고,
	 * Comparator 인터페이스는 원하는 대로 정렬 순서로 지정할때 사용한다. 
	 */

	public static void main(String[] args) {
		sortInts();
		sortStringObjects();
		sortNotImplementsComparable();
		sortImplementsComparable();
	}
	
	
	public static void sortInts(){
		final int[] numbers = {-3, -5, 1, 7, 4, -2};
		Arrays.sort(numbers);
		
		for(int number : numbers){
			System.out.println(number);
		}		
	}
	
	//String 클래스는 Comparable 인터페이스를 구현하므로 예상(자연스러운 순서)한 대로 정렬된다.
	public static void sortStringObjects(){
		final String[] strings = {"z","x","y","abc","zzz","zazzy"};
		Arrays.sort(strings);
		
		for(String s : strings){
			System.out.println(s);
		}
	}
	
	//NotImplementsComparable 클래스는 Comparable 인터페이스를 구현하지 않았으므로 ClassCastException 예외가 발생한다.
	public static void sortNotImplementsComparable(){
		final List<NotImplementsComparable> objects = new ArrayList<>();
		objects.add(new NotImplementsComparable());
		objects.add(new NotImplementsComparable());
		objects.add(new NotImplementsComparable());
		
		try{
			Arrays.sort(objects.toArray());
			for(NotImplementsComparable nic : objects){
				System.out.println(nic);
			}
		}catch(ClassCastException cce){
			System.out.println(cce.getMessage());
			
		}
	}
	
	//NotImplementsComparable 클래스는 Comparable 인터페이스를 구현하지 않았으므로 ClassCastException 예외가 발생한다.
	public static void sortImplementsComparable(){
		final List<ImplementsComparable> objects = new ArrayList<>();
		objects.add(new ImplementsComparable());
		objects.add(new ImplementsComparable());
		objects.add(new ImplementsComparable());
		
		try{
			Arrays.sort(objects.toArray());
			for(ImplementsComparable nic : objects){
				System.out.println(nic);
			}
		}catch(ClassCastException cce){
			System.out.println(cce.getMessage());
			
		}
	}
}


class NotImplementsComparable {};


class ImplementsComparable implements Comparable<ImplementsComparable>{
	@Override
	public int compareTo(ImplementsComparable o) {
		return 0;
	}
}


class ImplementsComparator implements Comparator<ImplementsComparator>{
	@Override
	public int compare(ImplementsComparator o1, ImplementsComparator o2) {
		return 0;
	}	
}
