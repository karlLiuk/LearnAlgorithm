package wit.lk.algorithm.ch04;

public class SequentialSearch {
	private int[] array;

	public SequentialSearch(int[] array) {
		this.array = array;
	}
	
	/**
	 * 直接顺序查找
	 * @param key 要查找的值
	 * @return
	 */
	public int search(int key){
		for (int i = 0; i < array.length; i++) {
			if(array[i] == key){
				return i;
			}			
		}
		return -1;
	}
	
	/**
	 * 哨兵方式顺序查找
	 * @param key 要查找的值
	 * @return
	 */
	public int search2(int key){
		//先判断是否等于下标为0的元素
		if(array[0] == key){
			return 0;
		}
		
		//临时保存array[0]的值
		int temp = array[0];
		
		//把key赋值给下标为0的元素
		array[0] = key;
		int i = array.length - 1;
		if(array[i] != key){
			i--;
		}
		//把array[0]原本的值赋回去
		array[0] = temp;
		//比较到最后也没找到
		if(i == 0){
			return -1;
		}
		
		//找到了
		return i;
	}
}
