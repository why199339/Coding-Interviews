package q7;

import java.util.Stack;

public class JQueue {

	private static Stack<String> stack1 = new Stack<>();
	private static Stack<String> stack2 = new Stack<>();
	
	public static void main(String[] args) {
		JQueue q = new JQueue();
		q.appendTail("a");
		q.appendTail("b");
		q.appendTail("c");
		System.out.println(q.deleteHead());
		q.appendTail("d");
		System.out.println(q.deleteHead());
		System.out.println(q.deleteHead());
		System.out.println(q.deleteHead());
	}

	public static void appendTail(String node) {
		stack1.push(node);
	}
	
	public static String deleteHead() {
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				String temp = stack1.pop();
				stack2.push(temp);
			}
		}
		if(stack2.isEmpty()) {
			System.out.println("Exception");
		}
		String result = stack2.pop();
		return result;
	}
}
