package q10;

public class NumberOf1 {

	public static void main(String[] args) {
		System.out.println(numberOf1_bad(9));
//		System.out.println(numberOf1_good(9));
		System.out.println(numberOf1_great(9));
	}

	public static int numberOf1_bad(int n) {
		int count = 0;
		while (n > 0) {
			if ((n & 1) == 1) {
				count++;
			}
			n = n >> 1;
		}
		return count;
	}
	/*
	public static int numberOf1_good(int n) {
		int count = 0;
		int flag = 1;
		while(flag > 0) {
			if((n & flag) == 1) {
				count ++;
			}
			flag = flag << 1;
		}
		return count;
	}
	*/
	public static int numberOf1_great(int n) {
		int count = 0;
		while(n > 0) {
			count ++;
			n = n & (n-1);
		}
		return count;
	}
}
