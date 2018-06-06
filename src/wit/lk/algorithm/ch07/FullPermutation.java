package wit.lk.algorithm.ch07;

public class FullPermutation {
	/**
	 * 字符串全排列递归实现
	 * @param str
	 */
	public static void recursivePermutation(String str){
		char[] array = str.toCharArray();
		recurvivePermutation(array, 0, array.length - 1);
	}

	/**
	 * 字符串全排列递归实现
	 * @param array 字符数组
	 * @param start 起始下标
	 * @param end 结束下标
	 */
	public static void recurvivePermutation(char[] array, int start, int end) {
		//当递归到最后一位的时候start与end相等，这时输出排列
		if(start == end ){
			for (int i = 0; i <= end; i++) {
				System.out.print(array[i]);
				
			}
			System.out.println();
		}else{
			//一直遍历并递归执行后面部分的全排列
			for(int j = start; j <= end; j++){
				//与当前递归部分的第1位进行交换
				swap(array, j, start);
				
				//递归全排列后面的部分
				recurvivePermutation(array, start + 1, end);
				
				//交换回去保持原样
				swap(array, j, start);
			}
		}
	}
	
	/**
	 * ASCII码全排列
	 * @param str
	 */
	public static void asciiPermutation(String str){
		//获取每个字符串的ASCII
		char[] array = str.toCharArray();
		//需要先排序
		shellSort(array);
		
		int length = array.length;
		int i = 0;
		while(true){
			System.out.println(array);
			//找到数组中第一个比自己右边小的数的位置
			for(i = length - 2; (i >=0) && (array[i] > array[i + 1]); --i){
				;
			}
			//当i < 0 时，说明已经遍历到第1个元素的前面了，结束
			if(i < 0){
				return;
			}
			
			int j;
			//找到排列中第i位的右边最后一个比其大的数的位置j
			for(j = length - 1; (j > i) && (array[j] <= array[i]); --j){
				;
			}
			//交换i，j的值
			swap(array, i, j);
			//把i位置后面的部分内容反转
			reverse(array, i + 1, length - 1);
		}
	}
	
	/**
	 * 字符数组指定位置的互换
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
	 * 字符数组指定区间的反转
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
	 * 根据字符ASCII码进行希尔排序
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
