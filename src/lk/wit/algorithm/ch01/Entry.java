package lk.wit.algorithm.ch01;


/*
 * Ԫ����
 * ���ڴ洢Key��Value
 * ʵ���Ͼ��������ϵ�ÿһ��Ԫ��
 */
public class Entry {
	int key;
	int value;
	Entry next;	
	public Entry(int key, int value, Entry next) {
		super();
		this.key = key;
		this.value = value;
		this.next = next;
	}	
}
