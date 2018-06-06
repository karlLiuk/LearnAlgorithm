package lk.wit.algorithm.ch01;

import java.util.Arrays;
public class ArrayList {
	//��ʼ�����ϳ���
	private static final int INITIAL_SIZE = 10;
	private int size = 0;
	private int[] array;
	public ArrayList(){
		array = new int[INITIAL_SIZE];
	}
	public ArrayList(int initial) {
		if(initial <= 0){
			initial = INITIAL_SIZE;
		}
		array = new int[initial];
	}
	/*
	 * ���Ԫ��
	 */
	public void add(int num){
		if(size == array.length){
			array = Arrays.copyOf(array, size * 2);
		}
		array[size++] = num;
	}
	
	/*
	 * ��ȡָ��λ�õ�Ԫ��
	 * @param i
	 * @return
	 */
	public int get(int i){
		if(i >= size){
			throw new IndexOutOfBoundsException("��ȡ��Ԫ��λ�ó�������󳤶�");
		}
		return array[i];
	}
	
	/*
	 * ����ָ��λ�õ�Ԫ��ֵ
	 * @param i
	 * @param num
	 * @return
	 */
	public int set(int i,int num){
		int oldNum = get(i);
		array[i] = num;
		return oldNum;
	}
	
	/*
	 * ��ȡ�䳤����ĳ���
	 * @return
	 */
	public int size(){
		return size;
	}
}
