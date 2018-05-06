package array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

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
 */

/**
 * 
 * 去重 使用set集合，是很直观的一种方式，但是set集合非常差的一点是其取值的过程中，必须使用迭代器，不像list有非常方便的get方法
 *
 * 本题错误的原因是:set 集合在添加时乱序
 *
 * @author caiqiang
 * @version 2018年5月6日
 * @see RemoveDuplicates
 * @since
 */
public class RemoveDuplicates {
	public int removeDuplicates(int[] nums) {

		if (nums.length == 0) {
			return 0;
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}

		Stack<Integer> list = new Stack();
		int current = Integer.MIN_VALUE;
		for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext();) {
			int tmp = iterator.next();
			if (list.size() > 0) {
				current = list.pop();
			} else {
				current = tmp;
			}

			if (current > tmp) {
				list.push(tmp);
				list.push(current);
			} else {
				list.push(current);
				list.push(tmp);
			}
		}
		int j = 0;
		while (!list.isEmpty()) {
			nums[j] = list.pop();
		}
		return set.size();

	}

	@Test
	public void test() {
		int[] nums = new int[] { -3, -1, 0, 0, 0, 3, 3 };

		for (int i = 0; i < removeDuplicates(nums); i++) {
			System.out.println(nums[i]);
		}
	}
}
