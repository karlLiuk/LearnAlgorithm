package wit.lk.algorithm.ch04;

public class SequentialSearch {
	private int[] array;

	public SequentialSearch(int[] array) {
		this.array = array;
	}
	
	/**
	 * ֱ��˳�����
	 * @param key Ҫ���ҵ�ֵ
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
	 * �ڱ���ʽ˳�����
	 * @param key Ҫ���ҵ�ֵ
	 * @return
	 */
	public int search2(int key){
		//���ж��Ƿ�����±�Ϊ0��Ԫ��
		if(array[0] == key){
			return 0;
		}
		
		//��ʱ����array[0]��ֵ
		int temp = array[0];
		
		//��key��ֵ���±�Ϊ0��Ԫ��
		array[0] = key;
		int i = array.length - 1;
		if(array[i] != key){
			i--;
		}
		//��array[0]ԭ����ֵ����ȥ
		array[0] = temp;
		//�Ƚϵ����Ҳû�ҵ�
		if(i == 0){
			return -1;
		}
		
		//�ҵ���
		return i;
	}
}
