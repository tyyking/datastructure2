package com.turingschool.demo.algo.sort;

import java.util.Arrays;

public class SelectionSortor implements Sorter {

	//最坏和平均O(n^2)
	//最好O(n^2)
	@Override
	public void sort(int[] arr) {
		if(arr == null || arr.length <= 1)
			return;
		
		for(int i=0; i<arr.length; i++) {
			int minIndex = i;  //i-1已经是排好序的
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			
			int tmp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = tmp;
		}
		
		return;
 
	}

	public static void main(String[] args) {
		int[] arrayToSort = SortUtils.buildRandomIntArray(10);
		SortUtils.printArray(arrayToSort);
		
		int[] arrayClone = Arrays.copyOf(arrayToSort, arrayToSort.length);
		
		Arrays.sort(arrayClone);
		Sorter sorter  = new SelectionSortor();
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
