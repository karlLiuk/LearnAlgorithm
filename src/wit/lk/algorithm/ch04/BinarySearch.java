package wit.lk.algorithm.ch04;

public class BinarySearch {
	private int[] array;

	public BinarySearch(int[] array) {
		this.array = array;
	}
	
	/**
	 * 二分查找
	 * @param target 查找的目标
	 * @return
	 */
	public int search(int target){
		if(array == null){
			return -1;
		}
		int start = 0;
		int end = array.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (array[mid] == target) {
				return mid;
			}else if(array[mid] < target){
				start = mid + 1;
			}else{
				end = mid - 1;
			}
		}
		return -1;
	}
	
	/**
	 * 递归实现二分查找
	 * @param target 要查找的目标
	 * @return
	 */
	public int searchRecursion(int target){
		if(array != null){
			return searchRecursion(target,0,array.length - 1);
		}
		return -1;
	}

	private int searchRecursion(int target, int start, int end) {
		if(start > end){
			return -1;
		}
		int mid = start + (end - start)/2;
		if(array[mid] == target){
			return mid;
		}else if(array[mid] < target){
			return searchRecursion(target, mid + 1, end);
		}else{
			return searchRecursion(target, 0, mid - 1);
		}
	}

}
