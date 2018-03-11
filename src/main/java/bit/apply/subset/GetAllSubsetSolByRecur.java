package bit.apply.subset;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * ����һ���������飬����������Ӽ� �ݹ��㷨��
 * 
 * @author Administrator
 *
 */
public class GetAllSubsetSolByRecur {

	/**
	 * ����ģ��1�����еĹ�������ĵݹ�д��һ���ǻ��ڣ���������ĵݹ�д����<br>
	 * �ݹ���ǵݹ飺<br>
	 * �ݹ���ص���Ǵ���ʼλ�ÿ�ʼ0~i��һֱִ�е�i�߽�������Ȼ���ٷ���ÿ��������Ľ��������Ϊi-1�ľֲ�����ʹ�á�<br>
	 * �����е�ִ��˳���ǣ�<br>
	 * i��0��ʼһֱ��nums.length-1,Ȼ��ִ�к����岿�֣�Ȼ��iִ�еĽ������Ϊ�ֲ�������i-1ʹ��
	 * 
	 * ���ν���Ĺؼ�����: <br>
	 * 1����������ĵݹ��ģ��д��<br>
	 * 2���ݹ�ı߽���������allChildSubSet,����ӱ߽�����ʱ���Ӽ�ǡ��Ϊ�ռ���Ȼ��һ��Ԫ�أ�
	 * ������Ԫ�طַ���ÿ���Ӽ��У������allChildSubset��
	 * 
	 * @param idx
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> getAllSubsetList(int idx, int[] nums) {
		// ���������Ӽ�����,�˴����ܳ�ʼ��
		List<List<Integer>> allSubsetList;
		// ����ݹ�ı߽����������壺��������������󣬴�ʱǡ���ǿռ���Ҳ�Ǽ��ϵ�һ���Ӽ�
		if (idx >= nums.length) {
			allSubsetList = new ArrayList<>();// ����߽������󴴽������Ӽ�����
			allSubsetList.add(new ArrayList<>());// ���������������ǡ���ǿռ���Ҳ�����Ӽ�
		} else {
			allSubsetList = getAllSubsetList(idx + 1, nums);
			// ȡ����ǰ��Ԫ��
			int item = nums[idx];
			// ������ʱ�Ӽ����ϣ�����ǰԪ�طַ�����ǰallSubsetList�е��Ӽ��У�������append��allSubsetList��
			List<List<Integer>> tmpChildListSet = new ArrayList<>();
			// ����allSubsetList�е������Ӽ�������ǰԪ����ӵ������Ӽ���
			for (List<Integer> listAlreadyInChildListSet : allSubsetList) {
				List<Integer> currentChildList = new ArrayList<>();
				// �����е��Ӽ��е�Ԫ��append��currentChildList��
				currentChildList.addAll(listAlreadyInChildListSet);
				// ����ǰԪ����ӵ�currentChildList��
				currentChildList.add(item);
				// ��currentChildList׷�ӵ�tmpChildListSet��
				tmpChildListSet.add(currentChildList);
			}
			// ��tmpChildListSet׷�ӵ�(append)allSubsetList��
			allSubsetList.addAll(tmpChildListSet);
		}
		return allSubsetList;
	}

	@Test
	public void test() {
		int[] nums = new int[] { 1, 2, 3 };
		System.out.println(JSON.toJSONString(getAllSubsetList(0, nums)));
	}
}

// for (int i = 0; i < nums.length; i++) {
// // ����ÿ���Ӽ�
// List<Integer> innerList = new ArrayList<>();
// innerList.add(nums[i]);
// for (int j = i + 1; j < nums.length; j++) {
// innerList.add(nums[j]);
// }
// }