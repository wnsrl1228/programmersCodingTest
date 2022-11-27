package prg1LV;

import java.util.Stack;

public class 크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                int val = board[i][move - 1];
                if (val != 0) {
                    board[i][move - 1] = 0;
                    if (!stack.empty() && stack.peek() == val) {
                        answer+=2;
                        stack.pop();
                    } else {
                        stack.add(val);
                    }
                    break;
                }
            }
        }

        return answer;
    }
}
