package wit.lk.algorithm.ch02;

public class ArrayQueue {
	private final Object[] items;
	
	private int head;
	
	private int tail;
	
	/**
	 * ��ʼ������
	 * @param capacity ���г���
	 */
	public ArrayQueue(int capacity){
		this.items = new Object[capacity];
	}
	
	/**
	 * ���
	 * @param item ��ӵ�Ԫ��
	 * @return
	 */
	public boolean put(Object item){
		if(head == (tail + 1) % items.length){
			//˵������
			return false;
		}
		items[tail] = item;
		tail = (tail + 1) % items.length;//tail��������һλ
		return true;
	}
	
	/**
	 * ��ȡ����ͷԪ�أ�������
	 * @return
	 */
	public Object peek(){
		if(head == tail){
			//˵���ӿ�
			return null;
		}
		return items[head];
	}
	
	/**
	 * ����
	 * @return
	 */
	public Object poll(){
		if(head == tail){
			//˵���ӿ�
			return null;
		}
		Object item = items[head];
		items[head] = null;//��û�õ�Ԫ�ظ���ֵ��������Ҳ���ԣ�����ƶ��ˣ�֮��ᱻ����
		head = (head + 1) % items.length;//��head��������ƶ�һλ
		return item;
	}
	
	public boolean isFull(){
		return head == (tail + 1) % items.length;
	}
	
	public boolean isEmpty(){
		return head == tail;
	}
	
	/**
	 * ����Ԫ����
	 * @return
	 */
	public int size(){
		if(tail >= head){
			return tail - head;
		}else{
			return tail + items.length - head;
		}
	}
}
