package array;


import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * @author BrianCai
 * @version 2017年12月25日
 * @see MoreThanHalfNum_Solution
 * @since
 */
public class MoreThanHalfNum_Solution {
    public int moreThanHalfNum(int[] array) {
        if (array.length <= 0) {
            return 0;
        }
        int pos = array.length / 2;
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < array.length; i++ ) {
            if (!numMap.keySet().contains(array[i])) {
                numMap.put(array[i], 1);
            }
            else {
                numMap.put(array[i], numMap.get(array[i]) + 1);
            }
            if (numMap.get(array[i]) > pos) {
                return array[i];
            }

        }

        return 0;
    }

    @Test
    public void test() {
        int[] array = {1, 1};
        System.out.println(moreThanHalfNum(array));
    }
}
