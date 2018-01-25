package tree.base.non.recursive;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


/**
 * 基于数组实现栈 栈最大的特点是： 在实现数据的存取时的特点，先进后出。 主要实现push,pop方法
 *
 * @author caiqiang
 * @version 2018年1月25日
 * @see ArrayImpStack
 * @since
 */
public class ArrayImpStack {

    static List<Integer> array = new ArrayList<>();

    public ArrayImpStack() {

    }

    public void push(Integer e) {
        System.out.println("push ..." + e);
        array.add(e);
    }

    public Integer pop() {
        int length = array.size();

        if (length <= 0) {
            return null;
        }

        int target = array.get(length - 1);
        System.out.println("pop ... " + target);
        array.set(length - 1, null);
        return target;

    }

    private void printList(ArrayImpStack stack) {
        System.out.println("***********************查看栈中元素********************");
        if (array.size() <= 0) {
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
        printList(stack);
        stack.push(3);
        printList(stack);
        stack.pop();
        printList(stack);
    }

    @Test
    public void test1() {
        ArrayImpStack stack = new ArrayImpStack();
        printList(stack);
        System.out.println("******************push 元素***************************");
        for (int i = 0; i < 10; i++ ) {

            stack.push(i);
        }
        printList(stack);
        System.out.println("******************pop 元素***************************");
        stack.pop();
        printList(stack);
    }
}
