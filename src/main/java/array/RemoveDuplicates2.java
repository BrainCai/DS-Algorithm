package array;

import org.junit.Test;

/**
 * 
 * 我的解法是：使用set集合，但是set集合取值难以取出，而且无法对数组的中值进行修改， 所以，
 *
 * 给定的是一个排序的集合，这是解题的关键<br>
 * Given a **sorted** array nums, remove the duplicates in-place such that each
 * element appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * @author caiqiang
 * @version 2018年5月6日
 * @see RemoveDuplicates2
 * @since
 */
public class RemoveDuplicates2 {
	public int removeDuplicates(int[] nums) {

		if (nums.length == 0 && nums == null)
			return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				// 算法设计巧妙，利用快慢指针，如果相等则i++停止移动，直到重复值全部走完，i++才移动
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;

	}

	@Test
	public void test() {
		int[] nums = new int[] { -3, -1, 0, 0, 0, 3, 3 };
		removeDuplicates(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}

	}
}
