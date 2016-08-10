package q28;

public class Permutation {

	public static void main(String[] args) {
		char[] str = {'a','b','c'};
		permutation(str);
	}

	public static void permutation(char[] str) {
		if (str == null) {
			return;
		}
		int index = 0;
		permutation(str, index);
	}

	private static void permutation(char[] str, int index) {
		if (index == str.length - 1) {
			System.out.println(String.valueOf(str));
			
		} else {
			for (int i = index; i < str.length; i++) {
				char temp = str[index];
				str[index] = str[i];
				str[i] = temp;
				permutation(str,index + 1);
				temp = str[index];
				str[index] = str[i];
				str[i] = temp;
			}
		}
	}
}
