package bit.apply.exclusive.or;

import org.junit.Test;

import utile.PrintMessageUtil;

/**
 * 先验知识：<br>
 * a^b^b=a <br>
 * 举个栗子: <br>
 * 0 1 0 1------a <br>
 * ^<br>
 * 1 0 0 1------b <br>
 * —————————— <br>
 * 1 1 0 0<br>
 * ^<br>
 * 1 0 0 1------b<br>
 * ——————————<br>
 * 0 1 0 1------a<br>
 * 
 *
 */
/**
 * 应用一：数组中，只有一个数出现一次，剩下都出现两次，找出出现一次的数<br>
 * 
 * 只要对数组中的数据依次做异或操作即可
 * 
 * @author BrianCai
 *
 */
public class SingleNum1 {
	public int findSingleNum(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			res ^= nums[i];// 连续做异或操作
		}
		return res;
	}

	@Test
	public void test() {
		PrintMessageUtil.printMsgWithoutNewLine(findSingleNum(new int[] { 1, 1, 2, 2, 3 }));
	}
	/**
	 * 代码的执行过程: <br>
	 * 0 1 --------1<br>
	 * ^<br>
	 * 0 1 --------1<br>
	 * -------<br>
	 * 0 0 --------0<br>
	 * ^<br>
	 * 1 0 --------3<br>
	 * -------<br>
	 * 1 0 --------2<br>
	 * ^<br>
	 * 1 0 --------2<br>
	 * -------<br>
	 * 0 0 --------0<br>
	 * ^<br>
	 * 1 1 --------3<br>
	 * -------<br>
	 * 1 1 --------3<br>
	 * 还发现两个规律就是：<br>
	 * 两个相同的数异或值为0<br>
	 * 0与任何二进制i中的异或结果都为i，则异或的值依然是原值(这条规律还可以推广到如何保留二进制的某几位数不变)<br>
	 */
}
