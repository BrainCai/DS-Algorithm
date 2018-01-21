package search;


import org.junit.Test;


/**
 * 顺序查找是： 1、可以用于顺序存储结构 2、可以用链式存储结构 实现：最为简单的for循环
 * 
 * @author BrianCai
 * @version 2018年1月20日
 * @see SequentialSearch
 * @since
 */
public class SequentialSearch {

    /**
     * Description:实现最简单的版本，也是在平时应用比较多的一种方式.循环可执行件是：i<=array.length-1
     * 
     * @param array
     * @param a
     * @return boolean
     * @see
     */
    public boolean sequentialSearch(int[] array, int a) {

        for (int i = 0; i < array.length; i++ ) {
            if (a == array[i]) {
                return true;
            }
        }

        return false;
    }

    /**
     * Description:哨兵模式，将比较的项放到了循环条件，若能查找到则会退出循环，不会数组越界。 该模式下，在length>=1000时，时间会节约一半
     * 循环条件：array[i]!=a
     * 
     * @param array
     * @param a
     * @return boolean
     * @see
     */
    public boolean sequentialSearchPlus(int[] array, int a) {

        try {
            for (int i = 0; array[i] != a; i++ );
        }
        catch (Exception e) {
            return false;
        }

        return true;
    }

    @Test
    public void test() {
        // int[] array = new int[] {1, 8, 3, 5, 9, 6, 11};
        int[] array = new int[] {};
        int a = 12;
        System.out.println("the result....." + sequentialSearch(array, a));
        System.out.println("the result....." + sequentialSearchPlus(array, a));
    }
}
