package q46;

public class SumSolution {

	public static void main(String[] args) {
		int n = 5;
		System.out.println(sumSolution_1(n));
	}

	public static int sumSolution_1(int n) {
		Temp[] temp = new Temp[n];
		return Temp.getSum();
	}

}

class Temp {
	private static int N = 0;
	private static int Sum = 0;

	public Temp() {
		N ++;
		Sum += N;
	}

	public static void reset() {
		N = 0;
		Sum = 0;
	}

	public static int getSum() {
		return Sum;
	}
}
