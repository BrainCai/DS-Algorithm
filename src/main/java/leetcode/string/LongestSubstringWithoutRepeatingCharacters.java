package leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

//"abaeeeeeabcbb"
public class LongestSubstringWithoutRepeatingCharacters {
	/**
	 * 
	 * Description:
	 * 
	 * @param s
	 * @return int 这版代码的原因是，判断其其他位置的
	 * @see
	 */
	public int lengthOfLongestSubstring(String s) {

		if (s.length() == 0)
			return 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		for (int rightPointer = 0, leftPointer = 0; rightPointer < s.length(); ++rightPointer) {
			if (map.containsKey(s.charAt(rightPointer))) {
				leftPointer = Math.max(leftPointer, map.get(s.charAt(rightPointer)) + 1);

			}
			map.put(s.charAt(rightPointer), rightPointer);
			max = Math.max(max, rightPointer - leftPointer + 1);
		}
		return max;
	}

	/**
	 * 该解法也是O(N^2) Description:
	 * 
	 * @param s
	 *            void
	 *
	 * @see
	 */
	public void testsubString(String s) {

		for (int i = 0; i < s.length(); i++) {
			String subset = s.substring(i);
			for (int j = i + 1; j < subset.length(); j++) {
				if (subset.contains(s.substring(i, j))) {

				}
			}
			System.out.println(s.substring(i));
		}
	}

	@Test
	public void test() {
		// System.out.println(lengthOfLongestSubstring("abcabcbb"));
		// System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		// testsubString("abcabcbb");
	}

	/**
	 * 
	 * Description:
	 * 
	 * @param s
	 * @return int 这版代码的原因是，判断其其他位置的
	 * @see
	 */
	public int lengthOfLongestSubstring_v1(String s) {

		if (s.length() == 0) {
			return 0;
		}
		char[] charArray = s.toCharArray();
		List<Character> charList = new ArrayList<>();
		int maxCount = 0;
		for (int i = 0; i < charArray.length; i++) {
			int count = 1;
			for (int j = i + 1; j < charArray.length; j++) {
				if (charArray[i] != charArray[j]) {// 每次遍历是a都会将与其不同的加和，导致count会加上重复的字符
					count++;
				}
			}
			if (count > maxCount) {
				maxCount = count;
			}
		}
		return maxCount;
	}

	/**
	 * 
	 * Description:
	 * 
	 * @param s
	 * @return int 这版代码的原因是，判断其其他位置的
	 * @see
	 */
	public int lengthOfLongestSubstring_TL(String s) {

		if (s.length() == 0) {
			return 0;
		}
		int maxCount = 0;
		char[] charArray = s.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			List<Character> charList = new ArrayList<>();
			charList.add(charArray[i]);
			for (int j = i + 1; j < charArray.length; j++) {
				if (!charList.contains(charArray[j])) {
					charList.add(charArray[j]);
				} else {
					break;
				}
			}
			if (charList.size() > maxCount) {
				maxCount = charList.size();
			}
		}
		return maxCount;
	}

}
