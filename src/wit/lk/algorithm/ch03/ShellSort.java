package wit.lk.algorithm.ch03;

public class ShellSort {
	private int[] array;

	public ShellSort(int[] array) {
		this.array = array;
	}
	
	public void sort(){
		int temp;
		//增量逐渐减小
		for (int k = array.length/2; k > 0; k /= 2) {
			for (int i = k; i < array.length; i++) {
				//从增量k开始，每次前移k个
				for (int j = i; j >= k; j -= k) {
					//与前面k个比较
					if(array[j - k] > array[j]){
						temp = array[j - k];
						array[j - k] = array[j];
						array[j] = temp;
					}
					
				}				
			}
			
		}
	}
	
	public void print(){
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
