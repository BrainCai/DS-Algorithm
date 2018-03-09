package bit.base;

import org.junit.Test;

import utile.PrintMessageUtil;

/**
 * Java�е���λ���� <br>
 * ��������<br>
 * -------�ڲ����������µ��� ԭ����*2^n <br>
 * �������㣺<br>
 * -------�߼�����--->��λ���㣬����λ������<br>
 * -------��������--->��λ������λ ��/�����㣺 -------ע������0��λ��10&44
 * 
 * @author BrianCai
 *
 */
public class ShiftOperators {

	/**
	 * ��������
	 */
	public void leftShiftOperator(int n, int bitmask) {
		if (n < Integer.MAX_VALUE) {
			PrintMessageUtil.printMesssageWithNewLines(n + " ����   " + bitmask + "  λ==" + (n << bitmask));
		}
	}

	/**
	 * ���������㷨---��λ������λ
	 */
	public void rightShiftOperator(int num, int bitmask) {
		if (num < Integer.MAX_VALUE) {
			PrintMessageUtil.printMesssageWithNewLines(num + " �������� " + bitmask + " λ==" + (num >> bitmask));
		}
	}

	/**
	 * �޷��ŵ������㷨---�߼�����,��λ����
	 */
	public void unsignedRightShiftOperator(int num, int bitmask) {
		if (num < Integer.MAX_VALUE) {
			PrintMessageUtil.printMesssageWithNewLines(num + " �߼����� " + bitmask + " λ==" + (num >>> bitmask));
		}
	}

	/**
	 * �߼������
	 * 
	 * @param num1
	 * @param num2
	 */
	public void andOperator(int num1, int num2) {
		if (num1 > Integer.MAX_VALUE || num2 > Integer.MAX_VALUE) {
			return;
		}
		PrintMessageUtil.printMesssageWithNewLines(num1 + "/" + num2 + " �߼���Ľ��== " + (num1 & num2));
	}

	/**
	 * �߼������
	 * 
	 * @param num1
	 * @param num2
	 */
	public void orOperator(int num1, int num2) {
		if (num1 > Integer.MAX_VALUE || num2 > Integer.MAX_VALUE) {
			return;
		}
		PrintMessageUtil.printMesssageWithNewLines(num1 + "/" + num2 + " �߼���Ľ��==  " + (num1 | num2));

	}

	/**
	 * ȡ����<br>
	 * ע�����λҲ�������㣬������������������λ������
	 * 
	 * @param num
	 */
	public void inverts(int num) {
		if (num <= Integer.MAX_VALUE) {
			PrintMessageUtil.printMesssageWithNewLines(num + " ȡ��~== " + (~num));
		}
	}

	public void exclusiveOr(int num1, int num2) {
		if (num1 > Integer.MAX_VALUE || num2 > Integer.MAX_VALUE) {
			return;
		}
		PrintMessageUtil.printMesssageWithNewLines(num1 + "/" + num2 + "  ������ ^  " + (num1 ^ num2));
	}

	@Test
	public void test() {
		leftShiftOperator(8, 2);// ���Ʋ���
		rightShiftOperator(-127, 2);// ��������
		unsignedRightShiftOperator(-127, 2);// �߼�����
		andOperator(10, 44);// �����
		orOperator(10, 44);// �����
		inverts(1);// ȡ������
		exclusiveOr(10, 44);// ������
	}
}
