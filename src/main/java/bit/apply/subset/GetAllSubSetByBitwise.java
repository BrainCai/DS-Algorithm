package bit.apply.subset;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import utile.PrintMessageUtil;

/**
 * ����һ����������������,�������������Ӽ���
 * 
 * ��λ��ʶ�����
 * 
 * �ؼ���:<br>
 * 1-n������������nλ����������������ÿ���Ӽ�������i�������֣����Ǿ���nλ��д��1����Ϊ0��<br>
 * ���裺<br>
 * 1������0-n-1������<br>
 * 2����1���߼���������������㣬�жϴ�������n(������±�)�а���1��λ��i��ȡ��num[i]<br>
 * 
 * @authdor BrianCai
 *
 */
public class GetAllSubSetByBitwise {

	/**
	 * ��ӡ[0,n-1]������Χ���Ӽ�
	 * 
	 * @param num
	 * @return
	 */
	public List<List<Integer>> printAllSubsetByBitwise(int num) {
		// �����Ƶĳ��ȣ��˴�Ϊ�˸����Ķ����룬�����޸��˱������������⺬��
		int binaryNum = num;
		// ����0-n-1
		for (int i = 0; i < 1 << binaryNum; i++) {
			// �ж�i�а�����1�ĸ����������ǣ��ж�1��i���߼����������������
			PrintMessageUtil.printMsgWithoutNewLine("[");
			for (int idxInBinary = 0; idxInBinary < binaryNum; idxInBinary++) {
				if (((1 << idxInBinary) & i) > 0) {
					PrintMessageUtil.printMsgWithoutNewLine(idxInBinary);
				}
			}
			PrintMessageUtil.printMsgWithNewLine("]");
		}

		return null;

	}

	/**
	 * ��ȡһ��[0,n-1]�����������Ӽ�
	 * 
	 * @param num
	 * @return
	 */
	public List<List<Integer>> getAllSubsetByBitwise(int num) {
		// �����Ƶĳ��ȣ��˴�Ϊ�˸����Ķ����룬�����޸��˱������������⺬��
		int binaryNum = num;
		// ����0-n-1
		List<List<Integer>> allSubsetList = new ArrayList<>();
		for (int i = 0; i < 1 << binaryNum; i++) {
			// �ж�i�а�����1�ĸ����������ǣ��ж�1��i���߼����������������
			// PrintMessageUtil.printMsgWithoutNewLine("[");
			List<Integer> subset = new ArrayList<>();
			for (int idxInBinary = 0; idxInBinary < binaryNum; idxInBinary++) {
				if (((1 << idxInBinary) & i) > 0) {
					subset.add(idxInBinary);
				}
			}
			PrintMessageUtil.printMsgWithNewLine(subset);
			allSubsetList.add(subset);
			// PrintMessageUtil.printMsgWithNewLine("]");
		}

		return allSubsetList;

	}

	/**
	 * ���������������飬�������е��Ӽ�
	 * 
	 * @param num
	 * @return
	 */
	public List<List<Integer>> getAllSubsetByBitwise(int[] nums) {
		// �����Ƶĳ��ȣ��˴�Ϊ�˸����Ķ����룬�����޸��˱������������⺬��
		int binaryNum = nums.length;
		// ����0-n-1
		List<List<Integer>> allSubsetList = new ArrayList<>();
		for (int i = 0; i < 1 << binaryNum; i++) {
			// �ж�i�а�����1�ĸ����������ǣ��ж�1��i���߼����������������
			// PrintMessageUtil.printMsgWithoutNewLine("[");
			List<Integer> subset = new ArrayList<>();
			for (int idxInBinary = 0; idxInBinary < binaryNum; idxInBinary++) {
				if (((1 << idxInBinary) & i) > 0) {
					subset.add(nums[idxInBinary]);// --------ֻ�д˴�������Ĳ�ͬ
				}
			}
			PrintMessageUtil.printMsgWithNewLine(subset);
			allSubsetList.add(subset);
			// PrintMessageUtil.printMsgWithNewLine("]");
		}

		return allSubsetList;

	}

	@Test
	public void test() {
		// printAllSubsetByBitwise(3);
		// getAllSubsetByBitwise(3);
		getAllSubsetByBitwise(new int[] { 1, 2, 3 });
	}

}
