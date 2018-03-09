package leetcode.array;

import org.junit.Test;

/**
 * leet code 1<br>
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 *
 * 其中的错误：<br>
 * 1、在第一个for循环后对idx[0]进行了赋值<br>
 * 2、在第一个for循环之后没有添加return 语句，结束<br>
 * 3、没有添加else的代码进行
 * 
 * @author caiqiang
 * @version 2018年3月9日
 * @see TwoSum
 * @since
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {

		if (nums.length == 0) {
			return null;
		}
		int[] idx = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int a = target - nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (a == nums[j]) {
					idx[0] = i;
					idx[1] = j;
					return idx;
				} else {
					idx[0] = -1;
					idx[1] = -1;
				}
			}
		}
		return idx;
	}

	@Test
	public void test() {
		int[] nums = new int[] { 2, 7, 11, 15 };
		int[] toSum = twoSum(nums, 100);
		for (int i = 0; i < toSum.length; i++) {
			System.out.println(toSum[i]);
		}
	}
}
