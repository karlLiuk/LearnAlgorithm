package wit.lk.algorithm.ch02;

public class Link {
	private int size = 0;
	private Node first;
	private Node last;

	/**
	 * �����ʼ��
	 */
	public Link() {

	}
	/**
	 * ����󲿲���
	 * @param data Ҫ���������
	 */
	public void addLast(int data) {
		if (size == 0) {
			// Ϊ�գ���ʼ��ǰ��Ԫ��
			fillStart(data);
		} else {
			Node node = new Node();
			node.setData(data);
			last.setNext(node);
			last = node;
		}
		size++;
	}
	
	/**
	 * ����ͷ������
	 * @param data
	 */
	public void addFirst(int data){
		if(size == 0){
			fillStart(data);
		}else{
			Node node = new Node();
			node.setData(data);
			node.setNext(first);
			first = node;
		}
		size++;
	}
	
	/**
	 * ������ָ��λ�ú������
	 * @param data Ҫ���������
	 * @param index �±��0��ʼ
	 */
	public void add(int data, int index){
		if(size > index){
			if(size == 0){
				fillStart(data);
				size++;
			}else if(index == 0){
				addFirst(data);
			}else if(index == size + 1){
				addLast(data);
			}else{
				Node temp = get(index);
				Node node = new Node();
				node.setData(data);
				node.setNext(temp.getNext());
				temp.setNext(node);
				size++;
			}
		}else{
			throw new IndexOutOfBoundsException("����û����ô��");
		}
	}
	
	/**
	 * ɾ������ͷ��Ԫ��
	 */
	public void removeFirst(){
		if(size == 0){
			throw new IndexOutOfBoundsException("����û��Ԫ��");
		}else if(size == 1){
			clear();
		}else{
			Node temp = first;
			first = temp.getNext();
			temp = null;//����ռ����
			size--;
		}
	}
	
	/**
	 * ɾ������β��Ԫ��
	 */
	public void removeLast(){
		if(size == 0){
			throw new IndexOutOfBoundsException("����û��Ԫ��");
		}else if(size == 1){
			clear();
		}else{
			Node temp = get(size - 2);//��ȡ���һ��Ԫ��֮ǰ��һ��Ԫ��
			temp.setNext(null);//����ռ����
			size--;
		}
	}
	
	/**
	 * ɾ��ָ��λ�õ�Ԫ��
	 * @param index
	 */
	public void remove(int index){
		if(size == 0){
			throw new IndexOutOfBoundsException("����û��Ԫ��");
		}else if(size == 1){
			clear();
		}else{
			if(index == 0){
				removeFirst();
			}else if(index == size + 1){
				removeLast();
			}else{
				Node temp = get(index - 1);//Ҫɾ����Ԫ�ص�Ǯһ��Ԫ��
				Node next = temp.getNext();//Ҫɾ����Ԫ��
				temp.setNext(next.getNext());
				next = null;//����ռ����
				size--;
			}
		}
	}
	
	/**
	 * ��ӡ����Ԫ�ص�����
	 */
	public void printAll(){
		Node temp = first;
		System.out.println(temp.getData());
		for(int i = 0; i < size - 1; i++){
			temp = temp.getNext();
			System.out.println(temp.getData());
		}
	}
	
	/**
	 * ��Ԫ��ֻ��һ��ʱ���first��lastԪ��
	 */
	private void clear() {
		first = null;
		last = null;
		size =0;
	}
	
	/**
	 * ��ȡ������Ԫ�صĸ���
	 */
	public int size(){
		return size;
	}
	
	/**
	 * ��ȡָ���±��Ԫ��
	 * @param index 
	 * @return
	 */
	public Node get(int index) {
		Node temp = first;
		for(int i = 0; i < index; i++){
			temp = temp.getNext();
		}
		return temp;
	}
	/**
	 * �������в����1��Ԫ��ʱ��ͷβ����һ��Ԫ��
	 * @param data Ҫ���������
	 */
	private void fillStart(int data) {
		first = new Node();
		first.setData(data);
		last = first;
	}
	
	/**
	 * ��ת����
	 */
	public void reverse(){
		Node temp = first;
		last = temp;
		Node next = first.getNext();
		for(int i = 0; i < size - 1; i++){
			Node nextNext = next.getNext();
			next.setNext(temp);
			temp = next;
			next = nextNext;
		}
		last.setNext(null);
		first = temp;
		
	}
}
