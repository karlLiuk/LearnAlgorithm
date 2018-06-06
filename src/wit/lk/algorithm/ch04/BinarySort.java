package wit.lk.algorithm.ch04;

public class BinarySort {
	private int[] array;
	
	public BinarySort(int[] array){
		this.array = array;
	}
	
	public static void main(String[] args){
		int[] array = new int[]{1,5,7,3,11,9,13};
		BinarySort binarySort = new BinarySort(array);
		binarySort.sort();
		binarySort.print();
	}
	
	public void sort(){
		if(array == null){
			throw new RuntimeException("数组是空的");
		}
		if(array.length > 0){
			for(int i = 1;i < array.length; i++){
				int temp = array[i];
				//通过二分查找找到插入的位置
				int insertIndex = binarySearch(i - 1,temp);
				if(i != insertIndex){
					for(int j = i - 1; j >= insertIndex; j--){
						//array[j] = array[j - 1];//有误
						array[j + 1] = array[j];
					}
					//所有的移动完毕，把元素插入
					array[insertIndex] = temp;
				}
			}
		}
	}
	
	public void print(){
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);			
		}
	}

	/**
	 * 二分查找定位插入索引
	 * @param maxIndex 有序部分最大索引
	 * @param data 要找的值
	 * @return 插入位置索引
	 */
	private int binarySearch(int maxIndex, int data) {
		int start = 0;
		int end = maxIndex;
		int mid = -1;
		while(start <= end){
			mid = (start + end) / 2;
			if(array[mid] > data){
				end = mid - 1;
			}else{
				start = mid + 1;
			}
		}
		return start;
	}
}
