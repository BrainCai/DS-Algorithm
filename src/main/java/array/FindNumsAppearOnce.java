package array;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;


/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * @author caiqiang
 * @version 2017年12月25日
 * @see FindNumsAppearOnce
 * @since
 */
public class FindNumsAppearOnce {
    public void findNumsAppearOnce(int[] array, int num1[], int num2[]) {

        if (array.length <= 0) {
            return;
        }
        num1[0] = num2[0] = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++ ) {
            if (!map.keySet().contains(array[i])) {
                map.put(array[i], 1);
            }
            else {
                map.put(array[i], 2);
            }
        }
        Set<Integer> key = map.keySet();
        for (Integer integer : key) {
            if (map.get(integer) == 1) {
                if (num1[0] == 0) {
                    num1[0] = integer;
                }
                else {
                    num2[0] = integer;
                }
            }

        }
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }

    @Test
    public void test() {
        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        findNumsAppearOnce(array, num1, num2);
    }
}
