package bit.base;

/**
 * ���������Ķ�����������ż��λ
 * 
 * @author BrianCai <br>
 *         ˼·�� <br>
 *         1������x�Ķ����ƣ����ǿ��Կ�����ż��λ+����λ�� <br>
 *         ���磺1111 <br>
 *         1 0 1 0----evenλ <br>
 *         + 0 1 0 1----oddλ <br>
 *         ----------- <br>
 *         1 1 1 1 <br>
 *         2��ǡ��Ҳ�����ԣ��������λ����һλ��ż��λ����һλ������λ��ż��λ������λ�ã��ٽ�������Ӽ�Ϊ�����������
 */
public class SwapBitPosition {
	public int swapOddEvenBits(int x) {

		// �ֱ�ȡ������λ/ż��λ
		int odd = x & 0x55555555;
		int even = x & 0xaaaaaaaa;
		// ����ͨ����λ���㣬���λ�õĽ���
		odd <<= 1;
		even >>>= 1;
		return odd + even;
	}

}

/**
 * ˼·����ʹ���ַ���������������⣬���Ƿ��֣���xΪ��ֵʱ���޷����ݡ�<br>
 * 
 * ����-2��������ż��λ������Ľ��ֱ�ӱ���<br>
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
