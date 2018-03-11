package bit.apply.subset;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author 非递归算法
 *
 */
public class GetAllSubsetSolNonRecur {

	public List<List<Integer>> getAllSubsetList(int[] nums) {

		if (nums.length == 0) {
			return null;
		}
		List<List<Integer>> allSubsetList = new ArrayList<>();

		// 添加空集
		allSubsetList.add(new ArrayList<>());

		for (int i = 0; i < nums.length; i++) {
			// 创建一个tempSubsetList
			List<List<Integer>> tmpSubsetList = new ArrayList<>();
			for (List<Integer> setAlreadyIn : allSubsetList) {
				// 创建当前的子集currentSubSet
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
