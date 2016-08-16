package q42;

public class ReverseSentence {

	public static void main(String[] args) {
		String s  = "I am a student.";
		char[] data = s.toCharArray();
		char[] reversedData  = reverseSentence(data);
		System.out.println(String.valueOf(reversedData));
	}

	public static char[] reverseSentence(char[] data) {
		if(data == null || data.length == 0) {
			return null;
		}
		int start = 0;
		int end = data.length - 1;
		reverse(data, start, end);
		end = 0;
		while(start != data.length) {
			if(data[start] == ' ') {
				start ++;
				end ++;
			} else if(data[end] == ' ' || end == data.length -1) {
				reverse(data, start, end -1);
				end ++;
				start = end;
			} else {
				end ++;
			}
		}
		return data;
	}

	public static void reverse(char[] data, int start, int end) {
		if(data == null ) {
			return;
		}
		while(start < end) {
			char temp = data[start];
			data[start] = data[end];
			data[end] = temp;
			start ++;
			end --;
		}
		return;
	}
}
