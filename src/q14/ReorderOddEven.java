package q14;

public class ReorderOddEven {

	public static void main(String[] args) {
		int[] data = {1,2,3,4,5};
		int length = data.length;
		for(int d : data) {
			System.out.print(d + " ");
		}
		System.out.println();
		reorderOddEven_1(data, length);
		for(int d : data) {
			System.out.print(d + " ");
		}
	}

	public static void reorderOddEven_1(int[] data, int length) {
		if(data == null || length ==0) {
			return ;
		}
		int start = 0;
		int end = length - 1;
		while(start < end) {
			while(start < end && (data[start] & 0x1) == 1) {
				start ++;
			}
			while(start < end && (data[end] & 0x1) == 0) {
				end --;
			}
			if(start < end) {
				int temp = data[start];
				data[start] = data[end];
				data[end] = temp;
				
			}
		}
	}
	

}
