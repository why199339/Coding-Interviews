package q55;

public class CharStatistics {

	public static void main(String[] args) {
		char[] str = "go".toCharArray();
		System.out.println(charStatistics(str));
		str = "google".toCharArray();
		System.out.println(charStatistics(str));
	}

	public static char charStatistics(char[] str) {
		if (str == null || str.length == 0) {
			return ' ';
		}
		int[] occurrence = new int[256];
		for (int i = 0; i < 256; i++) {
			occurrence[i] = -1;
		}
		for (int i = 0; i < str.length; i++) {
			if (occurrence[str[i]] == -1) {
				occurrence[str[i]] = i;
			} else if (occurrence[str[i]] >= 0) {
				occurrence[str[i]] = -2;
			}
		}
		int minIndex = Integer.MAX_VALUE;
		char result = ' ';
		for (int i=0; i<256; i++) {
			if (occurrence[i] >=0 && occurrence[i] < minIndex) {
				result = (char)i;
				minIndex = occurrence[i];
			}
		}
		return result;
	}
}
