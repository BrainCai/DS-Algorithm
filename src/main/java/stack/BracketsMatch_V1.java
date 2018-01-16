package stack;


import java.util.Stack;

import org.junit.Test;


/**
 * @author BrainCai
 * @version 2018年1月15日
 * @see BracketsMatch_V1
 * @since
 */
public class BracketsMatch_V1 {

    public boolean match(String barckets) {

        Stack<Character> stack = new Stack<>();
        char[] barcketArray = barckets.toCharArray();
        int count = barcketArray.length - 1;

        for (int i = 0; i < barcketArray.length; i++ ) {
            if (stack.isEmpty() && i <= barcketArray.length - 1) {
                stack.push(barcketArray[i]);
                i = i + 1;
            }
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

}
