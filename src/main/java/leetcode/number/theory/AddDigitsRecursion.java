package leetcode.number.theory;

import org.junit.Test;

/**
 * �ݹ��ⷨ
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
		// �ݹ�ʵ�������ĸ�λ���
		int sum = sumNumInEachDigit(num, 0);
		return addDigits(sum);
	}

	/**
	 * �ݹ�ʵ�������ĸ�λ���
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
	 * �����ĳ��򣬴�ӡ������ÿ������
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
