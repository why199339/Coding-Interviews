package q38;

public class GetNumOfK {

	public static void main(String[] args) {
		int[] data = {1, 2, 3, 3, 3, 3, 4, 5};
		System.out.println(getNumOfK(data, 3));
	}

	public static int getNumOfK(int[] data, int k) {
		int number = 0;
		if (data != null && data.length > 0) {
			int first = getFirstK(data, k, 0, data.length - 1);
			int last = getLastK(data, k, 0, data.length - 1);
			if (first > -1 && last > -1) {
				number = last - first + 1;
			}
		}
		return number;
	}

	private static int getFirstK(int[] data, int k, int start, int end) {
		if (start > end) {
			return -1;
		}
		int middleIndex = (start + end) / 2;
		int middleData = data[middleIndex];
		if (middleData == k) {
			if ((middleIndex > 0 && data[middleIndex - 1] != k) || middleIndex == 0) {
				return middleIndex;
			} else {
				end = middleIndex - 1;
			}
		} else if (middleIndex > k) {
			end = middleIndex - 1;
		} else {
			start = middleIndex + 1;
		}
		return getFirstK(data, k, start, end);
	}

	private static int getLastK(int[] data, int k, int start, int end) {
		if(start > end) {
			return -1;
		}
		int middleIndex = (start + end) / 2;
		int middleData = data[middleIndex];
		if(middleData == k) {
			if((middleIndex < data.length - 1 && data[middleIndex + 1] != k) || middleIndex == data.length - 1) {
				return middleIndex;
			} else {
				start = middleIndex + 1;
			}
		} else if(middleIndex > k) {
			end = middleIndex - 1;
		} else {
			start = middleIndex + 1; 
		}
		return getLastK(data, k, start, end);
	}
}
