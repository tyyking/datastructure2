package com.turingschool.demo.algo.sort;

import java.util.Arrays;

public class CountSorter implements Sorter {

	@Override
	public void sort(int[] arr) {
		int max = findMax(arr);
		int[] count = new int[max+1];
		count(arr, count);
		rebuild(arr, count);
	}
	
 	public int[] sort2(int[] arr) {
		int max = findMax(arr);
		int[] count = new int[max+1];
		count(arr, count);
		totalCount(count);
		return rebuildV2(arr, count);
	}
	
	private int findMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		
		for(int i: arr) {
			if(i > max)
				max = i;
		}
		
		return max;
	}
	
	private void count(int[] arr, int[] c) {
		for(int i: arr) {
			c[i]++;
		}
	}
	
	private void totalCount(int[] count) {
		int sum = 0;
		for(int i=0; i<count.length; i++) {
			sum += count[i];
			count[i] = sum;
		}
	}

	//totalCount[i]: 到元素i为止，共有多少个元素
	//totalCount[arr[i]]:
	private int[] rebuildV2(int[] arr, int[] totalCount) {
		int[] sortedArr = new int[arr.length];
		
		for(int i=arr.length-1; i>=0; i--) {
			sortedArr[totalCount[arr[i]]-1] = arr[i];
			totalCount[arr[i]]--;
		}
		
		return sortedArr;
		
	}
	private void rebuild(int[] arr, int[] count) {
		int index = 0;
		for(int i=0; i<count.length; i++){
			for(int j=0; j<count[i]; j++) {
				arr[index++] = i;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arrayToSort = SortUtils.buildRandomIntArray(10);
		SortUtils.printArray(arrayToSort);
		
		int[] arrayClone = Arrays.copyOf(arrayToSort, arrayToSort.length);
		
		Arrays.sort(arrayClone);
		CountSorter sorter  = new CountSorter();
		arrayToSort = sorter.sort2(arrayToSort);
		SortUtils.printArray(arrayToSort);

		if(SortUtils.isEquals(arrayToSort, arrayClone)) 
		{
			System.out.println("The two array is equal ...");
		}else {
			System.out.println("The two array is not equal ...");
		}
	}

}
