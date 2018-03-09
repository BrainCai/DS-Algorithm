package dp.base.recurion;

import org.junit.Test;

/**
 * 数组的遍历 递归写法
 * 
 * 
 * 
 * @author Administrator
 * 
 */
public class ArrayLoop {

	public void loop(int[] array) {
		if (array.length == 0) {
			return;
		}
		_loop(0, array);
	}

	/**
	 * 递归实现
	 * 
	 * @param i
	 * @param array
	 */
	private void _loop(int i, int[] array) {

		if (i >= array.length) {
			return;
		}
		System.out.println(array[i]);
		_loop(i + 1, array);
	}

	private int sum(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		return _sum(0, array);
	}

	private int _sum(int i, int[] array) {

		if (i >= array.length) {
			return 0;
		}

		return _sum(i + 1, array) + array[i];
	}

	@Test
	public void test() {
		int[] array = new int[] { 2, 3, 1, 5, 9 };
		// loop(array);
		System.out.println(sum(array));
	}

}
