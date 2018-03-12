package leetcode.number.theory;

import org.junit.Test;

/**
 * 递归版解法
 * 
 * @author BrianCai
 *
 */
public class AddDigitsRecursion {

	/**
	 * 
	 */

	public int addDigits(int num) {
		if (num < 10 && num >= 0) {
			return num;
		}
		// 递归实现整数的各位求和
		int sum = sumNumInEachDigit(num, 0);
		return addDigits(sum);
	}

	/**
	 * 递归实现整数的各位求和
	 * 
	 * @param num
	 * @param sum
	 * @return
	 */
	public int sumNumInEachDigit(int num, int sum) {

		if (num == 0) {
			return sum;
		}
		sum += (num % 10);
		return sumNumInEachDigit(num / 10, sum);
	}

	/**
	 * 基础的程序，打印整数的每个数字
	 * 
	 * @param num
	 */
	public void printEachNumInDigit(int num) {
		if (num == 0) {
			return;
		}
		System.out.println(num % 10);
		printEachNumInDigit(num / 10);
	}

	@Test
	public void test() {
		System.out.println(addDigits(10));
	}
}
