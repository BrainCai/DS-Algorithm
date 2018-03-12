package leetcode.number.theory;

import org.junit.Test;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the
 * result has only one digit.
 * 
 * For example:
 * 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only
 * one digit, return it.
 * 
 * @author BrianCai
 *
 */
public class AddDigits {
	public int addDigits(int num) {

		// 存储每位数的和
		int sum = 0;
		while (num >= 10) {
			// 并不能确定数字会执行多少次，所以一定是使用while 循环，而且一定是两层循环的嵌套，
			// 且这两个嵌套都不知道什么时候执行结束。---while与for循环的区别。
			while (num != 0) {
				int digit = num % 10;
				sum += digit;
				num /= 10;
			}
			num = sum;// 更新num的值
			sum = 0;// 对sum清零，准备存储下一个整数的各位的值
		}

		return num;
	}

	@Test
	public void test() {
		System.out.println(addDigits(10));
	}
}
