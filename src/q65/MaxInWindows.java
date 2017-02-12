package q65;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxInWindows {

	public static void main(String[] args) {
		ArrayList<Integer> num = new ArrayList<>();
		num.add(2);
		num.add(3);
		num.add(4);
		num.add(2);
		num.add(6);
		num.add(2);
		num.add(5);
		num.add(1);
		int size = 3;
		System.out.println(num);
		ArrayList<Integer> max = maxInWindow(num, size);
		System.out.println(max);
	}

	public static ArrayList<Integer> maxInWindow(ArrayList<Integer> num, int size) {
		ArrayList<Integer> max = new ArrayList<>();
		if(num.size() >= size && size >= 1) {
			Deque<Integer> index = new LinkedList<>();
			for (int i=0; i<size; i++) {
				while(!index.isEmpty() && num.get(i) >= index.getFirst()) {
					index.pollFirst();
				}
				index.offerLast(i);
			}
			for(int i=size; i<num.size(); i++) {
				max.add(num.get(index.peekFirst()));
				while(!index.isEmpty() && num.get(i) >= num.get(index.peekLast())) {
					index.removeLast();
				}
				if(!index.isEmpty() && index.peekFirst() <= (int)(i - size)) {
					index.removeFirst();
				}
				index.offerLast(i);
			}
			max.add(num.get(index.peekFirst()));
		}
		return max;
	}
}
