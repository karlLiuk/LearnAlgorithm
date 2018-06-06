package lk.wit.algorithm.ch01;

public class ArrayListTest1 {
	public static void main(String[] args){
		ArrayList1 array1 = new ArrayList1(1);
		array1.add(1);
		array1.add(2);
		array1.add(3);
		array1.add(4);
		array1.add(5);
		System.out.println(array1.get(3));
		array1.set(3, 9);
		System.out.println(array1.get(3));
		System.out.println(array1.size());
	}
}
