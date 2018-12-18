package com.turingschool.demo.algo.sort;

import java.util.Arrays;

public class MergeSorter implements Sorter {

	@Override
	public void sort(int[] arr) {
		if(arr == null || arr.length <= 1) {
			return;
		}
		
		int[] tmp = new int[arr.length];
		sortHelper(arr, tmp, 0, arr.length-1);
	}
	
	
	// T(n) = 2*T(n/2) + O(n) => O(nlogn) 主定理
	public void sortHelper(int[] arr, int[] tmp, int start, int end) {
		if(start >= end) {
			return;
		}
		
		int mid = (start + end) / 2;
		
		sortHelper(arr, tmp, start, mid);
		sortHelper(arr, tmp, mid+1, end);
		
		merge(arr, tmp, start, mid, mid+1, end);
		
	}

	private void merge(int[] arr, int[] tmp, int s1, int e1, int s2, int e2) {
 		
		int i = s1, j = s2, k = 0;
		
		while(i <= e1 && j<= e2) {
			if(arr[i] <= arr[j]) {
				tmp[k++] = arr[i];
				i++;
			}else {
				tmp[k++] = arr[j];
				j++;
			}
		}
		
		while(i <= e1) {
			tmp[k++] = arr[i];
			i++;
		}
		
		while(j <= e2) {
			tmp[k++] = arr[j];
			j++;
		}
		
		for(int l=0; l<k; l++) {
			arr[s1+l] = tmp[l];
		}
	}
	
	public static void main(String[] args) {
		int[] arrayToSort = SortUtils.buildRandomIntArray(10);
		SortUtils.printArray(arrayToSort);
		
		int[] arrayClone = Arrays.copyOf(arrayToSort, arrayToSort.length);
		
		Arrays.sort(arrayClone);
		Sorter sorter  = new MergeSorter();
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
