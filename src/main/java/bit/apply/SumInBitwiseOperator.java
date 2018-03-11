package bit.apply;

import org.junit.Test;

/**
 * ������������a��b, �����ǵĺ�, ������ʹ�� + ����ѧ�����<br>
 * 
 * 
 * �˴��Ҹ��˵Ľⷨ��aplusb2����Ȼ��������ģ���Ϊ����ʹ���˼ӷ���<br>
 * ���� 5+7 �Ĺ��̣�<br>
 * 5=0101 <br>
 * 7=0111 <br>
 * �����Ƶļ����������̣�<br>
 * 0101 <br>
 * + <br>
 * 0111 <br>
 * ������������<br>
 * 0010 -----���ӽ�λ�Ľ��<br>
 * + <br>
 * 1010 -----���������λ������õ���λ���<br>
 * ������������<br>
 * 1000 -----��һ�ֵ�������ӣ����ӽ�λ�Ľ��<br>
 * +<br>
 * 0100<br>
 * ������������ <br>
 * 1000
 * 
 * 
 * @author BrianCai
 *
 */
public class SumInBitwiseOperator {
	public int aplusb(int a, int b) {
		while (b != 0) {
			int _a = a ^ b;// ���㲻�ӽ�λ�Ľ��
			int _b = (a & b) << 1;// ���㱾��Ӧ�����ϵĽ�λ���������м���
			a = _a;// ����aֵ
			b = _b;// ����bֵ
		}
		return a;
	}

	@Test
	public void test() {
		System.out.println(aplusb(5, 7));
	}

	/**
	 * ����ⷨ��δ����ᵽ�ӷ��ĺ���
	 */
	// public int aplusb2(int a, int b) {
	// int a1 = (a ^ b);
	// int b1 = (a & b);
	// b1 = b1 << 1;
	// return a1 + b1;// �˴�����ʹ���˼ӷ�
	// }
}
