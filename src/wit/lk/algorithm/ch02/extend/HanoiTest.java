package wit.lk.algorithm.ch02.extend;

public class HanoiTest {
	
	public static void hanoi(int n, char A, char B, char C){
		if(n == 1){
			move(A,C);
			return;
		}
		//��A�ϵ�n-1��Բ���Ƶ�B��
		hanoi(n - 1,A,C,B);
		//��A�ϵ����һ��Բ���ƶ���C��
		move(A,C);
		//�ݹ飬��B�ϵ�n-1��Բ���ƶ���C��
		hanoi(n - 1,B,A,C);
	}

	private static void move(char A, char C) {
		System.out.println(A + "-->"+C);
	}

	public static void main(String[] args) {
		hanoi(4,'A','B','C');
	}

}
