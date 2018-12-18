package com.turingschool.demo.ds.queue;

public class LinkedQueue<E> implements Queue<E> {

	private static class Node<E> {
		private E data;
		private Node<E> next;
		
		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<E>  head; //队头指针
	private Node<E>  tail; //队尾指针
	
	private int size; //队列元素数量
	
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
		Node<E> prev = tail;
		tail = new Node<E>(e, null);
		
		if(size == 0)
			head = tail;
		else
			prev.next = tail;
		
		size++;
	}

	@Override
	public E dequeue() {
		if(size == 0) {
			throw new RuntimeException("队列为空...");
		}
		
		E result = head.data;
		head = head.next;
		
		size--;
		
		if(size == 0)
			tail = null;
		
		return result;
	}

	@Override
	public E peek() {
		if(size == 0) {
			throw new RuntimeException("队列为空...");
		}
		
		return head.data;
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedQueue<>();
		for(int i=0; i<20; i++) {
			queue.enqueue(i+1);
		}
		
		for(int i=0; i<18; i++) {
			System.out.println("The element is: " + queue.dequeue());
		}
	}
}
