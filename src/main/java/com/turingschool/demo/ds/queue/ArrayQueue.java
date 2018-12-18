package com.turingschool.demo.ds.queue;

import java.util.Arrays;

public class ArrayQueue<E> implements Queue<E> {
	
	private static final int DEFAULT_CAPACITY = 10;
	
	private E[] data; //存储队列元素的数组
	
	private int size; //队列元素数量
	
	private int head; //队头指针
	 
	private int tail; //队尾指针
	
	public ArrayQueue(int capacity) {
		this.data = (E[]) new Object[capacity];
		this.size = 0;
		this.head = -1;
		this.tail = -1;
	}
	
	public ArrayQueue() {
		this(DEFAULT_CAPACITY);
	}

	@Override
	public int size() {
 		return size;
	}

	@Override
	public boolean empty() {
 		return size == 0;
	}

	@Override
	public void enqueue(E e) {
		if(data.length == size)
		{
			grow(size*2);
		}
		
		tail = (tail + 1) % data.length;
		data[tail] = e;
		
		if(size == 0) {
			head = tail;
		}
		
		size++;
	}

	private void grow(int capacity) {
		if(capacity <= DEFAULT_CAPACITY)
			return;
		
		E[] oldData = data;
		data = (E[]) new Object[capacity];
		
		for(int i=0; i<size; i++) {
			data[i] = oldData[(head + i)%oldData.length];
		}
		
		head = 0;
		tail = size - 1;
  		
	}

	@Override
	public E dequeue() {
		if(size == 0) {
			throw new RuntimeException("队列为空...");
		}
		
		E result = data[head];
		
		head = (head + 1) % data.length;
		size--;
		
		if(size <= data.length/2) {
			grow(data.length/2);
		}
		
 		return result;
	}

	@Override
	public E peek() {
		if(size == 0) {
			throw new RuntimeException("队列为空...");
		}
		
		return data[head];
	}
	
	public static void main(String[] args) {
		Queue<Integer> queue = new ArrayQueue<>();
		for(int i=0; i<20; i++) {
			queue.enqueue(i+1);
		}
		
		for(int i=0; i<18; i++) {
			System.out.println("The element is: " + queue.dequeue());
		}
	}

}
