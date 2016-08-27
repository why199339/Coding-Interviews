package q49;

public class StrToInt {

	private static boolean isValid = true;

	public static void main(String[] args) {
		System.out.println(strToInt("123")  + strToInt("-23"));
		System.out.println(strToInt(""));
		System.out.println(strToInt("+"));
	}

	public static int strToInt(String str) {
		isValid = false;
		int num = 0;
		if (str != null && str.length() != 0) {
			boolean minus = false;
			if (str.charAt(0) == '+') {
				str = str.substring(1);
			} else if (str.charAt(0) == '-') {
				str = str.substring(1);
				minus = true;
			}
			if (str.length() != 0) {
				num = strToIntCore(str, minus);
			}
		}
		return (int) num;
	}

	private static int strToIntCore(String str, boolean minus) {
		int num = 0;
		int i = 0;
		while (i < str.length()) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				int flag = minus ? -1 : 1;
				num = num * 10 + flag * (str.charAt(i) - '0');
				if((!minus && num > Integer.MAX_VALUE) || (minus && num < Integer.MIN_VALUE)) {
					num = 0;
					break;
				}
				i++;
			} else {
				num = 0;
				break;
			}
		}
		if (i != str.length()) {
			isValid = false;
		}
		return num;
	}
}
