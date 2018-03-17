package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import utile.PrintMessageUtil;

public class HeapSort {

	/**
	 * 堆的顺序存储结构特征： <br>
	 * 对于满足：1<=i<=(nums.length-1)/2 的元素<br>
	 * 1、nums[i]的两个子结点分别是nums[2*i]/nums[2*i+1] <br>
	 * 2、堆满足的公式是：nums[i]<=nums[2*i]&&nums[i]<=nums[2*i+1] <br>
	 * 特例：叶子结点一定是堆。<br>
	 * 堆的调整：<br>
	 * 1、基于叶子结点的特征,只对nums.length/2-1~1的结点进行调整(暂时对于下标为零的元素不做讨论)<br>
	 * 使该范围的每个结点满足小于子结点nums[i]<=nums[2*i]&&nums[i]<=nums[2*i+1]
	 */

	public void adjustHeap(List<Integer> heap) {
		int size = heap.size();
		boolean isNeedAdjust = checkHeapSize(size);
		if (isNeedAdjust) {
			for (int i = (heap.size() - 1) / 2; i > 0; i--) {// 注意此处的边界条件
				adjustChildTree(heap, i, heap.size() - 1);
			}
		}

	}

	/**
	 * 校验堆的大小
	 * 
	 * 1、size== 0表示无元素<br>
	 * 2、size==1表示只包含null<br>
	 * 3、size==2表示只有一个根结点，单个结点就是堆，无需调整<br>
	 * 
	 * @param size
	 */
	private boolean checkHeapSize(int size) {
		if (size == 0 || size == 1) {
			PrintMessageUtil.printMsgWithNewLine("请插入元素");
			return false;
		}
		if (size == 2) {
			PrintMessageUtil.printMsgWithNewLine("该堆只包含一个根结点，已经是堆，无需调整");
			return false;
		}
		return true;
	}

	/**
	 * 递推的调整每个子树
	 * 
	 * @param heap
	 * @param idx
	 *            当前元素的下标
	 * @param heapVaildIdx
	 *            堆中可以取到的下标有效值
	 */
	private void adjustChildTree(List<Integer> heap, int idx, int heapVaildIdx) {

		int child;
		// for (; idx <= (heapVaildIdx + 1) / 2;) {
		// 此处不能+1，原因是：堆的有效长度是heap.size()-1,第0位元素，不存元素
		for (; idx <= heapVaildIdx / 2;) {
			child = 2 * idx;
			if (child + 1 <= heapVaildIdx && heap.get(child) < heap.get(child + 1)) {
				child++;
			}
			if (heap.get(idx) < heap.get(child)) {
				swap(heap, idx, child);
				idx = child;// 更新idx, 递推调整其子树
			} else {
				break;
			}
		}

	}

	/**
	 * 交换元素
	 * 
	 * @param heap
	 * @param idx
	 * @param child
	 */
	private void swap(List<Integer> heap, int idx, int child) {

		int tmp = heap.get(idx);
		heap.set(idx, heap.get(child));
		heap.set(child, tmp);
	}

	/**
	 * 删除指定下标为idx元素
	 * 
	 * 将列表中最后一个元素，赋值到指定元素上，然后再调整为堆，这里取最后一个元素的原因是其一定无子结点
	 * 
	 * @param heap
	 * @param idx
	 */
	private void deleteItem(List<Integer> heap, int idx) {

		int size = heap.size();
		if (checkHeapSize(size)) {
			// 赋值
			heap.set(idx, heap.get(heap.size() - 1));
			heap.remove(idx);// 删除最后一个元素
			// 调整该子树为堆
			adjustChildTree(heap, idx - 1, heap.size() - 1);
		}
	}

	/**
	 * 插入到最后位置，调整该结点子树为堆
	 * 
	 * @param heap
	 * @param i
	 */
	private void insertItem(List<Integer> heap, int item) {

		// 插入到最后一个位置，然后调整该结点对应的子树为堆即可
		int size = heap.size();
		if (heap.size() == 0) {
			heap.add(null);
		}
		heap.add(item);
		int root = size / 2;// (size-1+1)/2
		adjustChildTree(heap, root, size);

	}

	/**
	 * 排序算法的实现步骤的含义：<br>
	 * 1、每次的调整可以找到nums[1]位最大元素<br>
	 * 2、交换使得较大的元素，换到最后nums[i]位置，而且i-1使得较大的元素不参与到下次的调整中，不会出现在nums[i-1]
	 * 
	 * @param heap
	 */
	private void sort(List<Integer> heap) {

		int size = heap.size();
		if (checkHeapSize(size)) {
			for (int i = size - 1; i > 0; i--) {
				swap(heap, 1, i);
				adjustChildTree(heap, 1, i - 1);
			}
		}
	}

	@Test
	public void test() {
		List<Integer> heap = new ArrayList<>(Arrays.asList(null, 9, 7, 6, 49, 13, 27, 38));
		adjustHeap(heap);
		PrintMessageUtil.printMsgWithNewLine("调整后的堆：" + heap);

		// 删除堆中指定位置元素
		deleteItem(heap, 3);
		PrintMessageUtil.printMsgWithNewLine("删除元素后的堆：" + heap);
		deleteItem(heap, 3);
		PrintMessageUtil.printMsgWithNewLine("删除元素后的堆：" + heap);
		deleteItem(heap, 2);
		PrintMessageUtil.printMsgWithNewLine("删除元素后的堆：" + heap);

		// 插入一个元素
		insertItem(heap, 27);
		PrintMessageUtil.printMsgWithNewLine("插入元素后的堆：" + heap);

		// 插入一个元素
		insertItem(heap, 7);
		PrintMessageUtil.printMsgWithNewLine("插入元素后的堆：" + heap);

		insertItem(heap, 38);
		PrintMessageUtil.printMsgWithNewLine("插入元素后的堆：" + heap);

		// 排序
		sort(heap);
		PrintMessageUtil.printMsgWithNewLine(heap);
	}

}
