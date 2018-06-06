package lk.wit.algorithm.ch01;

public class HashTable1 {
	private static final int DEFAULT_INITIAL_CAPACITY = 4;
	
	private static final float LOCAL_FACTOR = 0.75F;
	
	private Entry1[] table = new Entry1[DEFAULT_INITIAL_CAPACITY];
	private int size = 0;
	private int use = 0;
	
	public void put(int key, int value){
		int index = hash(key);
		if(table[index] == null){
			table[index] = new Entry1(-1, -1, null);
		}
		Entry1 e = table[index];
		if(e.next == null){
			table[index].next = new Entry1(key,value,null);
			size++;
			use++;
			if(use >= table.length * LOCAL_FACTOR){
				resize();
			}
		}else{
			for(e = e.next;e != null; e = e.next){
				int k = e.key;
				if(k == key){
					e.value = value;
					return;
				}
			}
			Entry1 temp = table[index].next;
			Entry1 newEntry = new Entry1(key, value, temp);
			table[index].next = newEntry;
			size++;
		}
	}
	
	public void remove(int key){
		int index = hash(key);
		Entry1 e = table[index];
		Entry1 pre = table[index];
		if(e != null && e.next != null){
			for(e = e.next; e != null;pre = e,e = e.next){
				int k = e.key;
				if(k == key){
					pre.next = e.next;
					size--;
					return;
				}
			}
		}
	}
	
	public int get(int key){
		int index = hash(key);
		Entry1 e = table[index];
		if(e != null && e.next != null){
			for(e = e.next;e != null; e = e.next){
				int k = e.key;
				if(k == key){
					return e.value;
				}
			}
		}
		return -1;
	}
	
	public int size(){
		return size;
	}
	
	public int getLength(){
		return table.length;
	}

	private void resize() {
		int newLength = table.length * 2;
		Entry1[] oldTable = table;
		table = new Entry1[newLength];
		use = 0;
		for(int i = 0; i < oldTable.length; i++){
			if(oldTable[i] != null && oldTable[i].next != null){
				Entry1 e = oldTable[i];
				while(null != e.next){
					Entry1 next = e.next;
					
					int index = hash(next.key);
					if(table[index] == null){
						use++;
						table[index] = new Entry1(-1, -1, null);
					}
					Entry1 temp = table[index].next;
					Entry1 newEntry1 = new Entry1(next.key, next.value, temp);
					table[index].next = newEntry1;
					
					e = next;
				}
			}
		}
	}

	private int hash(int key) {
		
		return key % table.length;
	}
}
