package bit.base;

/**
 * 交换整数的二进制奇数和偶数位
 * 
 * @author BrianCai <br>
 *         思路： <br>
 *         1、对于x的二进制，我们可以看做是偶数位+奇数位。 <br>
 *         比如：1111 <br>
 *         1 0 1 0----even位 <br>
 *         + 0 1 0 1----odd位 <br>
 *         ----------- <br>
 *         1 1 1 1 <br>
 *         2、恰好也有特性，如果奇数位左移一位，偶数位右移一位，奇数位与偶数位交换了位置，再将两者相加即为交换后的整数
 */
public class SwapBitPosition {
	public int swapOddEvenBits(int x) {

		// 分别取出奇数位/偶数位
		int odd = x & 0x55555555;
		int even = x & 0xaaaaaaaa;
		// 下面通过移位运算，完成位置的交换
		odd <<= 1;
		even >>>= 1;
		return odd + even;
	}

}

/**
 * 思路：想使用字符串交换来解决问题，但是发现，当x为负值时，无法兼容。<br>
 * 
 * 比如-2，奇数，偶数位交换后的结果直接报错。<br>
 */
// public static void main(String[] args) {
// String binStr = Integer.toBinaryString(x);
// System.out.println(binStr);
// char[] c = binStr.toCharArray();
// swap(c);
// binStr = new String(c);
// System.out.println(Integer.valueOf(binStr, 2));
// }
//
// private static void swap(char[] c) {
// for (int i = 0; i < c.length - 1; i += 2) {
// char tmp = c[i];
// c[i] = c[i + 1];
// c[i + 1] = tmp;
// }
//
// }
