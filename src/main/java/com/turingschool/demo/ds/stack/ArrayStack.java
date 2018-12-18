package com.turingschool.demo.ds.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {
	private final static int DEFAULT_CAPACITY = 10;

	//保存栈元素的数组
	private E[] data;
	
	//栈中元素数量
	private int size;
	
	//栈顶索引
	private int top;
	
	public ArrayStack(int capacity) {
		this.size = 0;
		this.top = -1;
		this.data = (E[]) new Object[capacity];
	}
	
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
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
		
		if(data.length == size) {
			grow(size * 2);
		}
		
		data[++top] = item;
		size++;
	}

	private void grow(int capacity) {
		if(capacity <= DEFAULT_CAPACITY)
			return;
		
		data = Arrays.copyOf(data, capacity);
	}

	@Override
	public E pop() {
		if(size == 0) {
			throw new EmptyStackException();
		}
		
		size--;
		
		if(size < data.length/2) {
			grow(data.length/2);
		}
		
		return data[top--];
	}

	@Override
	public E peek() {
		if(size == 0) {
			throw new EmptyStackException();
		}	
		
		return data[top];
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new ArrayStack<>();
		
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
