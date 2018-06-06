package wit.lk.algorithm.ch07;

public class FullPermutation {
	/**
	 * �ַ���ȫ���еݹ�ʵ��
	 * @param str
	 */
	public static void recursivePermutation(String str){
		char[] array = str.toCharArray();
		recurvivePermutation(array, 0, array.length - 1);
	}

	/**
	 * �ַ���ȫ���еݹ�ʵ��
	 * @param array �ַ�����
	 * @param start ��ʼ�±�
	 * @param end �����±�
	 */
	public static void recurvivePermutation(char[] array, int start, int end) {
		//���ݹ鵽���һλ��ʱ��start��end��ȣ���ʱ�������
		if(start == end ){
			for (int i = 0; i <= end; i++) {
				System.out.print(array[i]);
				
			}
			System.out.println();
		}else{
			//һֱ�������ݹ�ִ�к��沿�ֵ�ȫ����
			for(int j = start; j <= end; j++){
				//�뵱ǰ�ݹ鲿�ֵĵ�1λ���н���
				swap(array, j, start);
				
				//�ݹ�ȫ���к���Ĳ���
				recurvivePermutation(array, start + 1, end);
				
				//������ȥ����ԭ��
				swap(array, j, start);
			}
		}
	}
	
	/**
	 * ASCII��ȫ����
	 * @param str
	 */
	public static void asciiPermutation(String str){
		//��ȡÿ���ַ�����ASCII
		char[] array = str.toCharArray();
		//��Ҫ������
		shellSort(array);
		
		int length = array.length;
		int i = 0;
		while(true){
			System.out.println(array);
			//�ҵ������е�һ�����Լ��ұ�С������λ��
			for(i = length - 2; (i >=0) && (array[i] > array[i + 1]); --i){
				;
			}
			//��i < 0 ʱ��˵���Ѿ���������1��Ԫ�ص�ǰ���ˣ�����
			if(i < 0){
				return;
			}
			
			int j;
			//�ҵ������е�iλ���ұ����һ������������λ��j
			for(j = length - 1; (j > i) && (array[j] <= array[i]); --j){
				;
			}
			//����i��j��ֵ
			swap(array, i, j);
			//��iλ�ú���Ĳ������ݷ�ת
			reverse(array, i + 1, length - 1);
		}
	}
	
	/**
	 * �ַ�����ָ��λ�õĻ���
	 * @param array
	 * @param left
	 * @param right
	 */
	public static void swap(char[] array, int left, int right) {
		char temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	/**
	 * �ַ�����ָ������ķ�ת
	 * @param array
	 * @param start
	 * @param end
	 */
	private static void reverse(char[] array, int start, int end) {
		int mid = (end - start) / 2 + start;
		for(int i = 0; i <= mid - start; i++){
			swap(array, start + i, end - i);
		}
	}

	/**
	 * �����ַ�ASCII�����ϣ������
	 * @param array
	 */
	private static void shellSort(char[] array) {
		char temp;
		for(int k = array.length / 2; k > 0; k /= 2){
			for(int i = k; i < array.length; i++){
				for(int j = i; j >= k; j -= k){
					if(array[j - k] > array[j]){
						temp = array[j - k];
						array[j - k] = array[j];
						array[j] = temp;
					}
				}
			}
		}
	}
	
}
