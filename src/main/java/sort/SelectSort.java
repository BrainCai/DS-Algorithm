package sort;

import org.junit.Test;

/**
 * 冒泡排序<br>
 * 算法TC下界是O(n)的<br>
 * 步骤：<br>
 * 将数组元素划分两个集合，第一部分已经排序，第二部分未排序，从第二部分中取出一个元素，遍历第一部分中的元素，找到后进行交换元素。
 * 
 * @author Administrator
 *
 */
public class SelectSort {

	/**
	 * 选择排序
	 * 
	 * @param nums
	 * @return
	 */
	public int[] selectSort(int[] nums) {

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				swap(nums, i, j);
			}
		}

		return nums;

	}

	/**
	 * 交换元素
	 * 
	 * @param nums
	 * @param i
	 * @param j
	 */
	private void swap(int[] nums, int i, int j) {
		if (nums[i] > nums[j]) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
		}
	}

	/**
	 * 递归版
	 * 
	 * @param nums
	 * @param idx
	 * @return
	 */
	public int[] sort(int[] nums, int idx) {
		if (nums.length == 0) {
			return null;
		}
		_sort(nums, 1);
		return nums;
	}

	private int _sort(int[] nums, int end) {
		if (end >= nums.length) {
			return 0;
		}

		for (int i = 0; i < end; i++) {
			swap(nums, i, end);
			_sort(nums, end + 1);

		}
		return nums[end];
	}

	private void loop(int idx, int[] nums) {
		if (idx >= nums.length) {
			return;
		}
		System.out.println(nums[idx]);
		loop(idx + 1, nums);
	}

	@Test
	public void test() {
		int[] nums = new int[] { 5, 3, 10, 9, 1, 1 };
		// insertSort(nums);
		sort(nums, 0);
		for (int i : nums) {
			System.out.print(i + " - ");
		}
	}

}
