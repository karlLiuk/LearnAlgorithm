package lk.wit.algorithm.ch01;

public class HashTableTest {
	public static void main(String[] args){
		HashTable hashTable = new HashTable();
		hashTable.put(1, 10);
		hashTable.put(2, 20);
		hashTable.put(5, 50);//��keyΪ1��Ԫ���䵽ͬһ��ɢ�б��ַ���ˣ�ʵ��ʹ�ó���Ϊ2
		System.out.println(hashTable.getLength());//ɢ�б���Ϊ4
		
		hashTable.put(3, 30);//�ܳ���Ϊ4�����ϸ�Ԫ�س��ȴ��ڵ���3������
		System.out.println(hashTable.getLength());//ɢ�б�Ϊ8
		
		//�����ݺ�4��Ԫ���ֱַ��䵽��ͬ�ĵ�ַ��
		hashTable.put(6, 60);//ʹ���˵�5����ַ
		hashTable.put(7, 70);//ʹ���˵�6����ַ��Ϊ8��0.75��������Ҫ����
		System.out.println(hashTable.getLength());//ɢ�б���Ϊ16
		System.out.println(hashTable.get(1));//10
		System.out.println(hashTable.get(3));//30
		System.out.println(hashTable.get(5));//50
		System.out.println(hashTable.get(6));//60
	}
}
