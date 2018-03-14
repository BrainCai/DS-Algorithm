package sort;

import org.junit.Test;

import utile.PrintMessageUtil;

/**
 * 直接插入排序
 * 
 * @author BrianCai
 *
 */
public class InsertSort {
	void insertSort(int nums[]) {
		if (nums.length == 0) {
			return;
		}
		int tmp;
		// 假定第一元素nums[0]是有序
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {// 最开始写时，可以按照自己已有的思路写，然后再进行优化
				// 因为第一个元素已经比较过了，所以我们直接将该元素向后移动一位
				// 在移动之前，先将该元素保存下来，因为再下面一句会有覆盖
				tmp = nums[i];
				nums[i] = nums[i - 1];
				// nums[i - 1] = tmp;此步的更新是没有意义的，可以不需要
				// 将元素向后移动
				int j;
				for (j = i - 2; j >= 0 && tmp < nums[j]; --j) {
					nums[j + 1] = nums[j];
				}
				// 当不满足循环的限 制条件时，说明此时nums[j]已经不大于a[i]了，所以将该值插入即可
				nums[j + 1] = tmp;
			}

		}
		PrintMessageUtil.printIntArrayWithoutNewline(nums);
	}

	@Test
	public void test() {
		int[] nums = new int[] { 100, 10, 2, 8, 4 };
		insertSort(nums);
		// moveItem2Right(nums);// 输出的结果，我们看到是nums数组中最后一个元素被覆盖，第一个元素重复
		// moveItem2Left(nums);// 输出的记过，恰好和向右移动相反，所以就是最后一个元素重复，第一个元素被覆盖
	}

	private void moveItem2Left(int[] nums) {
		if (nums.length == 0) {
			return;
		}
		for (int i = 1; i < nums.length; i++) {
			nums[i - 1] = nums[i];
		}
		PrintMessageUtil.printIntArrayWithoutNewline(nums);
	}

	/**
	 * 数组向右移动一个元素
	 * 
	 * @param nums
	 */
	public void moveItem2Right(int nums[]) {
		if (nums.length == 0) {
			return;
		}
		/**
		 * 1、向右移动元素一定是从数组的尾部开始，注意下标不能越界的处理<br>
		 * 2、赋值的关系时nums[j+1] = nums[j],将前面的元素赋值给后面的元素<br>
		 * 3、小技巧，如果表达式中有[j+n]的参与运算一定要注意数组边界修改为[0,nums.length-n-1]<br>
		 * 如果有[j-n]则数组下边界一定是修改为[n,length-1]
		 */
		for (int j = nums.length - 2; j >= 0; --j) {
			nums[j + 1] = nums[j];
		}
	}

	void insertSort1(int nums[]) {
		int redType = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				redType = nums[i];
				nums[i] = nums[i - 1];
				for (int j = i - 2; nums[0] < nums[j]; --j) {
					nums[j + 1] = nums[j];
				}
				nums[i + 1] = nums[0];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
	}

	void insertSort2(int nums[]) {
		if (nums.length == 0) {
			return;
		}
		// 假定第一元素nums[0]是有序
		int tmp;
		int insertIdx = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {// 最开始写时，可以按照自己已有的思路写，然后再进行优化
				// 因为第一个元素已经比较过了，所以我们直接将该元素向后移动一位
				// 在移动之前，先将该元素保存下来，因为再下面一句会有覆盖
				tmp = nums[i];
				nums[i] = nums[i - 1];
				nums[i - 1] = tmp;
				// 将元素向后移动
				for (int j = i - 2; nums[i - 1] < nums[j]; --j) {
					nums[j + 1] = nums[j];
					insertIdx = j;// 此处在第一次编写时，
				}
				// 当不满足循环的限制条件时，说明此时nums[j]已经不大于a[i]了，所以将该值插入即可
				nums[insertIdx + 1] = insertIdx == 0 ? nums[1] : tmp;
			}

		}
		PrintMessageUtil.printIntArrayWithoutNewline(nums);
	}

	void insertSort_3(int nums[]) {
		if (nums.length == 0) {
			return;
		}
		int tmp;
		// 假定第一元素nums[0]是有序
		int insertIdx = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {// 最开始写时，可以按照自己已有的思路写，然后再进行优化
				// 因为第一个元素已经比较过了，所以我们直接将该元素向后移动一位
				// 在移动之前，先将该元素保存下来，因为再下面一句会有覆盖
				tmp = nums[i];
				nums[i] = nums[i - 1];
				nums[i - 1] = tmp;
				// 将元素向后移动
				for (int j = i - 2; j >= 0 && tmp < nums[j]; --j) {
					nums[j + 1] = nums[j];
					insertIdx = j;// 此处在第一次编写时，
				}
				// 当不满足循环的限 制条件时，说明此时nums[j]已经不大于a[i]了，所以将该值插入即可
				nums[insertIdx + 1] = insertIdx == 0 ? nums[1] : tmp;
			}

		}
		PrintMessageUtil.printIntArrayWithoutNewline(nums);
	}
}
