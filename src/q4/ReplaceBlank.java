package q4;

public class ReplaceBlank {

	public static void main(String[] args) {
		char[] s = new char[30];
		s[0] = ' ';
		s[1] = 'e';
		s[2] = 'e';
		s[3] = 'a';
		s[4] = ' ';
		s[5] = ' ';
		s[6] = 'e';
		s[7] = 'f';
		s[8] = 'a';
		s[9] = 'm';
		s[10] = 'i';
		s[11] = 'l';
		s[12] = ' ';
		replaceBlank(s, 30);
		for(char c : s) {
			System.out.print(c);
		}
		
	}

	public static void replaceBlank(char[] s, int length) {
		if(s == null || length == 0) {
			return;
		}
		int originalLength = 13;
		int numberofBlank = 0;
		for(char c :s) {
			if(c == ' ') {
				numberofBlank ++;
			} 
		}
		int newLength = originalLength + 2 * numberofBlank;
		if(newLength > length) {
			return;
		}
		int indexOfOriginal = originalLength - 1;
		int indexOfNew = newLength - 1;
		while(indexOfOriginal >=0 && indexOfNew > indexOfOriginal) {
			if(s[indexOfOriginal] == ' ') {
				s[indexOfNew--] = '0';
				s[indexOfNew--] = '2';
				s[indexOfNew--] = '%';
			} else {
				s[indexOfNew --] = s[indexOfOriginal];
			}
			indexOfOriginal --;
		}
	}
}
