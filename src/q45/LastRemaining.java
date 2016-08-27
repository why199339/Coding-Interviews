package q45;

import java.util.LinkedList;

public class LastRemaining {

	public static void main(String[] args) {
		System.out.println(lastRemaining_1(5, 3));
		System.out.println(lastRemaining_2(5, 3));
	}

	public static int lastRemaining_2(int n, int m) {
		if(n<1 || m < 1) {
			return -1;
		}
		int last = 0;
		for(int i=2; i<=n; i++) {
			last = (last + m) % i;
		}
		return last;
	}
	
	public static int lastRemaining_1(int n, int m) {
		if (n < 1 || m < 1) {
			return -1;
		}
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		int current = 0;
		while (list.size() > 1) {
			for (int i = 1; i < m; i++) {
				current ++;
				if(current == list.size()) {
					current = 0;
				}
			}
			list.remove(current);
			if(current == list.size()) {
				current = 0;
			}
		}
		return list.getFirst();
	}
}
