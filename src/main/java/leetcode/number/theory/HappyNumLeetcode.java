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
public class HappyNumLeetcode {

	int digitSquareSum(int n) {
		int sum = 0, tmp;
		while (n != 0) {
			tmp = n % 10;
			sum += tmp * tmp;
			n /= 10;
		}
		return sum;
	}

	boolean isHappy(int n) {
		int slow, fast;
		slow = fast = n;
		do {
			slow = digitSquareSum(slow);
			fast = digitSquareSum(fast);
			fast = digitSquareSum(fast);
		} while (slow != fast);
		if (slow == 1)
			return true;
		else
			return false;
	}

	@Test
	public void test() {
		System.out.println(isHappy(7));
	}
}
