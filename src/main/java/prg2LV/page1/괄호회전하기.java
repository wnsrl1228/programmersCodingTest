package prg2LV.page1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class 괄호회전하기 {

    public int solution(String s) {
        int answer = 0;

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            deque.add(c);
        }

        for (int i = 0; i < s.length(); i++) {
            if(check(deque)) {
                answer++;
            }
            Character c = deque.pollFirst();
            deque.add(c);
        }
        return answer;
    }
    public boolean check(Deque<Character> deque) {
        Stack<Character> stack = new Stack<>();

        for (char c : deque) {
            if (c == '(' || c == '{' || c =='[') {
                stack.add(c);
            } else {

                if (stack.isEmpty()) return false;
                char peek = stack.peek();

                if ((c == ')' && peek == '(') ||
                        (c =='}' && peek == '{') ||
                        (c ==']' && peek == '[')) {
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
