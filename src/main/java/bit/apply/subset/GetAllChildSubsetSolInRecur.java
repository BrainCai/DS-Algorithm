package bit.apply.subset;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * ����һ�����飬������Ϊ[1,n]���������飬����������Ӽ� �ݹ��㷨��
 * 
 * @author Administrator
 *
 */
public class GetAllChildSubsetSolInRecur {

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
	public List<List<Integer>> getAllChildListSet(int idx, int[] nums) {
		// ���������Ӽ�����,�˴����ܳ�ʼ��
		List<List<Integer>> allChildListSet;
		// ����ݹ�ı߽����������壺��������������󣬴�ʱǡ���ǿռ���Ҳ�Ǽ��ϵ�һ���Ӽ�
		if (idx >= nums.length) {
			allChildListSet = new ArrayList<>();// ����߽������󴴽������Ӽ�����
			allChildListSet.add(new ArrayList<>());// ���������������ǡ���ǿռ���Ҳ�����Ӽ�
		} else {
			allChildListSet = getAllChildListSet(idx + 1, nums);
			// ȡ����ǰ��Ԫ��
			int item = nums[idx];
			// ������ʱ�Ӽ����ϣ�����ǰԪ�طַ�����ǰallChildListSet�е��Ӽ��У�������append��allChildListSet��
			List<List<Integer>> tmpChildListSet = new ArrayList<>();
			// ����allChildListSet�е������Ӽ�������ǰԪ����ӵ������Ӽ���
			for (List<Integer> listAlreadyInChildListSet : allChildListSet) {
				List<Integer> currentChildList = new ArrayList<>();
				// �����е��Ӽ��е�Ԫ��append��currentChildList��
				currentChildList.addAll(listAlreadyInChildListSet);
				// ����ǰԪ����ӵ�currentChildList��
				currentChildList.add(item);
				// ��currentChildList׷�ӵ�tmpChildListSet��
				tmpChildListSet.add(currentChildList);
			}
			// ��tmpChildListSet׷�ӵ�(append)allChildListSet��
			allChildListSet.addAll(tmpChildListSet);
		}
		return allChildListSet;
	}

	@Test
	public void test() {
		int[] nums = new int[] { 1, 2, 3 };
		System.out.println(JSON.toJSONString(getAllChildListSet(0, nums)));
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