package bit.apply.subset;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * 给定一个整数数组，求出其所有子集 递归算法。
 * 
 * @author Administrator
 *
 */
public class GetAllSubsetSolByRecur {

	/**
	 * 体现模板1：所有的关于数组的递归写法一定是基于，数组遍历的递归写法的<br>
	 * 递归与非递归：<br>
	 * 递归的特点就是从起始位置开始0~i，一直执行到i边界条件，然后再返回每个子问题的结果，并作为i-1的局部变量使用。<br>
	 * 本题中的执行顺序是：<br>
	 * i从0开始一直到nums.length-1,然后执行函数体部分，然后将i执行的结果再作为局部变量给i-1使用
	 * 
	 * 本次解题的关键字眼: <br>
	 * 1、数组遍历的递归的模板写法<br>
	 * 2、递归的边界条件创建allChildSubSet,并添加边界条件时的子集恰好为空集，然后一个元素，
	 * 并将该元素分发到每个子集中，并添加allChildSubset中
	 * 
	 * @param idx
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> getAllSubsetList(int idx, int[] nums) {
		// 创建所有子集集合,此处不能初始化
		List<List<Integer>> allSubsetList;
		// 数组递归的边界条件。含义：当数组遍历结束后，此时恰好是空集，也是集合的一个子集
		if (idx >= nums.length) {
			allSubsetList = new ArrayList<>();// 到达边界条件后创建所有子集集合
			allSubsetList.add(new ArrayList<>());// 当数组遍历结束后，恰好是空集，也是其子集
		} else {
			allSubsetList = getAllSubsetList(idx + 1, nums);
			// 取出当前的元素
			int item = nums[idx];
			// 创建临时子集集合，将当前元素分发到当前allSubsetList中的子集中，并将其append到allSubsetList中
			List<List<Integer>> tmpChildListSet = new ArrayList<>();
			// 遍历allSubsetList中的所有子集，将当前元素添加到所有子集中
			for (List<Integer> listAlreadyInChildListSet : allSubsetList) {
				List<Integer> currentChildList = new ArrayList<>();
				// 将已有的子集中的元素append到currentChildList中
				currentChildList.addAll(listAlreadyInChildListSet);
				// 将当前元素添加到currentChildList中
				currentChildList.add(item);
				// 将currentChildList追加到tmpChildListSet中
				tmpChildListSet.add(currentChildList);
			}
			// 将tmpChildListSet追加到(append)allSubsetList中
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
// // 保存每个子集
// List<Integer> innerList = new ArrayList<>();
// innerList.add(nums[i]);
// for (int j = i + 1; j < nums.length; j++) {
// innerList.add(nums[j]);
// }
// }