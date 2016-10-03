package com.smartdev.java.generic;

import java.util.ArrayList;


class Product{};

class Tv extends Product{};

class Audio extends Product{};

public class ExampleJavaGeneric {

	public static void main(String[] args) {	
		// 제네릭스란 쉽게말해서 컬렉션 클래스가 다룰 객체를 미리 명시해줌으로써 형변환을 하지 않고 사용하는 것이다.
		ArrayList<Product> products = new ArrayList<>();
		products.add(new Product());
		products.add(new Tv());
		products.add(new Audio());
		print1(products);
		 
		
		ArrayList<Tv> tvs = new ArrayList<>();
		tvs.add(new Tv());
		tvs.add(new Tv());
		tvs.add(new Tv());
		//print1(tvs); //compile error, print1 메소드는 ArrayList<Product>타입의 객체만 넘길 수 있다.
		print2(tvs);
		print3(tvs);
		
		

	}
	
	//매개변수 타입의 ArrayList<Product>로 선언된 경우, 이 메서드의 매개변수로 ArrayList<Product>타입의 객체만 사용할 수 있습니다.
	public static void print1(ArrayList<Product> list){
		for(Product p : list){
			System.out.println(p);
		}
	}
	
	//제네릭스도 매개변수의 다형성을 이용하여 Product를 상속받은 모든 타입(Audio, Tv)의 객체를 사용할 수 있다.
	//다형성이란 쉽게말해서 부모의 참조변수로 자식 객체를 참조할 수 있다라고 생각하면 된다.
	public static void print2(ArrayList<? extends Product> list){
		for(Product p : list){
			System.out.println(p);
		}
	}

	//다른 형식의 메서드 
	public static <T extends Product> void print3(ArrayList<T> list){
		for(Product p : list){
			System.out.println(p);
		}
	}

}


