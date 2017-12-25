package array;


import org.junit.Test;


/**
 * //在一个二维数组中，每一行都按照从左到右递增的顺序排序， 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author BrianCai
 * @version 2017.12.22日
 * @see Find
 * @since
 */
public class Find {
    public boolean find(int target, int[][] array) {

        if (array.length <= 0) {
            return false;
        }
        for (int i = 0; i < array.length; i++ ) {
            for (int j = 0; j < array[i].length; j++ ) {
                if (array[i][j] == target) {
                    return true;
                }

            }
        }
        return false;

    }

    @Test
    public void test() {
        int[][] array = {{1, 2}, {2, 3}, {3, 4, 5}};
        System.out.println(array.length);
        System.out.println(array[0].length);
        System.out.println(find(3, array));
    }
}
