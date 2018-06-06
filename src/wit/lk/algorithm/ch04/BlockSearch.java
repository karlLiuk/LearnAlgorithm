package wit.lk.algorithm.ch04;

import lk.wit.algorithm.ch01.ArrayList;

public class BlockSearch {
	private int[] index;
	
	private ArrayList[] list;
	
	public BlockSearch(int[] index){
		if(index != null && index.length != 0){
			this.index = index;
			this.list = new ArrayList[index.length];
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList();
			}
		}else{
			throw new Error("index cannot be null or empty.");
		}
	}
	
	/**
	 * 插入元素
	 * @param value
	 */
	public void insert(int value){
		int i = binarySearch(value);
		list[i].add(value);
	}

	public boolean search(int value){
		int i = binarySearch(value);
		for (int j = 0; j < list[i].size(); j++) {
			if(value == list[i].get(j)){
				return true;
			}
		}
		return false;
	}
	
	public void printAll(){
		for (int i = 0; i < list.length; i++) {
			ArrayList arr = list[i];
			System.out.println("ArrayList" + i + ":");
			for (int j = 0; j < arr.size(); j++) {
				System.out.println(arr.get(j));
			}
		}
	}
	/**
	 * 二分查找定位索引位置
	 * @param value
	 * @return
	 */
	private int binarySearch(int value) {
		int start = 0;
		int end = index.length;
		int mid = -1;
		while(start <= end){
			mid = (start + end) / 2;
			if(index[mid] > value){
				end = mid - 1;
			}else{
				//如果相等，也插入到后面
				start = mid + 1;
			}
		}
		return start;
	}
}
