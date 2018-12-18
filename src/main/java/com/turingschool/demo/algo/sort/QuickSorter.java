package com.turingschool.demo.algo.sort;

import java.util.Arrays;

public class QuickSorter implements Sorter {

	final static int THRESHOLD = 10;
	
	public void sortThreeWay(int[] arr, int start, int end) {
		if(end - start <= THRESHOLD - 1) {
			insertSort(arr, start, end);
			return;
		}
		
		int pivot = arr[start];
		int lt = start;
		int gt = end;
		int i = start + 1;
		
		//手动模拟一遍？？
		while(i <= gt) {
			if(arr[i] < pivot) {
				swap(arr, lt, i);
				lt++;
				i++;
			}else if (arr[i] > pivot) {
				swap(arr, i, gt--);
			}else {
				i++;
			}
		}
		
		sortThreeWay(arr, start, lt-1);
		sortThreeWay(arr, gt+1, end);

	}
	
	
	@Override
	public void sort(int[] arr) {
		if(arr == null || arr.length <= 1) {
			return;
		}
		
		sortThreeWay(arr, 0, arr.length-1);
 
	}
	
	private void sortHelper(int[] arr, int start, int end) {
		if(end - start <= THRESHOLD - 1) {
			insertSort(arr, start, end);
			return;
		}
		//if(start >= end)
		//	return;
		
		int median = meidanOf3Num(arr, start, start+(end-start)/2, end);
		swap(arr, start, median);
		int index = partition2(arr, start, end);
		sortHelper(arr, start, index-1);
		sortHelper(arr, index+1, end);	
	}

	private void insertSort(int[] arr, int start, int end) {
		if(start >= end)
			return;
		
		for(int i=start; i<=end; i++) {
			int elem = arr[i];
			int j=i-1;
			
			while(j>=0 && elem < arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			
		    arr[j+1] = elem;
		}
		
		return;
	}

	private int partition(int[] arr, int start, int end) {
		
		int pivot = arr[start];
		
		int i = start + 1; // start 到i-1的元素都小于pivot
		for(int j=start+1; j<=end; j++ ) {
			if(arr[j] <= pivot) {
				swap(arr, i, j);
				i++;
			}
		}
		
		swap(arr, start, i-1);
		
		return i-1;
	}
	
	private int partition2(int[] arr, int start, int end) {
		int pivot = arr[start];
		
	    while(start < end) {
	    	while(start < end && arr[end]>pivot)
	    		end--;
	    	arr[start] = arr[end];
	    	
	    	while(start<end && arr[start]<=pivot)
	    		start++;
	    	
	    	arr[end] = arr[start];
	    }
	    
	    arr[start] = pivot;
		
		return start;
	}

	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	
	private int meidanOf3Num(int[] arr, int lo, int center, int hi) {
		if (arr[lo] < arr[center]) {
			if(arr[center] < arr[hi]) {
				return center;
			}else {
				return (arr[lo] < arr[hi])?hi:lo;
			}
		}else {
			if(arr[hi] < arr[center]) {
				return center;
			}else {
				return (arr[hi] > arr[lo]) ? hi :lo;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arrayToSort = SortUtils.buildRandomIntArray(100);
		SortUtils.printArray(arrayToSort);
		
		int[] arrayClone = Arrays.copyOf(arrayToSort, arrayToSort.length);
		
		Arrays.sort(arrayClone);
		Sorter sorter  = new QuickSorter();
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
