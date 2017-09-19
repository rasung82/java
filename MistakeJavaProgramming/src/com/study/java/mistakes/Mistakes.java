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
	 * 1. �Ϲ� �迭�� ArrayList�� ��ȯ�ϱ�
	 */
	public static void mistake1(){
		// TODO : ��������, ���׸���
		
		// Arrays.asList() �޼���� Arrays�� Private ���� Ŭ������ ArrayList�� �����Ѵ�.
		// ArrayList(java.util.Arrays.ArrayList) Ŭ������ ���Ҹ� �߰�(add), ����(remove)�ϴ� �޼���� ������ ���� �ʴ�.
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
	
		// ArrayList(java.util.ArrayList)�� �ޱ� ���ؼ��� ������ ���� ��ȯ�ϸ� �ȴ�:
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(arrays));
		arrayList.add("Good");
		arrayList.remove("World");
		printElements(arrayList);
	}
	
	
	/**
	 * 2. �Ϲ� �迭�� Ư�� ���� ����ִ��� Ȯ���ϱ�
	 */
	public static void mistake2(){
		String[] arrays = { "Hello", "Java", "World" };
		
		// ���� �Ʒ��� ���� �ڵ带 ���� ����Ѵ�.(?) �� �ڵ�� ���������� list�� set���� ��ȯ�ϴ� ���� ���ʿ��ϴ�.
		Set<String> set = new HashSet<String>(Arrays.asList(arrays));
		printElements(set);
		System.out.println(set.contains("Hello"));

		// �Ʒ��� ���� �ϸ� �����ϴ�.
		System.out.println(Arrays.asList(arrays).contains("Hello"));
	}
	
	
	/**
	 * 3. Loop���� ����Ʈ�� ���Ҹ� �����ϱ�
	 */
	public static void mistake3(){
		String[] arrays = {"Hello","Java","World","!"};
	
		// �Ʒ� �ڵ忡�� ���� �ɰ��� ������ �ִ�. ���Ұ� ������ ��, list�� ����� �پ��鼭 �ٸ� ���ҵ��� index�� �ٲ�� ������. 
		List<String> list = new ArrayList<String>(Arrays.asList(arrays));
		for(int i=0 ; i<list.size() ; i++){
			list.remove(i);
		}
		printElements(list);
		
		//�Ʒ� �ڵ�� ConcurrentModificationException ���ܸ� �߻���Ų��.
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
		
		// remove()���� next()�� ȣ��Ǿ�� �Ѵ�. 
		// loop�ȿ��� ���Ұ� ������ �ڿ� .next()�� ȣ��ȴٸ� �����Ϸ��� ConcurrentModificationException�� �߻���ų ���̴�.
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
