package q9;

public class AddFrom1ToN_Recursive {

	public static void main(String[] args) {
		System.out.println(addFrom1ToN_Recursive(10000));
	}

	public static int addFrom1ToN_Recursive(int n) {
		return n <= 0 ? 0 : n + addFrom1ToN_Recursive(n - 1);
	}
}
