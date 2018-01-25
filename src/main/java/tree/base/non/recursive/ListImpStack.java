package tree.base.non.recursive;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


/**
 * 基于ArrayList实现栈 栈最大的特点是： 在实现数据的存取时的特点，先进后出。 主要实现push,pop方法
 *
 * @author BrianCai
 * @version 2018年1月25日
 * @see ListImpStack
 * @since
 */
public class ListImpStack {

    /**
     * 维护存放数据的容器
     */
    static List<Integer> list = new ArrayList<>();

    public ListImpStack() {

    }

    /**
     * Description: push方法
     * 
     * @param e
     *            void
     * @see
     */
    public void push(Integer e) {
        System.out.println("push ..." + e);
        list.add(e);
    }

    /**
     * Description:pop方法
     * 
     * @return Integer
     * @see
     */
    public Integer pop() {
        int length = list.size();

        if (length <= 0) {
            return null;
        }

        int target = list.get(length - 1);
        System.out.println("pop ... " + target);
        list.set(length - 1, null);
        return target;

    }

    /**
     * Description: 打印栈中元素
     * 
     * @param stack
     *            void
     * @see
     */
    private void printList(ListImpStack stack) {
        System.out.println("***********************查看栈中元素********************");
        if (list.size() <= 0) {
            System.out.print("当前栈为空");
        }
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println("");
    }

    @Test
    public void test() {
        ListImpStack stack = new ListImpStack();
        printList(stack);
        stack.push(3);
        printList(stack);
        stack.pop();
        printList(stack);
    }

    @Test
    public void test1() {
        ListImpStack stack = new ListImpStack();
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
