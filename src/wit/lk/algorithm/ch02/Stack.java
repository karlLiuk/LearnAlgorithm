package wit.lk.algorithm.ch02;

import java.util.Arrays;

/*
 * ʵ��ջ
 */
public class Stack {
	private int size = 0; //ջ�е�Ԫ�ظ���
	
	private int[] array; //ջ����
	
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
	 * ��ջ
	 * @param item ��ջԪ�ص�ֵ
	 */
	public void push(int item){
		if(size == array.length){
			array = Arrays.copyOf(array, size * 2); 
		}
		array[size++] = item;
	}
	
	/**
	 * ��ȡջ��Ԫ�أ�����û�г�ջ
	 * @return
	 */
	public int peek(){
		if(size == 0){
			throw new IndexOutOfBoundsException("ջ���Ѿ���");
		}
		return array[size - 1];
	}
	
	/**
	 * ��ջ��ͬʱ��ȡջ����Ԫ��
	 * @return
	 */
	public int pop(){
		int item = peek();
		size--;
		return item;
	}
	
	/**
	 * �ж�ջ�Ƿ�����
	 * @return
	 */
	public boolean isFull(){
		return size == array.length; 
	}
	
	/**
	 * �ж�ջ�Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int size(){
		return size;
	}
}
