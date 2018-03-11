package bit.base;

import org.junit.Test;

import utile.PrintMessageUtil;

/**
 * Java中的移位运算 <br>
 * 左移运算<br>
 * -------在不溢出的情况下等于 原数据*2^n <br>
 * 右移运算：<br>
 * -------逻辑运算--->高位补零，符号位不参与<br>
 * -------算术运算--->高位补符号位 与/或运算： -------注意是用0补位。10&44
 * 
 * @author BrianCai
 *
 */
public class ShiftOperators {

	/**
	 * 左移运算
	 */
	public void leftShiftOperator(int n, int bitmask) {
		if (n < Integer.MAX_VALUE) {
			PrintMessageUtil.printMsgWithNewLine(n + " 左移   " + bitmask + "  位==" + (n << bitmask));
		}
	}

	/**
	 * 算术右移算法---高位补符号位
	 */
	public void rightShiftOperator(int num, int bitmask) {
		if (num < Integer.MAX_VALUE) {
			PrintMessageUtil.printMsgWithNewLine(num + " 算术右移 " + bitmask + " 位==" + (num >> bitmask));
		}
	}

	/**
	 * 无符号的右移算法---逻辑右移,高位补零
	 */
	public void unsignedRightShiftOperator(int num, int bitmask) {
		if (num < Integer.MAX_VALUE) {
			PrintMessageUtil.printMsgWithNewLine(num + " 逻辑右移 " + bitmask + " 位==" + (num >>> bitmask));
		}
	}

	/**
	 * 逻辑与操作
	 * 
	 * @param num1
	 * @param num2
	 */
	public void andOperator(int num1, int num2) {
		if (num1 > Integer.MAX_VALUE || num2 > Integer.MAX_VALUE) {
			return;
		}
		PrintMessageUtil.printMsgWithNewLine(num1 + "/" + num2 + " 逻辑与的结果== " + (num1 & num2));
	}

	/**
	 * 逻辑或操作
	 * 
	 * @param num1
	 * @param num2
	 */
	public void orOperator(int num1, int num2) {
		if (num1 > Integer.MAX_VALUE || num2 > Integer.MAX_VALUE) {
			return;
		}
		PrintMessageUtil.printMsgWithNewLine(num1 + "/" + num2 + " 逻辑或的结果==  " + (num1 | num2));

	}

	/**
	 * 取反：<br>
	 * 注意符号位也参与运算，正数负数都会加入符号位的运算
	 * 
	 * @param num
	 */
	public void inverts(int num) {
		if (num <= Integer.MAX_VALUE) {
			PrintMessageUtil.printMsgWithNewLine(num + " 取反~== " + (~num));
		}
	}

	public void exclusiveOr(int num1, int num2) {
		if (num1 > Integer.MAX_VALUE || num2 > Integer.MAX_VALUE) {
			return;
		}
		PrintMessageUtil.printMsgWithNewLine(num1 + "/" + num2 + "  异或操作 ^  " + (num1 ^ num2));
	}

	@Test
	public void test() {
		leftShiftOperator(8, 2);// 左移操作
		rightShiftOperator(-127, 2);// 算术右移
		unsignedRightShiftOperator(-127, 2);// 逻辑右移
		andOperator(10, 44);// 与操作
		orOperator(10, 44);// 或操作
		inverts(1);// 取反操作
		exclusiveOr(10, 44);// 异或操作
	}
}
