package wit.lk.algorithm.ch02.extend;

public class StaticLinkedList {
	private Element[] elements;	
	private int head;
	private int tail;
	private int unUsed;
	private int size;
	
	/**
	 * ��ʼ��
	 * @param capacity
	 */
	public StaticLinkedList(int capacity){
		elements = new Element[capacity];
		unUsed = 0;
		for(int i = 0; i < capacity - 1; i++){
			elements[i] = new Element();
			elements[i].setCur(i + 1);
		}
		elements[capacity - 1] = new Element();
		elements[capacity - 1].setCur(-1);
	}
	
	/**
	 * ������ָ��λ�ú������
	 * @param data Ҫ�����ֵ
	 * @param index ����λ�ã����������±꣩
	 */
	public void insert(int data, int index){
		if(index == 0){
			insertFirst(data);
		}else if(index == size){
			insertLast(data);
		}else{
			checkFull();
			//��ȡҪ����Ԫ�ص�ǰһ��Ԫ��
			Element preElement = get(index);
			//��ȡһ��δ��ʹ�õ�Ԫ����ΪҪ�����Ԫ��
			Element unUsedElement = elements[unUsed];
			//��¼Ҫ����Ԫ�ص������±�
			int temp = unUsed;
			//���ӱ����������ó�����Ԫ�ص���һ��Ԫ�ص������±���Ϊ��������ͷ
			unUsed = unUsedElement.getCur();
			//��Ҫ����Ԫ�ص�ָ����Ϊԭ��ǰһ��Ԫ�ص�ָ��ָ����±�ֵ
			unUsedElement.setCur(preElement.getCur());
			//��ǰһ��Ԫ�ص�ָ��ָ������Ԫ���±�
			preElement.setCur(temp);
			//��ֵ
			unUsedElement.setData(data);
			size++;
		}
	}
	
	/**
	 * ������β����
	 * @param data
	 */
	public void insertLast(int data) {
		checkFull();
		Element unUsedElement = elements[unUsed];
		int temp = unUsed;
		unUsed = unUsedElement.getCur();
		elements[tail].setCur(temp);
		unUsedElement.setData(data);
		tail = temp;
		size++;
	}

	/**
	 * ������ͷ����
	 * @param data
	 */
	public void insertFirst(int data) {
		checkFull();
		Element unUsedElement = elements[unUsed];
		int temp = unUsed;
		unUsed = unUsedElement.getCur();
		unUsedElement.setCur(head);
		unUsedElement.setData(data);
		head = temp;
		size++;
	}
	
	/**
	 * ����ͷɾ��
	 */
	public void deleteFirst(){
		checkEmpty();
		Element deleteElement = elements[head];
		int temp = head;
		head = deleteElement.getCur();
		deleteElement.setCur(temp);
		unUsed = temp;
		size--;
	}
	
	/**
	 * ����βɾ��
	 */
	public void deleteLast(){
		delete(size - 1);
	}
	
	/**
	 * ɾ��ָ��λ��Ԫ��
	 * @param index �����еĵڼ���Ԫ�أ����������±꣩
	 */
	public void delete(int index) {
		if(index == 0){
			deleteFirst();
		}else{
			Element pre = get(index - 1);
			int del = pre.getCur();//��ȡҪɾ��Ԫ�ص������±�
			Element deleteElement = elements[del];
			pre.setCur(deleteElement.getCur());
			if(index == size - 1){
				tail = index - 1;
			}
			deleteElement.setCur(unUsed);
			unUsed = del;
			size--;
		}
	}

	/**
	 * ��ȡ����Ԫ��
	 * @param index ����ĵڼ���Ԫ�أ����������±꣩
	 * @return
	 */
	public Element get(int index) {
		checkEmpty();
		Element element = elements[head];
		for(int i = 0;i < index; i++){
			element = elements[element.getCur()];
		}
		return element;
	}
	
	/**
	 * ��˳���ӡ����Ԫ�ص�ֵ
	 */
	public void printAll(){
		Element element = elements[head];
		System.out.println(element.getData());
		for(int i = 1;i < size; i++){
			element = elements[element.getCur()];
			System.out.println(element.getData());
		}
	}
	
	public int size(){
		return size;
	}
	
	private void checkFull(){
		if(size == elements.length){
			throw new IndexOutOfBoundsException("���鲻������");
		}
	}
	
	private void checkEmpty(){
		if(size == 0){
			throw new IndexOutOfBoundsException("����Ϊ��");
		}
	}
}
