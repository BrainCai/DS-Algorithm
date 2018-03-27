package dp.recurion;

import org.junit.Test;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray
 * [4,-1,2,1] has the largest sum = 6.
 * 
 * @author Administrator
 *
 */
public class MaxSubarray {

	public int[] maxbarry(int[] nums) {

		if (nums.length == 0) {
			return null;
		}

		// return findMaxSubarray(nums, 0);
		return null;

	}

	private int findMaxSubarray(int[] nums, int i) {

		if (i >= nums.length) {
			return 0;
		}

		return 0;
	}

	/**
	 * 求和
	 * 
	 * @param nums
	 * @param i
	 * @return
	 */
	private int sumArray(int[] nums, int i) {

		if (i >= nums.length) {
			return 0;
		}

		return sumArray(nums, i + 1) + nums[i];
	}

	/**
	 * 求最大和，元素不连续 《 求所有的元素的子集》类比
	 * 
	 * @param nums
	 * @param i
	 * @return
	 */
	private int sumArrayMax(int[] nums, int i) {

		if (i >= nums.length) {
			return 0;
		}

		// int a = sumArrayMax(nums, i + 1) + nums[i]; // 加上当前的nums[i]
		// int b = sumArrayMax(nums, i + 1);// 不加上当前的nums[i]
		// return Math.max(a, b);
		return Math.max(sumArrayMax(nums, i + 1) + nums[i], sumArrayMax(nums, i + 1));
	}

	static int sumSubarrayMax(int A[], int Left, int Right) {
		int MaxLeftSum, MaxRightSum;
		int MaxLeftBorderSum, MaxRightBorderSum;
		int LeftBorderSum, RightBorderSum;
		int Center, i;

		if (Left == Right) {
			if (A[Left] > 0)
				return A[Left];
			else
				return 0;
		}

		Center = (Left + Right) / 2;
		MaxLeftSum = sumSubarrayMax(A, Left, Center);
		MaxRightSum = sumSubarrayMax(A, Center + 1, Right);

		MaxLeftBorderSum = 0;
		LeftBorderSum = 0;
		for (i = Center; i >= Left; i--) {
			LeftBorderSum += A[i];
			if (LeftBorderSum > MaxLeftBorderSum)
				MaxLeftBorderSum = LeftBorderSum;
		}

		MaxRightBorderSum = 0;
		RightBorderSum = 0;
		for (i = Center + 1; i <= Right; i++) {
			RightBorderSum += A[i];
			if (RightBorderSum > MaxRightBorderSum)
				MaxRightBorderSum = RightBorderSum;
		}

		return Max(MaxLeftSum, MaxRightSum, MaxLeftBorderSum + MaxRightBorderSum);
	}

	static int Max(int a, int b, int c) {
		if (a > b && a > c)
			return a;
		else if (b > a && b > c)
			return b;
		else
			return c;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 4, -3, 5, -2, -1, 2, 6, -2 };
		int left = 0;
		int right = a.length - 1;
		System.out.println(sumSubarrayMax(a, left, right));
	}

	@Test
	public void test() {
		int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println("数组和 : " + sumArray(nums, 0));
		System.out.println("数组元素和最大值：" + sumArrayMax(nums, 0));
		// System.out.println("数组连续元素和最大值：" + sumSubarrayMax(0, nums.length));
	}
}
