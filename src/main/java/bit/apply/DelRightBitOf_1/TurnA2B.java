package bit.apply.DelRightBitOf_1;

import org.junit.Test;

/**
 * 如果要将整数A转换为B，需要改变多少个bit位？
 * 
 * 因为A转化为B，则只需要将A与B不相同的位设置为相同即可，所以问题转化为找A/B 不同位的个数<br>
 * 由异或 ^ 运算可得 A，B不相同的位数，再计算出异或运算的1的个数即可
 * 
 * @author BrianCai
 *
 */
public class TurnA2B {

	public int turnA2B(int a, int b) {
		int c = a ^ b;
		int count = 0;
		while (c != 0) {
			c = c & (c - 1);
			count++;
		}
		return count;
	}

	@Test
	public void test() {
		System.out.println(turnA2B(10, 20));
	}
}
