package bit.apply.DelRightBitOf_1;

import org.junit.Test;

/**
 * 一个32位整数中包含1的位数<br>
 * 思路：n&(n-1)每次都会消除掉最右边的1，所以迭代直至n为0， 时间复杂度O(n/2)
 * 
 * @author Administrator
 *
 */
public class NumContainOnes {

	public int containOnes(int num) {
		if (num == 0) {
			return 0;
		}
		int count = 0;
		while (num != 0) {
			num = num & (num - 1);
			count++;
		}
		return count;
	}

	@Test
	public void test() {
		System.out.println(containOnes(128));
	}
}
