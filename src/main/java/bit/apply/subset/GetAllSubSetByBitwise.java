package bit.apply.subset;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import utile.PrintMessageUtil;

/**
 * 给定一个连续的整数数组,求该数组的所有子集。
 * 
 * 用位标识来解决
 * 
 * 关键点:<br>
 * 1-n的数，我们用n位二进制来编码它的每个子集。若第i个数出现，我们就在n位上写上1否则为0。<br>
 * 步骤：<br>
 * 1、遍历0-n-1的数字<br>
 * 2、用1的逻辑与运算和左移运算，判断传进来的n(数组的下标)中包含1的位置i，取出num[i]<br>
 * 
 * @authdor BrianCai
 *
 */
public class GetAllSubSetByBitwise {

	/**
	 * 打印[0,n-1]整数范围的子集
	 * 
	 * @param num
	 * @return
	 */
	public List<List<Integer>> printAllSubsetByBitwise(int num) {
		// 二进制的长度，此处为了更好阅读代码，所以修改了变量名，无特殊含义
		int binaryNum = num;
		// 遍历0-n-1
		for (int i = 0; i < 1 << binaryNum; i++) {
			// 判断i中包含的1的个数，方法是：判断1与i的逻辑与运算和左移运算
			PrintMessageUtil.printMsgWithoutNewLine("[");
			for (int idxInBinary = 0; idxInBinary < binaryNum; idxInBinary++) {
				if (((1 << idxInBinary) & i) > 0) {
					PrintMessageUtil.printMsgWithoutNewLine(idxInBinary);
				}
			}
			PrintMessageUtil.printMsgWithNewLine("]");
		}

		return null;

	}

	/**
	 * 获取一个[0,n-1]整数的所有子集
	 * 
	 * @param num
	 * @return
	 */
	public List<List<Integer>> getAllSubsetByBitwise(int num) {
		// 二进制的长度，此处为了更好阅读代码，所以修改了变量名，无特殊含义
		int binaryNum = num;
		// 遍历0-n-1
		List<List<Integer>> allSubsetList = new ArrayList<>();
		for (int i = 0; i < 1 << binaryNum; i++) {
			// 判断i中包含的1的个数，方法是：判断1与i的逻辑与运算和左移运算
			// PrintMessageUtil.printMsgWithoutNewLine("[");
			List<Integer> subset = new ArrayList<>();
			for (int idxInBinary = 0; idxInBinary < binaryNum; idxInBinary++) {
				if (((1 << idxInBinary) & i) > 0) {
					subset.add(idxInBinary);
				}
			}
			PrintMessageUtil.printMsgWithNewLine(subset);
			allSubsetList.add(subset);
			// PrintMessageUtil.printMsgWithNewLine("]");
		}

		return allSubsetList;

	}

	/**
	 * 给出任意整数数组，求其所有的子集
	 * 
	 * @param num
	 * @return
	 */
	public List<List<Integer>> getAllSubsetByBitwise(int[] nums) {
		// 二进制的长度，此处为了更好阅读代码，所以修改了变量名，无特殊含义
		int binaryNum = nums.length;
		// 遍历0-n-1
		List<List<Integer>> allSubsetList = new ArrayList<>();
		for (int i = 0; i < 1 << binaryNum; i++) {
			// 判断i中包含的1的个数，方法是：判断1与i的逻辑与运算和左移运算
			// PrintMessageUtil.printMsgWithoutNewLine("[");
			List<Integer> subset = new ArrayList<>();
			for (int idxInBinary = 0; idxInBinary < binaryNum; idxInBinary++) {
				if (((1 << idxInBinary) & i) > 0) {
					subset.add(nums[idxInBinary]);// --------只有此处与上面的不同
				}
			}
			PrintMessageUtil.printMsgWithNewLine(subset);
			allSubsetList.add(subset);
			// PrintMessageUtil.printMsgWithNewLine("]");
		}

		return allSubsetList;

	}

	@Test
	public void test() {
		// printAllSubsetByBitwise(3);
		// getAllSubsetByBitwise(3);
		getAllSubsetByBitwise(new int[] { 1, 2, 3 });
	}

}
