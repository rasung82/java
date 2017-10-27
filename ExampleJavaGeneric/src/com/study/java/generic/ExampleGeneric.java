package com.study.java.generic;

import java.util.ArrayList;
import java.util.List;


/*
 * 제네릭스(Generics) : JDK1.5에서 추가
 * 다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스에 컴파일 시의 타입 체크(compile-time type check)를 해준다.
 * 컴파일 사에 타입 체크를 해주기 때문에 객체의 타입 안정성을 높이고 형변환의 번거로움이 줄어든다.
 * 쉽게 말해서, 제네릭스란 컬렉션 클래스가 다룰 객체를 미리 명시해줌으로써 형변환을 하지 않고 사용하는 것이다.
 */

public class ExampleGeneric {
	
	public static void main(String[] args) {	
		// 다형성을 사용해야 하는 경우 조상 타입을 지정함을써 여러 종류의 객체를 저장할 수 있다.
		// products는 Product의 자손인 Tv, Audio 객체를 저장할 수 있다. 다만 꺼내올 때 원래의 타입으로 형변환 해야한다. 
		ArrayList<Product> products = new ArrayList<>();
		products.add(new Product());
		products.add(new Tv());
		products.add(new Audio());
		
		Product p = products.get(0);
		Tv tv = (Tv)products.get(1);
		print1(products);
		 
		ArrayList<Tv> tvs = new ArrayList<>();
		tvs.add(new Tv());
		tvs.add(new Tv());
		tvs.add(new Tv());
		//print1(tvs); //컴파일 에러 발생, print1 메소드는 ArrayList<Product>타입의 객체만 넘길 수 있다.
		print2(tvs);
		print3(tvs);
	}
	
	// 매개변수 타입을 ArrayList<Product>로 선언된 경우, 이 메서드의 매개변수로 ArrayList<Product>타입의 객체만 사용할 수 있습니다.
	public static void print1(ArrayList<Product> list){
		for(Product p : list){
			System.out.println(p);
		}
	}
	
	// 제네릭스도 매개변수의 다형성을 이용하여 Product를 상속받은 모든 타입(Audio, Tv)의 객체를 사용할 수 있다.
	public static void print2(ArrayList<? extends Product> list){
		for(Product p : list){
			System.out.println(p);
		}
	}

	//다른 형식의 메서드 
	public static <T extends Product> void print3(List<T> list){
		for(Product p : list){
			System.out.println(p);
		}
	}
}

class Product{};

class Tv extends Product{};

class Audio extends Product{};
