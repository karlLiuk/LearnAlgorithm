package wit.lk.algorithm.ch02.extend;

public class Stack2QueueTest {

	public static void main(String[] args) {
		Stack2Queue queue = new Stack2Queue(5);
		
		queue.put(1);
		queue.put(2);
		System.out.println(queue.pool());
		queue.put(3);
		queue.put(4);
		System.out.println(queue.pool());
		System.out.println(queue.pool());
	}

}
