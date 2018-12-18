package com.turingschool.demo.algo.sort;

import java.util.Arrays;

public class InsertionSorter implements Sorter {

	//最坏平均：O(n^2)
	//最好:O(n)
	@Override
	public void sort(int[] arr) {
		if(arr == null || arr.length <= 1) {
			return;
		}
		
		for(int i=1; i<arr.length; i++) {
			int elem = arr[i];
			int j = i - 1;
			
			while(j>=0 && elem < arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			
			arr[j+1] = elem;
		}
		
		return;
 
	}

	public static void main(String[] args) {
		int[] arrayToSort = SortUtils.buildRandomIntArray(10);
		SortUtils.printArray(arrayToSort);
		
		int[] arrayClone = Arrays.copyOf(arrayToSort, arrayToSort.length);
		
		Arrays.sort(arrayClone);
		Sorter sorter  = new InsertionSorter();
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
