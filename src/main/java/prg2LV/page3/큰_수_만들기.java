package prg2LV.page3;

import java.util.Stack;

// 못 품
public class 큰_수_만들기 {

    // 스택을 이용한 풀이
    public String solution1(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
    // 범위 안에 가장 큰 값만 answer 에 추가하는 풀이
    public static String solution(String number, int k) {

        StringBuilder answer = new StringBuilder();

        int len = number.length() - k;
        int start = 0;
        int i = 1;

        while (start < number.length() && answer.length() != len) {
            int leftNum = number.length() - len + i;
            int max = 0;
            for (int j = start; j < leftNum ; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    start = j + 1;
                }
            }
            answer.append(max);
            i++;
        }

        return answer.toString();
    }
}
