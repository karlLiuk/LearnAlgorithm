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
			throw new RuntimeException("�����ǿյ�");
		}
		if(array.length > 0){
			for(int i = 1;i < array.length; i++){
				int temp = array[i];
				//ͨ�����ֲ����ҵ������λ��
				int insertIndex = binarySearch(i - 1,temp);
				if(i != insertIndex){
					for(int j = i - 1; j >= insertIndex; j--){
						//array[j] = array[j - 1];//����
						array[j + 1] = array[j];
					}
					//���е��ƶ���ϣ���Ԫ�ز���
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
	 * ���ֲ��Ҷ�λ��������
	 * @param maxIndex ���򲿷��������
	 * @param data Ҫ�ҵ�ֵ
	 * @return ����λ������
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
