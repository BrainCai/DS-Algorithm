package dp.recurion;

import org.junit.Test;

/**
 * 最长公共子序列 <br>
 * 如果是暴力求解则会是n^2的时间复杂度
 * 
 * @author Administrator
 *
 */
public class LSC {

	/**
	 * 最长公共子序列递归版解法
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public int longestSquence(String str1, String str2) {

		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();

		return lsc(charArray1, charArray2, 0, 0);

	}

	private int lsc(char[] charArray1, char[] charArray2, int idx1, int idx2) {

		if (idx1 >= charArray1.length || idx2 >= charArray2.length) {
			return 0;
		}

		if (charArray1[idx1] == charArray2[idx2]) {
			return 1 + lsc(charArray1, charArray2, idx1 + 1, idx2 + 1);
		}

		return Math.max(lsc(charArray1, charArray2, idx1 + 1, idx2), lsc(charArray1, charArray2, idx1, idx2 + 1));
	}

	@Test
	public void test() {
		System.out.println(longestSquence("ABCBDAB", "BDCABA"));
		// char[] charArray1 = "ABCBDAB".toCharArray();
		// char[] charArray2 = "BDCABA".toCharArray();
		// System.out.println(LSC_1(charArray1, charArray2, 0, 0));
	}

	int max = 0;

	/**
	 * 错解
	 * 
	 * @param charArray1
	 * @param charArray2
	 * @param idx1
	 * @param idx2
	 * @return
	 */
	private int LSC_1(char[] charArray1, char[] charArray2, int idx1, int idx2) {

		if (idx1 >= charArray1.length || idx2 >= charArray2.length) {
			return 0;
		}
		if (idx1 == charArray1.length - 1 && idx2 == charArray2.length) {
			return 0;
		}

		if (charArray1[idx1] == charArray2[idx2]) {
			max = LSC_1(charArray1, charArray2, idx1 + 1, idx2 + 1) + 1;
		}

		max = Math.max(max, LSC_1(charArray1, charArray2, idx1, idx2 + 1));

		return Math.max(max, LSC_1(charArray1, charArray2, idx1 + 1, idx2));
	}
}
