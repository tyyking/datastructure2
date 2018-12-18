package com.turingschool.demo.algo.sort;

public class RecursiveAlg {
	
	private static class Node {
		int val;
		Node next;
	}
	
	public long m(int n) {
		if(n==0)
			return 1;
		
		return n* m(n-1);
	}
	
	public long F(int n) {
		if(n == 0 || n==1)
			return 1;
		
		return F(n-1) + F(n-2);
	}
	
	public long sum(int[] arr, int startIndex, int endIndex) {
		if(startIndex == endIndex)
			return arr[startIndex];
		
		return arr[startIndex] + sum(arr, startIndex+1, endIndex);
	}
	
	int count(Node list) {
		if(list == null)
			return 0;
		
				
		return 1 + count(list.next);
	}
	
	void printList(Node list) {
		if(list == null)
			return;
		
		System.out.println(list.val);
		printList(list.next);
	}

	void printListReverse(Node list) {
		if(list == null)
			return;
		
		printListReverse(list.next);
		System.out.println(list.val);
	}
}
