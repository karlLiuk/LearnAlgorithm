package wit.lk.algorithm.ch04;

public class YoungSearch {
	private int[][] array;

	public YoungSearch(int[][] array) {
		this.array = array;
	}
	
	/**
	 * 优化的查找
	 * @param target
	 * @return
	 */
	public boolean search2(int target) {
		int width = array[0].length;
		int heigth = array.length;
		if (target >= array[0][0]) {
			int i = 0;
			// 从头开始第一行的查找
			for (; target >= array[0][i] && i < width - 1; i++) {
				if (target == array[0][i]) {
					System.out.println(String.format("x: %d, y: %d", 0, i));
					return true;
				}
			}
			// 该行未找到，修复i为矩阵范围内的数值
			if (i > width - 1) {
				i--;
			}

			// 开始循环向下寻找
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
					// 该行未找到，修复i为矩阵范围内的数值
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
					// 该行未找到，修复i为矩阵范围内的数值
					if(i > width - 1){
						i--;
					}
				}
			}
		}
		return false;
	}

	/**
	 * 定位查找
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
				//没找到
				return false;
			}
		}
	}
}
