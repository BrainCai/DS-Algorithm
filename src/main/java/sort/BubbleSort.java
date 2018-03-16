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
public class BubbleSort {

	/**
	 * 冒泡排序 实现思路<br>
	 * 1、基于记录交换<br>
	 * 2、m记录长度，用flag 记录是否发现交换。<br>
	 * 3、每趟排序后，使得搜索区间减一。比较空间动态变化<br>
	 * 4、当num[i+1]>num[i]时，一定有n[i+1]~num[0]是有序序列，不会再执行交换记录
	 * 
	 * @param nums
	 * @return
	 */
	public int[] bubbleSort(int[] nums) {

		if (nums.length == 0) {
			return null;
		}
		int m = nums.length - 1;
		boolean falg = true;
		while (m >= 0 && falg) {
			falg = false;
			// for (int i = 0; i < nums.length - 1; i++) {
			for (int i = 0; i < m; i++) {
				if (nums[i] > nums[i + 1]) {
					swap(nums, i, i + 1);// 交换
					falg = true;
				}
			}
			m--;
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

	@Test
	public void test() {
		int[] nums = new int[] { 5, 3, 10, 9, 1, 1 };
		// insertSort(nums);
		bubbleSort(nums);
		for (int i : nums) {
			System.out.print(i + " - ");
		}
	}

}
