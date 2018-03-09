package bit.apply;

import org.junit.Test;

/**
 * 思路：<br>
 * 思路中的本质要点:<br>
 * a、 m位的000000 与 m位的二进制的或操作 会得到m的原值，与操作会使任何形式的二进制数字位零。<br>
 * b、-1是一个特殊的数值，其二进制码全为1，初始化后左移或者逻辑右移k都是设置高k或者低k位的零，之后的操作必须借助手动操作。
 * 1、要使得N的i~j为m的二进制形式，则必须使n得第i~j为0，然后与m<<i做或运算即可<br>
 * 2、要使i~j为0，则必须通过-1来设置，-1的第i~j为0，通过-1与n与运算即可得n的第i~j位为0
 * 
 * 
 * 给出两个32位的整数N和M，以及两个二进制位的位置i和j。写一个方法来使得N中的第i到j位等于M（M会是N中从第i为开始到第j位的子串)
 * 
 * @author Administrator
 *
 */
public class UpdateBits {
	/**
	 * 
	 * 算法实现的前两步，不可以合并，因为-1的特性
	 * 
	 * @param n,
	 *            m: Two integer
	 * @param i,
	 *            j: Two bit positions return: An integer
	 */
	public int updateBits(int n, int m, int i, int j) {

		// 这是一个表达式即可完成。代码分解如下
		// return ((~((-1 >>> (32 - (j - i + 1))) << i)) & n) | (m << i);

		// 实现逻辑右移-1使得其保留 j-i+1位数==m的二进制位数
		int numOf_1ShiftLeft = -1 >>> (32 - (j - i + 1));
		// 将上步的结果再左移i位
		int num_1ShiftLeftShiftRight = numOf_1ShiftLeft << i;
		// 对上步的结果，取反操作可得 i~j位为0的二进制数
		int invertNum = ~num_1ShiftLeftShiftRight;

		// 将取反的数据，再与n取逻辑与操作
		int numAndIvert = invertNum & n;

		// 将m 左移i位
		int mShiftLeft = m << i;
		// 将m左移i位的结果 或 上 numAndIvert
		int res = mShiftLeft | numAndIvert;

		return res;
	}

	@Test
	public void test() {
		System.out.println(updateBits(1024, 21, 2, 6));
	}

}
