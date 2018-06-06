package lk.wit.algorithm.ch01;

/**
 * ʵ��ɢ�б�
 */
public class HashTable {
	/**
	 * Ĭ��ɢ�б�ĳ�ʼ������
	 * ����Сһ�㣬��������Ŀ�������
	 * ��ʵ��ʹ������ʵ�����ڳ�ʼ��ʱ���Σ������Ǻ�������ܵ�
	 */
	private static final int DEFAULT_INITIAL_CAPACITY = 4;
	
	/**
	 * ��������
	 */
	private static final float LOAD_FACTOR = 0.75f;
	
	/**
	 * ɢ�б�����
	 */
	private Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
	private int size = 0;//ɢ�б�Ԫ�صĸ���
	private int use = 0;//ɢ�б�ʹ�õ�ַ�ĸ���
	
	/**
	 * ���/�޸�
	 * @param key
	 * @param value
	 */
	public void put(int key,int value){
		int index = hash(key);
		if(table[index] == null){
			table[index] = new Entry(-1, -1, null);
		}
		Entry e = table[index];
		if(e.next == null){
			//������ֵ����������ӣ��п������ݣ�Ҫ��table����
			table[index].next = new Entry(key, value, null);
			size++;
			use++;
			//������ֵ��˵���Ǹ���δ�ù��ĵ�ַ����Ҫ�ж��Ƿ���Ҫ����
			if(use >= table.length * LOAD_FACTOR){
				resize();
			}
		}else{
			//�������ֵ���޸����е�ֵ
			for(e = e.next; e != null; e = e.next){
				int k = e.key;
				if(k == key){
					e.value = value;
					return;
				}
			}
			//��������ͬ��ֵ��ֱ�������������Ԫ��
			Entry temp = table[index].next;
			Entry newEntry = new Entry(key, value, temp);
			table[index].next = newEntry;
			size++;
		}
	}
	
	/**
	 * ɾ��
	 * @param key
	 */
	public void remove(int key){
		int index = hash(key);
		Entry e = table[index];
		Entry pre = table[index];
		if(e != null && e.next != null){
			for(e = e.next; e != null; pre = e, e = e.next){
				int k = e.key;
				if(k == key){
					pre.next = e.next;
					size--;
					return;
				}
			}
		}
	}
	
	/**
	 * ��ȡkey��Ӧ��value
	 * @param key
	 * @return
	 */
	public int get(int key){
		int index = hash(key);
		Entry e = table[index];
		if(e != null && e.next != null){
			for(e = e.next; e != null; e = e.next){
				int k = e.key;
				if(k == key){
					return e.value;
				}
			}
		}
		//��û�ҵ�������-1(��������)
		return -1;
	}
	
	/**
	 * ��ȡɢ�б���Ԫ�صĸ���
	 * @return
	 */
	public int size(){
		return size;
	}
	
	/**
	 * ��ȡɢ�б���
	 * ����ɢ�б�Ӧ�ô������������������ֻ��Ϊ�˷�Ӧ����
	 * @return
	 */
	public int getLength(){
		return table.length;
	}

	/**
	 * ����key��ͨ����ϣ������ȡλ��ɢ�б������е��ĸ�λ��
	 * @param key
	 * @return
	 */
	private int hash(int key) {
		
		return key % table.length;
	}
	
	/**
	 * ����
	 */
	private void resize() {
		int newLength = table.length * 2;
		Entry[] oldTable = table;
		table = new Entry[newLength];
		use = 0;
		for (int i = 0; i < oldTable.length; i++) {
			if (oldTable[i] != null && oldTable[i].next != null) {
				Entry e = oldTable[i];
				while(null != e.next){
					Entry next = e.next;
					//���¼����ϣֵ�������µĵ�ַ��
					int index = hash(next.key);
					if(table[index] == null){
						use++;
						table[index] = new Entry(-1, -1, null);
					}
					Entry temp = table[index].next;
					Entry newEntry = new Entry(next.key, next.value, temp);
					table[index].next = newEntry;
					e = next;
				}
			}
			
		}
	}
}
