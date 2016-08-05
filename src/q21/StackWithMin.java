package q21;

import java.util.Stack;

public class StackWithMin {

	private static Stack<Integer> m_data = new Stack<>();
	private static Stack<Integer> m_min = new Stack<>();
	
	public static void main(String[] args) {
		push(3);
		System.out.println(min());
		push(4);
		System.out.println(min());
		push(2);
		System.out.println(min());
		push(1);
		System.out.println(min());
		pop();
		System.out.println(min());
		pop();
		System.out.println(min());
		push(0);
		System.out.println(min());
	}

	public static void push(int value) {
		m_data.push(value);
		if(m_min.size() == 0 || value < m_min.peek()) {
			m_min.push(value);
		} else {
			m_min.push(m_min.peek());
		}
	}
	
	public static void pop() {
		assert(m_data.size() > 0 && m_min.size() > 0);
		m_data.pop();
		m_min.pop();
	}
	
	public static int min() {
		assert(m_data.size() > 0 && m_min.size() > 0);
		return m_min.peek();
	}
}
