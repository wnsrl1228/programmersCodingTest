package prg2LV.page1;

import java.util.Stack;

public class 짝지어제거하기 {
    public static void main(String[] args) {
        solution("baabaa");
    }
    // 최적화
    public static int solution1(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(c);
            } else {
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
        }
        return stack.size() > 0 ? 0 : 1;
    }

    public static int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.add(c);
            } else {
                char tmp = stack.peek();
                if (tmp == c) {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
        }
        if (stack.isEmpty()) {
            return 1;
        }
        return 0;
    }
}
/**
 * 같은 알파벳 2개 붙어있는 걸 제거
 * 문자가 모두 제거되면 1
 * 아닐 경우 0
 */