package wit.lk.algorithm.ch02;

public class Link {
	private int size = 0;
	private Node first;
	private Node last;

	/**
	 * 链表初始化
	 */
	public Link() {

	}
	/**
	 * 链表后部插入
	 * @param data 要插入的数据
	 */
	public void addLast(int data) {
		if (size == 0) {
			// 为空，初始化前后元素
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
	 * 链表头部插入
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
	 * 在链表指定位置后面插入
	 * @param data 要插入的数据
	 * @param index 下标从0开始
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
			throw new IndexOutOfBoundsException("链表没有那么长");
		}
	}
	
	/**
	 * 删除链表头部元素
	 */
	public void removeFirst(){
		if(size == 0){
			throw new IndexOutOfBoundsException("链表没有元素");
		}else if(size == 1){
			clear();
		}else{
			Node temp = first;
			first = temp.getNext();
			temp = null;//帮组空间回收
			size--;
		}
	}
	
	/**
	 * 删除链表尾部元素
	 */
	public void removeLast(){
		if(size == 0){
			throw new IndexOutOfBoundsException("链表没有元素");
		}else if(size == 1){
			clear();
		}else{
			Node temp = get(size - 2);//获取最后一个元素之前的一个元素
			temp.setNext(null);//帮组空间回收
			size--;
		}
	}
	
	/**
	 * 删除指定位置的元素
	 * @param index
	 */
	public void remove(int index){
		if(size == 0){
			throw new IndexOutOfBoundsException("链表没有元素");
		}else if(size == 1){
			clear();
		}else{
			if(index == 0){
				removeFirst();
			}else if(index == size + 1){
				removeLast();
			}else{
				Node temp = get(index - 1);//要删除的元素的钱一个元素
				Node next = temp.getNext();//要删除的元素
				temp.setNext(next.getNext());
				next = null;//帮组空间回收
				size--;
			}
		}
	}
	
	/**
	 * 打印所有元素的数据
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
	 * 在元素只有一个时清楚first和last元素
	 */
	private void clear() {
		first = null;
		last = null;
		size =0;
	}
	
	/**
	 * 获取链表中元素的个数
	 */
	public int size(){
		return size;
	}
	
	/**
	 * 获取指定下标的元素
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
	 * 在链表中插入第1个元素时，头尾都是一个元素
	 * @param data 要插入的数据
	 */
	private void fillStart(int data) {
		first = new Node();
		first.setData(data);
		last = first;
	}
	
	/**
	 * 反转链表
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
