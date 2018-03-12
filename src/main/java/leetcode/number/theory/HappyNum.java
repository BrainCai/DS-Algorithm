package leetcode.number.theory;

import org.junit.Test;

/**
 * Write an algorithm to determine if a number is "happy".<br>
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer,<br>
 * replace the number by the sum of the squares of its digits,<br>
 * and repeat the process until the number equals 1 (where it will stay), <br>
 * or it loops endlessly in a cycle which does not include 1. <br>
 * Those numbers for which this process ends in 1 are happy numbers.<br>
 * 
 * Example: 19 is a happy number<br>
 * 
 * 1^2 + 9^2 = 82<br>
 * 8^2 + 2^2 = 68<br>
 * 6^2 + 8^2 = 100<br>
 * 1^2 + 0^2 + 0^2 = 1<br>
 * 
 * 
 * @author Administrator
 *
 */
public class HappyNum {
	boolean isHappy(int n) {
		int sum = 0;
		while (n >= 1) {

			while (n != 0) {
				sum += Math.pow(n % 10, 2);
				n /= 10;

			}
			// 此处有对[0,10)的硬编码，或者认为先颜知道[0,10)中有1，7是HappyNum
			if (sum == 1 || sum == 7) {
				return true;
			} else if (sum < 10 && sum > 1) {
				return false;
			}
			n = sum;
			sum = 0;
		}

		return false;

	}

	@Test
	public void test() {
		System.out.println(isHappy(7));
	}
}
