package q22;

import java.util.Stack;

public class IsPopOrder {

	public static void main(String[] args) {
//		int[] push = {1,2,3,4,5};
		int[] push = null;
//		int[] pop = {4,3,5,1,2};
		int[] pop = null;
		System.out.println(isPopOrder(push, pop, 0));
	}

	public static boolean isPopOrder(int[] push, int[] pop, int length) {
		boolean result = false;
		if (push != null && pop != null && length > 0) {
			Stack<Integer> stack = new Stack<>();
			int i = 0, j = 0;
			while (j < length) {
				while (stack.isEmpty() || stack.peek() != pop[j]) {
					if (i == length) {
						break;
					}
					stack.push(push[i]);
					i++;
				}
				if(stack.peek() != pop[j]) {
					break;
				}
				stack.pop();
				j++;
			}
			if(stack.isEmpty() && j==length) {
				result = true;
			}
		}
		return result;
	}
}
