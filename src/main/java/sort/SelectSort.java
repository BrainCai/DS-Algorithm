package sort;

import org.junit.Test;

/**
 * 选择排序<br>
 * 算法TC下界是O(n)的<br>
 * 步骤：<br>
 * 将数组元素划分两个集合，第一部分已经排序，第二部分未排序，从第二部分中取出一个元素，遍历第一部分中的元素，找到后进行交换元素。
 * 
 * @author Administrator
 *
 */
public class SelectSort {

	/**
	 * 
	 * Description:在一维搜索最小值的小标<br>
	 * 
	 * 一维搜索，每次只能返回一个区间内最小值的下标。每次返回全局的最小值，并且属于"猴子掰玉米，掰完就扔，没有记录"<br>
	 * 
	 * 
	 * @param nums
	 * @return int
	 *
	 * @see
	 */
	public int sigleSearch(int[] nums) {

		if (nums.length == 0 || nums == null) {
			return -Integer.MIN_VALUE;
		}

		int minIdx = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[minIdx] > nums[i]) {
				minIdx = i;
			}
		}

		return minIdx;
	}

	/**
	 * 选择排序<br>
	 * 选择排序核心点是：<br>
	 * 过程：<br>
	 * 假定排序子区间第一个元素最小，然后将其与其后元素进行比较，<br>
	 * 如果大于则更新最小值的下标。在外层循环结束后交换第一个元素与最小元素保证最小元素在子区间起始位置<br>
	 * 寻找子区间的最小元素的下标并让其始终处于区间开始位置<br>
	 * 
	 * @param nums
	 * @return
	 */
	public int[] selectSort(int[] nums) {

		for (int i = 0; i < nums.length - 1; i++) {

			int min_idx = search(nums, i);// 完成一维搜索并返回最小元素下标
			swap(nums, min_idx, i);// 此处注意必须是在内层for循环结束后，交换元素，因为我们每次循环都要将最小元素扔到当前区间最前面。
		}

		return nums;

	}

	/**
	 * 
	 * Description:一维搜索实现
	 * 
	 * @param nums
	 *            void
	 *
	 * @see
	 */
	public int search(int[] nums, int minIdx) {

		for (int i = minIdx; i < nums.length; i++) {

			if (nums[i] < nums[minIdx]) {
				minIdx = i;
			}
		}
		return minIdx;
	}

	/**
	 * 交换元素
	 * 
	 * @param nums
	 * @param i
	 * @param j
	 */
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
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
		// sort(nums, 0);
		selectSort(nums);
		for (int i : nums) {
			System.out.print(i + " - ");
		}
	}

}
