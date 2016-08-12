package q35;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class FirstNotRepeatingChar {

	public static void main(String[] args) {
		char[] str = "abaccdeff".toCharArray();
		System.out.println(firstNotRepeatingChar_1(str));
		System.out.println(firstNotRepeatingChar_2(str));
	}

	public static char firstNotRepeatingChar_2(char[] str) {
		if (str == null) {
			return ' ';
		}
		int tableSize = 256;
		int[] hashtable = new int[tableSize];
		for (int i = 0; i < tableSize; i++) {
			hashtable[i] = 0;
		}
		char[] hashKey = str;
		for (int i = 0; i < hashKey.length; i++) {
			hashtable[hashKey[i]]++;
		}
		hashKey = str;
		for(int i=0; i<hashKey.length; i++) {
			if(hashtable[hashKey[i]] == 1) {
				return hashKey[i];
			}
		}
		return ' ';
	}

	public static char firstNotRepeatingChar_1(char[] str) {
		if (str == null || str.length == 0) {
			return ' ';
		}
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length; i++) {
			if (map.containsKey(str[i])) {
				map.put(str[i], map.get(str[i]) + 1);
			} else {
				map.put(str[i], 1);
			}
		}
		for (char ch : map.keySet()) {
			if (map.get(ch) == 1) {
				return ch;
			}
		}
		return ' ';
	}
}
