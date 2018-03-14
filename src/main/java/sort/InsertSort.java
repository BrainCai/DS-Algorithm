package sort;

import org.junit.Test;

import utile.PrintMessageUtil;

/**
 * ֱ�Ӳ�������
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
		// �ٶ���һԪ��nums[0]������
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {// �ʼдʱ�����԰����Լ����е�˼·д��Ȼ���ٽ����Ż�
				// ��Ϊ��һ��Ԫ���Ѿ��ȽϹ��ˣ���������ֱ�ӽ���Ԫ������ƶ�һλ
				// ���ƶ�֮ǰ���Ƚ���Ԫ�ر�����������Ϊ������һ����и���
				tmp = nums[i];
				nums[i] = nums[i - 1];
				// nums[i - 1] = tmp;�˲��ĸ�����û������ģ����Բ���Ҫ
				// ��Ԫ������ƶ�
				int j;
				for (j = i - 2; j >= 0 && tmp < nums[j]; --j) {
					nums[j + 1] = nums[j];
				}
				// ��������ѭ������ ������ʱ��˵����ʱnums[j]�Ѿ�������a[i]�ˣ����Խ���ֵ���뼴��
				nums[j + 1] = tmp;
			}

		}
		PrintMessageUtil.printIntArrayWithoutNewline(nums);
	}

	@Test
	public void test() {
		int[] nums = new int[] { 100, 10, 2, 8, 4 };
		insertSort(nums);
		// moveItem2Right(nums);// ����Ľ�������ǿ�����nums���������һ��Ԫ�ر����ǣ���һ��Ԫ���ظ�
		// moveItem2Left(nums);// ����ļǹ���ǡ�ú������ƶ��෴�����Ծ������һ��Ԫ���ظ�����һ��Ԫ�ر�����
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
	 * ���������ƶ�һ��Ԫ��
	 * 
	 * @param nums
	 */
	public void moveItem2Right(int nums[]) {
		if (nums.length == 0) {
			return;
		}
		/**
		 * 1�������ƶ�Ԫ��һ���Ǵ������β����ʼ��ע���±겻��Խ��Ĵ���<br>
		 * 2����ֵ�Ĺ�ϵʱnums[j+1] = nums[j],��ǰ���Ԫ�ظ�ֵ�������Ԫ��<br>
		 * 3��С���ɣ�������ʽ����[j+n]�Ĳ�������һ��Ҫע������߽��޸�Ϊ[0,nums.length-n-1]<br>
		 * �����[j-n]�������±߽�һ�����޸�Ϊ[n,length-1]
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
		// �ٶ���һԪ��nums[0]������
		int tmp;
		int insertIdx = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {// �ʼдʱ�����԰����Լ����е�˼·д��Ȼ���ٽ����Ż�
				// ��Ϊ��һ��Ԫ���Ѿ��ȽϹ��ˣ���������ֱ�ӽ���Ԫ������ƶ�һλ
				// ���ƶ�֮ǰ���Ƚ���Ԫ�ر�����������Ϊ������һ����и���
				tmp = nums[i];
				nums[i] = nums[i - 1];
				nums[i - 1] = tmp;
				// ��Ԫ������ƶ�
				for (int j = i - 2; nums[i - 1] < nums[j]; --j) {
					nums[j + 1] = nums[j];
					insertIdx = j;// �˴��ڵ�һ�α�дʱ��
				}
				// ��������ѭ������������ʱ��˵����ʱnums[j]�Ѿ�������a[i]�ˣ����Խ���ֵ���뼴��
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
		// �ٶ���һԪ��nums[0]������
		int insertIdx = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {// �ʼдʱ�����԰����Լ����е�˼·д��Ȼ���ٽ����Ż�
				// ��Ϊ��һ��Ԫ���Ѿ��ȽϹ��ˣ���������ֱ�ӽ���Ԫ������ƶ�һλ
				// ���ƶ�֮ǰ���Ƚ���Ԫ�ر�����������Ϊ������һ����и���
				tmp = nums[i];
				nums[i] = nums[i - 1];
				nums[i - 1] = tmp;
				// ��Ԫ������ƶ�
				for (int j = i - 2; j >= 0 && tmp < nums[j]; --j) {
					nums[j + 1] = nums[j];
					insertIdx = j;// �˴��ڵ�һ�α�дʱ��
				}
				// ��������ѭ������ ������ʱ��˵����ʱnums[j]�Ѿ�������a[i]�ˣ����Խ���ֵ���뼴��
				nums[insertIdx + 1] = insertIdx == 0 ? nums[1] : tmp;
			}

		}
		PrintMessageUtil.printIntArrayWithoutNewline(nums);
	}
}
