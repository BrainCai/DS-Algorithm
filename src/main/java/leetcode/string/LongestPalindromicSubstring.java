package leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.parser.deserializer.CharArrayDeserializer;

/**
 * Input: "baccabad"<br>
 * 
 * Output: "bab"<br>
 * 
 * Input: "cbbd"<br>
 * 
 * Output: "bb"<br>
 * 
 * @author Administrator
 *
 */
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {

		if (s.length() == 0) {
			return "";
		}
		char[] charArray = s.toCharArray();
		Map<Character, List<Integer>> charMap = new HashMap<>();
		Map<Integer, Integer> idxMap = new HashMap<>();
		String str = "";
		for (int i = 0; i < charArray.length; i++) {
			if (!charMap.containsKey(charArray[i])) {
				List<Integer> idxlist = new ArrayList<>();
				idxlist.add(i);
				charMap.put(charArray[i], idxlist);
			} else {
				List<Integer> idxlist = charMap.get(charArray[i]);
				idxlist.add(i);
				for (Integer lastIdx : idxlist) {
					// 截取出含重复字符串的区间
					String tmp = s.substring(lastIdx, i + 1);
					if (tmp.length() > str.length()) {

						boolean flag = true;
						int tmpIdx = i;
						while (lastIdx < tmpIdx) {
							if (charArray[lastIdx] != charArray[tmpIdx]) {
								flag = false;
								break;
							}
							lastIdx++;
							tmpIdx--;
						}

						if (flag) {
							str = tmp;
						}
					}
				}

			}
		}
		if (str.length() == 0) {
			return str = String.valueOf(charArray[0]);
		}
		return str;
	}

	@Test
	public void test() {
		// "adada"
		System.out.println(longestPalindrome(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		// System.out.println(new String().valueOf(CharArrayDeserializer[));
		// System.out.println("aa".substring(0, 2));
	}

	public String longestPalindrome_TC(String s) {

		if (s.length() == 0) {
			return "";
		}
		char[] charArray = s.toCharArray();
		Map<Character, List<Integer>> charMap = new HashMap<>();
		String str = "";
		for (int i = 0; i < charArray.length; i++) {
			if (!charMap.containsKey(charArray[i])) {
				List<Integer> idxlist = new ArrayList<>();
				idxlist.add(i);
				charMap.put(charArray[i], idxlist);
			} else {// 出现重复点
				// 先判断临近点是否相同
				// TODO 暂时放弃分类讨论的，取出上次的key
				// int lastIdx = charMap.get(charArray[i]);
				List<Integer> idxlist = charMap.get(charArray[i]);
				idxlist.add(i);
				for (Integer lastIdx : idxlist) {

					// 截取出含重复字符串的区间
					String tmp = s.substring(lastIdx, i + 1);
					boolean flag = true;
					int tmpIdx = i;
					while (lastIdx < tmpIdx) {
						if (charArray[lastIdx] != charArray[tmpIdx]) {
							flag = false;
							break;
						}
						lastIdx++;
						tmpIdx--;
					}

					if (flag) {
						str = tmp.length() > str.length() ? tmp : str;
					}
				}

			}
		}
		if (str.length() == 0) {
			return str = String.valueOf(charArray[0]);
		}
		return str;
	}
}
