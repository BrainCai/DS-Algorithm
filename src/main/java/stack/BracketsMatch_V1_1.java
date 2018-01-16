package stack;


import java.util.Stack;

import org.junit.Test;


/**
 * 元素进栈出栈的条件是什么？ 在从数组中取出元素时，注意考察是否越界
 *
 * @author caiqiang
 * @version 2018年1月15日
 * @see BracketsMatch_V1_1
 * @since
 */
public class BracketsMatch_V1_1 {

    public boolean match(String barckets) {

        Stack<Character> stack = new Stack<>();
        char[] barcketArray = barckets.toCharArray();
        int count = barcketArray.length - 1;

        for (int i = 0; i < barcketArray.length; i++ ) {
            if (stack.isEmpty() && i <= barcketArray.length - 1) {
                stack.push(barcketArray[i]);
                i = i + 1;
            }
            // if (i <= barcketArray.length - 1) {
            //
            // current = barcketArray[i];
            // }
            // else {
            // return false;
            // }
            // 此步是为了防止数组下标溢出，使用三目表达式，使得代码更加的优雅些
            char current = i <= barcketArray.length - 1 ? barcketArray[i] : ' ';
            char stackTopChar = stack.pop();
            if (matchAnotherBracket(stackTopChar, current)) {
                count-- ;
                if (stack.isEmpty() && count == 0) {
                    return true;
                }
                continue;
            }
            else {
                stack.push(stackTopChar);
                stack.push(current);
            }
            count-- ;

        }
        return false;
    }

    public boolean matchAnotherBracket(char barcket1, char barcket2) {

        if (barcket1 == '(' && barcket2 == ')') {
            return true;
        }
        else if (barcket1 == '{' && barcket2 == '}') {
            return true;
        }
        else if (barcket1 == '[' && barcket2 == ']') {
            return true;
        }

        return false;
    }

    @Test
    public void test() {
        System.out.println(match("{{}{}{}()[]{}]"));
        System.out.println(match("()[[]{}]"));
        System.out.println(match("(()[[]{}]"));

        System.out.println(match("()[[]{}]]"));
    }

    // int i = 0;
    // do {
    // if (i <= barcketArray.length - 2) {
    // stack.push(barcketArray[i]);
    // char current = barcketArray[i];
    // char next = barcketArray[i + 1];
    // if (match(current, next)) {
    // stack.pop();
    // i = i + 1;
    // }
    // }
    // i = i + 1;
    // count-- ;
    // if (count == 0 && stack.isEmpty()) {
    // return true;
    // }
    // }
    // while (count != 0 && !stack.isEmpty());
    // return false;
    // for (int i = 0; i < barcketArray.length - 1; i++ ) {
    // stack.push(barcketArray[i]);
    // char current = barcketArray[i];
    // char next = barcketArray[i + 1];
    // if (match(current, next)) {
    // stack.pop();
    // i = i + 1;
    // }
    // count-- ;
    // // 匹配的结果
    // if (stack.isEmpty() && count == 0) {
    // return true;
    // }
    // }
}
