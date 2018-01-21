package search;


import org.junit.Test;


/**
 * 折半查找
 *
 * @author BrianCai
 * @version 2018年1月20日
 * @see BinarySearch
 * @since
 */
public class BinarySearch {

    public boolean binarySearch(int[] array, int a) {

        if (array.length == 0) {
            return false;
        }

        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == a) {
                return true;
            }
            else if (array[mid] > a) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return false;
    }

    public boolean binarySearchRecursion(int[] array, int a, int low, int high) {
        if (array.length == 0) {
            return false;
        }

        if (low > high) {
            return false;

        }

        int mid = (low + high) / 2;
        boolean res = false;
        if (array[mid] == a) {
            return true;
        }
        else {
            if (array[mid] > a) {
                high = mid - 1;
                res = binarySearchRecursion(array, a, low, high);
            }
            else {
                low = mid + 1;
                res = binarySearchRecursion(array, a, low, high);

            }
        }
        return res ? true : false;

        // int mid = (low + high) / 2;
        // if (array[mid] == a) {
        // return true;
        // }
        // else if (array[mid] > a) {
        // high = mid - 1;
        // binarySearchRecursion(array, a, low, high);
        // return false;
        // }
        // else {
        // low = mid + 1;
        // binarySearchRecursion(array, a, low, high);
        // return false;
        // }

    }

    @Test
    public void test() {
        int[] array = new int[] {1, 8, 3, 5, 9, 6, 11};
        // int[] array = new int[] {};
        int a = 10;
        System.out.println("the result....." + binarySearch(array, a));
        int high = array.length - 1;
        int low = 0;
        System.out.println("the result....." + binarySearchRecursion(array, a, low, high));
    }
}
