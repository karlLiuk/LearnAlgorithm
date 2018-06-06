package lk.wit.algorithm.ch01;

import java.util.Arrays;

public class ArrayList1 {
	//初始化集合长度
	private static final int INITIAL_SIZE = 10;
	private int size = 0;
	private int[] array;
	public ArrayList1() {
		array = new int[INITIAL_SIZE];
	}
	public ArrayList1(int initial) {
		if(initial <= 0){
			initial = INITIAL_SIZE;
		}
		array = new int[INITIAL_SIZE];
	}
	/**
	 * 添加元素
	 * @param num
	 */
	public void add(int num){
		if(size == array.length){
			array = Arrays.copyOf(array, size * 2);
		}
		array[size++] = num;
	}
	
	/**
	 * 获取指定位置的元素值
	 * @param i
	 * @return
	 */
	public int get(int i){
		if(i >= size){
			throw new IndexOutOfBoundsException("超出数组范围");
		}
		return array[i];
	}
	
	/**
	 * 设置指定位置的值
	 * @param i
	 * @param num
	 * @return
	 */
	public int set(int i, int num){
		int oldNum = get(i);
		array[i] = num;
		return oldNum;
	}
	
	/**
	 * 获取变长数组的长度
	 * @return
	 */
	public int size(){
		return size;
	}
}
