package com.smartdev.java.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExampleJavaVariousSort {

	public static void main(String[] args) {
		final int[] numbers = {6, 5, 4, 8, 2, 11, 9};
		//bubbleSort(numbers);
		//insertSort(numbers);
		//quickSort(numbers);
	}
	
	/**
	 * 버블정렬
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
			System.out.println(number);
		}
	}
	
	/**
	 * 삽입정렬
	 * @param numbers
	 */
    public static void insertSort(final int[] numbers){
    	final List<Integer> sortedList  = new LinkedList<Integer>();
    	
    	originalList: for(int number : numbers){
    		for(int i=0; i<sortedList.size(); i++){
    			if(number < sortedList.get(i)){
    				sortedList.add(i, number);
    				continue originalList;
    			}
    		}
    		sortedList.add(sortedList.size(), number);
    	}
    	
    	for(Integer number : sortedList){
    		System.out.println(number);
    	}   	
	}
    
    /**
     * 퀵정렬(피봇정렬)
     * @param numbers 
     */
    public static List<Integer> quickSort(final List<Integer> numbers){
    	System.out.println("quickSort(" +numbers+ ")");
    	if(numbers!=null && numbers.size()<2){
    		return numbers;
    	}
    	
    	int pivot = numbers.get(0);
    	final List<Integer> lower  = new ArrayList<>();
    	final List<Integer> higher = new ArrayList<>();
    	
    	for(Integer number : numbers){
    		if(number < pivot){
    			lower.add(number);
    		}else{
    			higher.add(number);
    		}
    	}
    	   	
    	return null;
    			
	}

}

