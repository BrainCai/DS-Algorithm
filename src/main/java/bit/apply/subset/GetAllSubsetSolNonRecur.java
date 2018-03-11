package bit.apply.subset;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author �ǵݹ��㷨
 *
 */
public class GetAllSubsetSolNonRecur {

	public List<List<Integer>> getAllSubsetList(int[] nums) {

		if (nums.length == 0) {
			return null;
		}
		List<List<Integer>> allSubsetList = new ArrayList<>();

		// ��ӿռ�
		allSubsetList.add(new ArrayList<>());

		for (int i = 0; i < nums.length; i++) {
			// ����һ��tempSubsetList
			List<List<Integer>> tmpSubsetList = new ArrayList<>();
			for (List<Integer> setAlreadyIn : allSubsetList) {
				// ������ǰ���Ӽ�currentSubSet
				List<Integer> currentSubset = new ArrayList<>();
				currentSubset.addAll(setAlreadyIn);
				currentSubset.add(nums[i]);
				tmpSubsetList.add(currentSubset);
			}
			allSubsetList.addAll(tmpSubsetList);
		}

		return allSubsetList;
	}

	@Test
	public void test() {
		int[] nums = new int[] { 1, 2, 3 };
		System.out.println(JSON.toJSONString(getAllSubsetList(nums)));
	}
}
