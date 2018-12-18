package com.turingschool.demo.algo.sort;

import java.util.Arrays;

public class BubbleSorter implements Sorter {

	@Override
	public void sort(int[] arr) {
		if(arr == null || arr.length <= 1) {
			return;
		}
		
		//平均和最坏O(n^2)，最好O(n)
		for(int i=0; i<arr.length; i++) {
			boolean flag = false;
			for(int j=0; j<arr.length - i - 1; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
					flag = true;
				}
				
			}
			
			if(!flag) break;
		}
 
	}

	public static void main(String[] args) {
		int[] arrayToSort = SortUtils.buildRandomIntArray(10);
		SortUtils.printArray(arrayToSort);
		
		int[] arrayClone = Arrays.copyOf(arrayToSort, arrayToSort.length);
		
		Arrays.sort(arrayClone);
		Sorter sorter  = new BubbleSorter();
		sorter.sort(arrayToSort);
		SortUtils.printArray(arrayToSort);

		if(SortUtils.isEquals(arrayToSort, arrayClone)) 
		{
			System.out.println("The two array is equal ...");
		}else {
			System.out.println("The two array is not equal ...");
		}
	}
}
