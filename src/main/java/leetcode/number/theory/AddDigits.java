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

		// �洢ÿλ���ĺ�
		int sum = 0;
		while (num >= 10) {
			// ������ȷ�����ֻ�ִ�ж��ٴΣ�����һ����ʹ��while ѭ��������һ��������ѭ����Ƕ�ף�
			// ��������Ƕ�׶���֪��ʲôʱ��ִ�н�����---while��forѭ��������
			while (num != 0) {
				int digit = num % 10;
				sum += digit;
				num /= 10;
			}
			num = sum;// ����num��ֵ
			sum = 0;// ��sum���㣬׼���洢��һ�������ĸ�λ��ֵ
		}

		return num;
	}

	@Test
	public void test() {
		System.out.println(addDigits(10));
	}
}
