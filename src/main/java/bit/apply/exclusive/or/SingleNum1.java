package bit.apply.exclusive.or;

import org.junit.Test;

import utile.PrintMessageUtil;

/**
 * ����֪ʶ��<br>
 * a^b^b=a <br>
 * �ٸ�����: <br>
 * 0 1 0 1------a <br>
 * ^<br>
 * 1 0 0 1------b <br>
 * �������������������� <br>
 * 1 1 0 0<br>
 * ^<br>
 * 1 0 0 1------b<br>
 * ��������������������<br>
 * 0 1 0 1------a<br>
 * 
 *
 */
/**
 * Ӧ��һ�������У�ֻ��һ��������һ�Σ�ʣ�¶��������Σ��ҳ�����һ�ε���<br>
 * 
 * ֻҪ�������е���������������������
 * 
 * @author BrianCai
 *
 */
public class SingleNum1 {
	public int findSingleNum(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			res ^= nums[i];// ������������
		}
		return res;
	}

	@Test
	public void test() {
		PrintMessageUtil.printMsgWithoutNewLine(findSingleNum(new int[] { 1, 1, 2, 2, 3 }));
	}
	/**
	 * �����ִ�й���: <br>
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
	 * �������������ɾ��ǣ�<br>
	 * ������ͬ�������ֵΪ0<br>
	 * 0���κζ�����i�е��������Ϊi��������ֵ��Ȼ��ԭֵ(�������ɻ������ƹ㵽��α��������Ƶ�ĳ��λ������)<br>
	 */
}
