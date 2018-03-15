package sort;

import org.junit.Test;

/**
 * ð������<br>
 * �㷨TC�½���O(n)��<br>
 * ���裺<br>
 * ������Ԫ�ػ����������ϣ���һ�����Ѿ����򣬵ڶ�����δ���򣬴ӵڶ�������ȡ��һ��Ԫ�أ�������һ�����е�Ԫ�أ��ҵ�����н���Ԫ�ء�
 * 
 * @author Administrator
 *
 */
public class BubbleSort {

	/**
	 * ð������ ʵ��˼·<br>
	 * 1�����ڼ�¼����<br>
	 * 2��m��¼���ȣ���flag ��¼�Ƿ��ֽ�����<br>
	 * 3��ÿ�������ʹ�����������һ���ȽϿռ䶯̬�仯<br>
	 * 4����num[i+1]>num[i]ʱ��һ����n[i+1]~num[0]���������У�������ִ�н�����¼
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
					swap(nums, i, i + 1);// ����
					falg = true;
				}
			}
			m--;
		}

		return nums;

	}

	/**
	 * ����Ԫ��
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
