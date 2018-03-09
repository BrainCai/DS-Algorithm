package bit.apply;

import org.junit.Test;

/**
 * ������������a��b, �����ǵĺ�, ������ʹ�� + ����ѧ�����
 * 
 * @author BrianCai
 *
 */
public class SumInBitwiseOperator {
	public int aplusb(int a, int b) {
		while (b != 0) {
			int _a = a ^ b;
			int _b = (a & b) << 1;
			a = _a;
			b = _b;
		}
		return a;
	}

	public int aplusb2(int a, int b) {
		int a1 = (a ^ b);
		int b1 = (a & b);
		b1 = b1 << 1;
		return a1 + b1;
	}

	@Test
	public void test() {
		System.out.println(aplusb(5, 7));
	}
}
