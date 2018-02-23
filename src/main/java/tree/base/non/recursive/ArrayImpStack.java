package tree.base.non.recursive;


import java.util.Stack;

import org.junit.Test;


/**
 * 基于数组实现栈 栈最大的特点是： 在实现数据的存取时的特点，先进后出。 主要实现push,pop方法
 *
 * @author BrianCai
 * @version 2018年1月25日
 * @see ArrayImpStack
 * @since
 */
public class ArrayImpStack {

    /**
     * 维护全局存放数据的数组
     */
    static Integer[] array = new Integer[1000];

    /**
     * 维护数组的全局下标
     */
    static int index = 0;

    public ArrayImpStack() {

    }

    /**
     * Description:push方法
     * 
     * @param e
     *            void
     * @see
     */
    public void push(int e) {

        array[index] = e;
        index++ ;
    }

    /**
     * Description:pop方法
     * 
     * @return Integer
     * @see
     */
    public Integer pop() {

        if (index == 0) {
            return null;
        }

        int target = array[index - 1];
        array[index - 1] = null;
        index-- ;
        return target;
    }

    /**
     * Description:获取栈中的元素个数
     * 
     * @param stack
     * @return int
     * @see
     */
    public int size(ArrayImpStack stack) {
        int count = 0;
        for (Integer integer : array) {
            if (integer != null) {
                count++ ;
            }
        }
        return count;
    }

    /**
     * Description:打印栈中的元素
     * 
     * @param stack
     *            void
     * @see
     */
    private void printArray(ArrayImpStack stack) {
        System.out.println("***********************查看栈中元素********************");
        int size = size(this);
        if (size <= 0) {
            System.out.print("当前栈为空");
        }
        for (Integer integer : array) {
            System.out.print(integer + " ");
        }
        System.out.println("");
    }

    @Test
    public void test() {
        ArrayImpStack stack = new ArrayImpStack();
        printArray(stack);
        stack.push(3);
        printArray(stack);
        stack.pop();
        printArray(stack);
    }

    @Test
    public void test1() {
        Stack<Integer> tmp = new Stack<>();
        tmp.push(1);
        tmp.push(2);
        tmp.push(3);
        for (Integer e : tmp)
            System.out.println(e);
    }

}
