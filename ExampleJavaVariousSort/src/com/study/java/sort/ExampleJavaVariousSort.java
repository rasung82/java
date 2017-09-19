package com.study.java.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExampleJavaVariousSort {

	public static void main(String[] args) {
		final int[] numbers = {6, 5, 4, 8, 2, 11, 9};
		//bubbleSort(numbers);
		//insertSort(numbers);
		
		List<Integer> numberList = new ArrayList<>();
	    for(int number : numbers){
	    	 numberList.add(number);
	    }
		numberList = quickSort(numberList);
		for(Integer number : numberList){
			System.out.print(number+" ");
		}
	}
	
	/**
	 * Bubble Sort
	 * @param numbers
	 */
	public static void bubbleSort(final int[] numbers){
		boolean isNumberSwitched;
		
		do{
			isNumberSwitched = false;
			for(int i=0; i<numbers.length-1 ; i++){
				if(numbers[i+1] < numbers[i]){ 
					int temp = numbers[i+1];
					numbers[i+1] = numbers[i];
					numbers[i] = temp;
					isNumberSwitched = true;
				}
			}
		}while(isNumberSwitched);
		
		for(int number : numbers){
			System.out.print(number);
		}
		System.out.println();
	}
	
	
	/**
	 * Insert Sort
	 * @param numbers
	 */
    public static void insertSort(final int[] numbers){
    	final List<Integer> sortedList  = new LinkedList<Integer>();
    	
    	label: 
    	for(int number : numbers){
    		for(int i=0; i<sortedList.size(); i++){
    			if(number < sortedList.get(i)){
    				sortedList.add(i, number);
    				continue label;
    			}
    		}
    		sortedList.add(sortedList.size(), number);
    	}
    	
    	for(Integer number : sortedList){
    		System.out.print(number);
    	} 
    	System.out.println();
	}
    
    
    /**
     * Quick Sort
     * @param numbers 
     */
    public static List<Integer> quickSort(final List<Integer> numbers){
    	if(numbers!=null && numbers.size()<2){
    		return numbers;
    	}
    	
    	int pivot = numbers.remove(0);
    	List<Integer> lower  = new ArrayList<>();
    	List<Integer> higher = new ArrayList<>();
    	
    	for(Integer number : numbers){
    		if(number < pivot){
    			lower.add(number);
    		}else{
    			higher.add(number);
    		}
    	}
    	
    	List<Integer> r1 = quickSort(lower);
    	List<Integer> r2 = quickSort(higher);
    	   	
    	return merge(r1, r2, pivot);
	}

    /**
     * Merge for Quick Sort
     * @param lower
     * @param higher
     * @return
     */
    public static List<Integer> merge(final List<Integer> lower, final List<Integer> higher, int pivot){
    	final List<Integer> sortedList = new ArrayList<Integer>();
    	
    	for(Integer number : lower){
    		sortedList.add(number);
    	}
    	
    	sortedList.add(pivot);
    	
    	for(Integer number : higher){
    		sortedList.add(number);
    	}
    	
    	return sortedList;
    }

}

