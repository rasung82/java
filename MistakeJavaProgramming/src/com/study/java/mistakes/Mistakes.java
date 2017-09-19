package com.study.java.mistakes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Mistakes {
	
	public static void main(String[] args) {
		//mistake1();
		//mistake2();
		mistake3();
	}
	
	
	/**
	 * 1. 일반 배열을 ArrayList로 변환하기
	 */
	public static void mistake1(){
		// TODO : 가변인자, 제네릭스
		
		// Arrays.asList() 메서드는 Arrays의 Private 정적 클래스인 ArrayList를 리턴한다.
		// ArrayList(java.util.Arrays.ArrayList) 클래스는 원소를 추가(add), 삭제(remove)하는 메서드는 가지고 있지 않다.
		String[] arrays = { "Hello", "Java", "World" };
		List<String> list = Arrays.asList(arrays);
		try {
			list.add("");
			list.remove("Hello");
		} catch (UnsupportedOperationException uoe) {
			System.out.println(uoe.toString());
		}
		
		System.out.println(list.set(0, "Hi"));
		printElements(list);
	
		// ArrayList(java.util.ArrayList)를 받기 위해서는 다음과 같이 변환하면 된다:
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(arrays));
		arrayList.add("Good");
		arrayList.remove("World");
		printElements(arrayList);
	}
	
	
	/**
	 * 2. 일반 배열에 특정 값이 들어있는지 확인하기
	 */
	public static void mistake2(){
		String[] arrays = { "Hello", "Java", "World" };
		
		// 보통 아래와 같은 코드를 많이 사용한다.(?) 이 코드는 동작하지만 list를 set으로 변환하는 것은 불필요하다.
		Set<String> set = new HashSet<String>(Arrays.asList(arrays));
		printElements(set);
		System.out.println(set.contains("Hello"));

		// 아래와 같이 하면 간결하다.
		System.out.println(Arrays.asList(arrays).contains("Hello"));
	}
	
	
	/**
	 * 3. Loop에서 리스트의 원소를 제거하기
	 */
	public static void mistake3(){
		String[] arrays = {"Hello","Java","World","!"};
	
		// 아래 코드에는 아주 심각한 문제가 있다. 원소가 삭제될 때, list의 사이즈가 줄어들면서 다른 원소들의 index도 바뀌어 버린다. 
		List<String> list = new ArrayList<String>(Arrays.asList(arrays));
		for(int i=0 ; i<list.size() ; i++){
			list.remove(i);
		}
		printElements(list);
		
		//아래 코드는 ConcurrentModificationException 예외를 발생시킨다.
		list = new ArrayList<String>(Arrays.asList(arrays));
		try {
			for (String s : list) {
				if (s.equals("Hello")) {
					list.remove(s);
				}
			}
			printElements(list);
		} catch (ConcurrentModificationException cme) {
			System.out.println(cme.toString());
		}
		
		// remove()전에 next()가 호출되어야 한다. 
		// loop안에서 원소가 삭제된 뒤에 .next()가 호출된다면 컴파일러는 ConcurrentModificationException을 발생시킬 것이다.
		list = new ArrayList<String>(Arrays.asList(arrays));
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			it.next();
			it.remove();
		}
		printElements(list);
	}
	

	/**
	 * 
	 */
	public static <T> void printElements(List<T> list){
		if(list.size() == 0){
			System.out.println("No elements..");
			return;
		}
		for (T t : list) {
			System.out.print(t + " ");
		}
		System.out.println("");
	}
	
	
	public static <T> void printElements(Set<T> list){
		for (T t : list) {
			System.out.println(t);
		}
	}

}
