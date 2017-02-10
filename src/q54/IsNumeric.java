package q54;

import org.omg.CORBA.portable.Streamable;

public class IsNumeric {

	public static void main(String[] args) {
		String str = "+100";
		System.out.println(str + " : " + isNumeric(str.toCharArray()));
//		str = "5e2";
//		char[] str1 = "12e".toCharArray();
//		isNumeric(str1);
		System.out.println(str + " : " + isNumeric(str.toCharArray()));
		str = "-123";
		System.out.println(str + " : " + isNumeric(str.toCharArray()));
		str = "3.1416";
		System.out.println(str + " : " + isNumeric(str.toCharArray()));
		str = "-1E-16";
		System.out.println(str + " : " + isNumeric(str.toCharArray()));
		str = "12e";
		System.out.println(str + " : " + isNumeric(str.toCharArray()));
		str = "1a3.14";
		System.out.println(str + " : " + isNumeric(str.toCharArray()));
		str = "1.2.3";
		System.out.println(str + " : " + isNumeric(str.toCharArray()));
		str = "+-5";
		System.out.println(str + " : " + isNumeric(str.toCharArray()));
		str = "12e+5.4";
		System.out.println(str + " : " + isNumeric(str.toCharArray()));
	}

	public static boolean isNumeric(char[] str) {
		if (str == null || str.length == 0) {
			return false;
		}
		if (str[0] == '+' || str[0] == '-') {
			str = String.valueOf(str).substring(1).toCharArray();
		}
		if (str.length == 0) {
			return false;
		}
		boolean numeric = true;
		int i = scanDigits(str);
		if (i != str.length) {
			if (str[i] == '.') {
				str = String.valueOf(str).substring(1).toCharArray();
				i = scanDigits(str);
				if (str[i] == 'e' || str[i] == 'E') {
					numeric = isExponential(str);
				}
			} else if (str[i] == 'e' || str[i] == 'E') {
				str = String.valueOf(str).substring(i).toCharArray();
				if (str.length != 0) {
					numeric = isExponential(str);
				}
			} else {
				numeric = false;
			}
		}
		return numeric;
	}

	private static boolean isExponential(char[] str) {
		int i = 0;
		if(str[i] != 'e' && str[i] != 'E') {
			return false;
		}
		str = String.valueOf(str).substring(1).toCharArray();
		if (str.length != 0 && str[i] == '+' || str[i] == '-') {
			str = String.valueOf(str).substring(1).toCharArray();
		} else {
			return false;
		}
		if (str.length == 0) {
			return false;
		}
		i = scanDigits(str);
		return (i >= str.length);
	}

	private static int scanDigits(char[] str) {
		int i = 0;
		while (i < str.length && str[i] >= '0' && str[i] <= '9') {
			i++;
		}
		return i;
	}
}
