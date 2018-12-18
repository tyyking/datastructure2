package com.turingschool.demo.ds.stack;

import java.util.EmptyStackException;

public class LinkedStack<E> implements Stack<E> {
	
	private static class Node<E> {
		public E data; //数据域
		public Node<E> next; //指针域
		
		public Node(E val, Node<E> next) {
			this.data = val;
			this.next = next;
		}
	}
	
	private Node<E> top; //栈顶指针
	
	private int size; //栈中元素数量
	
	public LinkedStack() {
		top = null;
		size = 0;
	}

	@Override
	public boolean empty() {
 		return size == 0;
	}

	@Override
	public int size() {
 		return size;
	}

	@Override
	public void push(E item) {
		top = new Node<E>(item, top);
		size++;
		
	}

	@Override
	public E pop() {
		if(size == 0) {
			throw new EmptyStackException();
		}
		
		E result = top.data;
		top = top.next;
		
		return result;
	}

	@Override
	public E peek() {
		if(size == 0) {
			throw new EmptyStackException();
		}
		
		return top.data;
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new LinkedStack<>();
		
		for(int i=0; i<20; i++) {
			stack.push(i+1);
		}
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		for(int i=0; i<18; i++) {
			System.out.println("The element is: " + stack.pop());
		}
	}


}
