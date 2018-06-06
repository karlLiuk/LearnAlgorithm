package wit.lk.algorithm.ch03;

public class SortTest {
	static int[] array = { 5, 9, 1, 9, 5, 3, 7, 6, 1 };

	public static void main(String[] args) {
		// testBucketSort();
		// testBubbleSort();
		//testQuickSort(array);
		//testInsertSort(array);
		//testShellSort(array);
		testSelectSort(array);
	}
	
	/**
	 * —°‘Ò≈≈–Ú
	 * @param array2
	 */
	private static void testSelectSort(int[] array2) {
		SelectSort selectSort = new SelectSort(array2);
		selectSort.sort();
		selectSort.print();
	}

	/**
	 * œ£∂˚≈≈–Ú
	 * @param array
	 */
	private static void testShellSort(int[] array) {
		ShellSort shellSort = new ShellSort(array);
		shellSort.sort();
		shellSort.print();
	}

	/**
	 * ÷±Ω”≤Â»Î≈≈–Ú
	 * @param array
	 */
	private static void testInsertSort(int[] array) {
		InsertSort insertSort = new InsertSort(array);
		insertSort.sort();
		insertSort.print();
	}
	
	/**
	 * øÏÀŸ≈≈–Ú
	 * @param array
	 */
	private static void testQuickSort(int[] array) {
		//int[] array = {5,9,1,9,5,3,7,6,1};
		QuickSort quickSort = new QuickSort(array);
		quickSort.sort();
		quickSort.print();
	}

	/**
	 * √∞≈›≈≈–Ú
	 */
	private static void testBubbleSort(int[] array) {
		// int[] array = {5,9,1,9,5,3,7,6,1};
		BubbleSort bubbleSort = new BubbleSort(array);

		// bubbleSort.sort();
		bubbleSort.sort2();
		bubbleSort.print();
	}

	/**
	 * Õ∞≈≈–Ú
	 */
	private static void testBucketSort(int[] array) {
		// int[] array = {5,9,1,9,5,3,7,6,1};

		BucketSort bucketSort = new BucketSort(11, array);

		bucketSort.sort();
		bucketSort.print();
	}

}
