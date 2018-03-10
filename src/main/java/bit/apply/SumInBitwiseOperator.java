package bit.apply;

import org.junit.Test;

/**
 * 给出两个整数a和b, 求他们的和, 但不能使用 + 等数学运算符<br>
 * 
 * 
 * 此处我个人的解法是aplusb2这显然是有问题的，因为其中使用了加法。<br>
 * 计算 5+7 的过程：<br>
 * 5=0101 <br>
 * 7=0111 <br>
 * 二进制的计算完整过程：<br>
 * 0101 <br>
 * + <br>
 * 0111 <br>
 * ——————<br>
 * 0010 -----不加进位的结果<br>
 * + <br>
 * 1010 -----由与运算和位移运算得到进位结果<br>
 * ——————<br>
 * 1000 -----上一轮的两数相加，不加进位的结果<br>
 * +<br>
 * 0100<br>
 * —————— <br>
 * 1000
 * 
 * 
 * @author BrianCai
 *
 */
public class SumInBitwiseOperator {
	public int aplusb(int a, int b) {
		while (b != 0) {
			int _a = a ^ b;// 计算不加进位的结果
			int _b = (a & b) << 1;// 计算本次应当加上的进位，在下轮中加上
			a = _a;// 更新a值
			b = _b;// 更新b值
		}
		return a;
	}

	@Test
	public void test() {
		System.out.println(aplusb(5, 7));
	}

	/**
	 * 错误解法，未能领会到加法的含义
	 */
	// public int aplusb2(int a, int b) {
	// int a1 = (a ^ b);
	// int b1 = (a & b);
	// b1 = b1 << 1;
	// return a1 + b1;// 此处还是使用了加法
	// }
}
