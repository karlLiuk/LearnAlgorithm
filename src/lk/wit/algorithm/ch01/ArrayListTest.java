package lk.wit.algorithm.ch01;

public class ArrayListTest {
	public static void main(String[] args){
		ArrayList arrayList = new ArrayList(1);
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(5);
		System.out.println(arrayList.get(3));//��ȡ�����±�Ϊ3��ֵ����ӡ4
		arrayList.set(3, 9);//���������±�Ϊ3λ�õ�ֵΪ9
		System.out.println(arrayList.get(3));//�ٴλ�ȡ����ӡ9
		System.out.println(arrayList.size());//�䳤���鳤��Ϊ5��ʵ���ڲ�����Ϊ8	
	}
}