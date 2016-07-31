package q9;

public class AddFrom1ToN_Iterative {

	public static void main(String[] args) {
		System.out.println(addFrom1ToN_Iterative(10000));
	}

	public static int addFrom1ToN_Iterative(int n) {
		int sum = 0;
		for(int i=1; i<=n; i++) {
			sum += i;
		}
		return sum;
	}
}
