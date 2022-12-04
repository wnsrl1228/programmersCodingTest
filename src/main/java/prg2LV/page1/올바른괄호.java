package prg2LV.page1;

import java.util.Stack;

public class 올바른괄호 {
    boolean solution(String s) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add("(");
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                String pop = stack.pop();
                if (pop.equals(")")) {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
