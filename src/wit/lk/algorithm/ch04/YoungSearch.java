package wit.lk.algorithm.ch04;

public class YoungSearch {
	private int[][] array;

	public YoungSearch(int[][] array) {
		this.array = array;
	}
	
	/**
	 * �Ż��Ĳ���
	 * @param target
	 * @return
	 */
	public boolean search2(int target) {
		int width = array[0].length;
		int heigth = array.length;
		if (target >= array[0][0]) {
			int i = 0;
			// ��ͷ��ʼ��һ�еĲ���
			for (; target >= array[0][i] && i < width - 1; i++) {
				if (target == array[0][i]) {
					System.out.println(String.format("x: %d, y: %d", 0, i));
					return true;
				}
			}
			// ����δ�ҵ����޸�iΪ����Χ�ڵ���ֵ
			if (i > width - 1) {
				i--;
			}

			// ��ʼѭ������Ѱ��
			for (int j = 1; j < heigth; j++) {
				if (array[j][i] == target) {
					System.out.println(String.format("x: %d, y: %d", j, i));
					return true;
				} else if (array[j][i] > target) {
					for (; i >= 0; i--) {
						if (array[j][i] == target) {
							System.out.println(String.format("x: %d, y: %d", j, i));
							return true;
						} else if (array[j][i] <= target) {
							break;
						}
					}
					// ����δ�ҵ����޸�iΪ����Χ�ڵ���ֵ
					if (i < 0) {
						i++;
					}
				} else if (array[j][i] < target) {
					for (; i < width - 1; i++) {
						if (array[j][i] == target) {
							System.out.println(String.format("x: %d, y: %d", j, i));
							return true;
						} else if (array[j][i] >= target) {
							break;
						}
					}
					// ����δ�ҵ����޸�iΪ����Χ�ڵ���ֵ
					if(i > width - 1){
						i--;
					}
				}
			}
		}
		return false;
	}

	/**
	 * ��λ����
	 * @param target
	 * @return
	 */
	public boolean search3(int target){
		int i = 0,j = array[0].length - 1;
		int temp = array[i][j];
		while(true){
			if(temp == target){
				System.out.println(String.format("x: %d,y: %d", i,j));
				return true;
			}else if(temp < target && i < array.length - 1){
				temp = array[++i][j];
			}else if(temp > target && j > 0){
				temp = array[i][--j];
			}else{
				//û�ҵ�
				return false;
			}
		}
	}
}
