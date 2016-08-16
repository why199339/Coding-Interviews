package q41;

public class FindContinuousSequence {

	public static void main(String[] args) {
		findContinuousSequence(15);
	}

	public static void findContinuousSequence(int sum) {
		if(sum < 3) {
			return;
		}
		int small = 1;
		int big = 2;
		int middle = (1 + sum) / 2;
		int curSum = small + big;
		while(small < middle) {
			if(curSum == sum) {
				printContinuousSquence(small, big);
			}
			while(curSum > sum && small < middle) {
				curSum -= small;
				small++;
				if(curSum == sum) {
					printContinuousSquence(small, big);
				}
			}
			big ++;
			curSum += big;
		}
	}

	private static void printContinuousSquence(int small, int big) {
		for(int i=small; i<=big; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
