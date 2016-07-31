package q7;

import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class JStack {

	private static Queue<String> queue1 = new LinkedBlockingQueue<>();
	private static Queue<String> queue2 = new LinkedBlockingQueue<>();
	
	
	public static void main(String[] args) {
		JStack s = new JStack();
		s.appendTail("a");
		s.appendTail("b");
		s.appendTail("c");
		System.out.println(s.deleteHead());
		s.appendTail("d");
		System.out.println(s.deleteHead());
		System.out.println(s.deleteHead());
		System.out.println(s.deleteHead());
	}

	public static void appendTail(String node) {
		queue1.offer(node);
	}
	
	public static String deleteHead() {
		if(queue1.isEmpty()) {
			while(!queue2.isEmpty()) {
				queue1.offer(queue2.poll());
			}
		}
		if(queue2.isEmpty()) {
			while(queue1.size() != 1) {
				String temp = queue1.poll();
				queue2.offer(temp);
			}
		}
		String result = queue1.poll();
		return result;
	}
}
