package wit.lk.algorithm.ch02;

import java.util.Arrays;

/*
 * 实现栈
 */
public class Stack {
	private int size = 0; //栈中的元素个数
	
	private int[] array; //栈数组
	
	public Stack(){
		this(10);
	}

	public Stack(int initial) {
		if(initial <= 0){
			initial = 10;
		}
		array = new int[initial];
	}
	
	/**
	 * 入栈
	 * @param item 入栈元素的值
	 */
	public void push(int item){
		if(size == array.length){
			array = Arrays.copyOf(array, size * 2); 
		}
		array[size++] = item;
	}
	
	/**
	 * 获取栈顶元素，但是没有出栈
	 * @return
	 */
	public int peek(){
		if(size == 0){
			throw new IndexOutOfBoundsException("栈里已经空");
		}
		return array[size - 1];
	}
	
	/**
	 * 出栈，同时获取栈顶的元素
	 * @return
	 */
	public int pop(){
		int item = peek();
		size--;
		return item;
	}
	
	/**
	 * 判断栈是否满了
	 * @return
	 */
	public boolean isFull(){
		return size == array.length; 
	}
	
	/**
	 * 判断栈是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int size(){
		return size;
	}
}
