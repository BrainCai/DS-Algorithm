package array;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分， 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author BrianCai
 * @version 2017年12月25日
 * @see ReOrderArray
 * @since
 */
public class ReOrderArray {

    public void reOrderArray(int[] array) {
        if (array.length <= 0) {
            return;
        }
        // 奇数
        List<Integer> oddNumList = new ArrayList<>();
        List<Integer> enevNumList = new ArrayList<>();
        for (int i = 0; i < array.length; i++ ) {

            if (array[i] % 2 == 1) {
                oddNumList.add(array[i]);
            }
            else {
                enevNumList.add(array[i]);
            }
        }
        int pos = 0;
        for (Integer integer : oddNumList) {
            array[pos] = integer;
            pos++ ;
        }
        for (Integer integer : enevNumList) {
            array[pos] = integer;
            pos++ ;
        }
        for (int i = 0; i < array.length; i++ ) {
            System.out.println(array[i]);
        }
    }

    @Test
    public void test() {
        int[] array = {1, 2, 2, 3, 3, 4, 5};
        reOrderArray(array);
    }
}
