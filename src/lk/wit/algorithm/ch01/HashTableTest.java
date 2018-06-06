package lk.wit.algorithm.ch01;

public class HashTableTest {
	public static void main(String[] args){
		HashTable hashTable = new HashTable();
		hashTable.put(1, 10);
		hashTable.put(2, 20);
		hashTable.put(5, 50);//和key为1的元素落到同一个散列表地址上了，实际使用长度为2
		System.out.println(hashTable.getLength());//散列表长度为4
		
		hashTable.put(3, 30);//总长度为4，加上该元素长度大于等于3，扩容
		System.out.println(hashTable.getLength());//散列表长为8
		
		//在扩容后4个元素又分别落到不同的地址上
		hashTable.put(6, 60);//使用了第5个地址
		hashTable.put(7, 70);//使用了第6个地址，为8的0.75倍，又需要扩容
		System.out.println(hashTable.getLength());//散列表长度为16
		System.out.println(hashTable.get(1));//10
		System.out.println(hashTable.get(3));//30
		System.out.println(hashTable.get(5));//50
		System.out.println(hashTable.get(6));//60
	}
}
