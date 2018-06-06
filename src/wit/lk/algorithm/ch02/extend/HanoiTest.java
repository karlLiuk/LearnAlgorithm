package wit.lk.algorithm.ch02.extend;

public class HanoiTest {
	
	public static void hanoi(int n, char A, char B, char C){
		if(n == 1){
			move(A,C);
			return;
		}
		//把A上的n-1个圆盘移到B上
		hanoi(n - 1,A,C,B);
		//把A上的最后一个圆盘移动到C上
		move(A,C);
		//递归，把B上的n-1个圆盘移动到C上
		hanoi(n - 1,B,A,C);
	}

	private static void move(char A, char C) {
		System.out.println(A + "-->"+C);
	}

	public static void main(String[] args) {
		hanoi(4,'A','B','C');
	}

}
