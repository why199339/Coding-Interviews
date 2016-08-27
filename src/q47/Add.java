package q47;

public class Add {

	public static void main(String[] args) {
		System.out.println(add_1(1, 2));
		System.out.println(add_2(1, 2));
	}

	public static int add_1(int num1, int num2) {
		int result = num1 ^ num2;
		int carry = (num1 & num2) << 1;
		while (carry != 0) {
			add_1(result, carry);
		}
		return result;
	}

	public static int add_2(int num1, int num2) {
		int sum = 0;
		int carry = 0;
		do {
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;
		} while (num2 != 0);
		return num1;
	}
}
