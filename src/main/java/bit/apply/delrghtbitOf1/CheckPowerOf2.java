package bit.apply.delrghtbitOf1;

/**
 * 判断�?个数是否�?2的次�?.
 * 
 * 思路�? 对于2的次幂，�?定只会在高位出现�?�?1，所以与任何�?2的次幂要小的值做逻辑与运算都�?0
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
