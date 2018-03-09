package bit.apply.DelRightBitOf_1;

/**
 * 判断一个数是否是2的次幂.
 * 
 * 思路： 对于2的次幂，一定只会在高位出现一个1，所以与任何比2的次幂要小的值做逻辑与运算都为0
 * 
 * @author Administrator
 *
 */
public class CheckPowerOf2 {

	public boolean checkPowerOf2(int n) {
		if (n > Integer.MAX_VALUE) {
			return false;
		}
		return n > 0 && (n & (n - 1)) == 0;
	}
}
