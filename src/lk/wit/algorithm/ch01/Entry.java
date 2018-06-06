package lk.wit.algorithm.ch01;


/*
 * 元素类
 * 用于存储Key及Value
 * 实际上就是链表上的每一个元素
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
