package sort;

import org.junit.Test;

/**
 * 快速排序
 * 
 * @author BrianCai
 *
 */
public class QuickSort {

	public void quickSort(int nums[]) {
		int partion = singleSort(0, nums.length - 1, nums);
		singleSort(0, partion - 1, nums);
		singleSort(partion + 1, nums.length - 1, nums);
	}

	private int singleSort(int low, int high, int[] nums) {
		int tmp = nums[low];
		while (low < high) {//
			while (low < high && nums[high] >= tmp) {
				high--;
			}
			nums[low] = nums[high];
			while (low < high && nums[low] <= tmp) {
				low++;
			}
			nums[high] = nums[low];
			System.out.println(low + " | " + high);
		}
		nums[low] = tmp;// 此时low恰好是一趟排序后的tmp应当插入的位置

		return low;
	}

	@Test
	public void test() {
		int[] nums = new int[] { 1, 8, 2, 4, 3 };
		quickSort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
}
