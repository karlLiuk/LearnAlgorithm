package wit.lk.algorithm.ch02;

public class LinkTest {

	public static void main(String[] args) {
		Link link = new Link();
		link.addFirst(2);
		link.addFirst(1);
		link.addLast(4);
		link.addLast(5);
		link.add(3, 1);
		link.printAll();
		link.removeFirst();
		link.removeLast();
		link.remove(1);
		printAllElements(link);
		link.removeFirst();
		link.removeFirst();
		System.out.println(link.size());
	}

	private static void printAllElements(Link link) {
		for(int i = 0; i < link.size();i++){
			System.out.println(link.get(i).getData());
		}
	}

}
