package prg2LV.page3;

import java.util.ArrayList;
import java.util.List;

public class 수식_최대화 {

    public static void main(String[] args) {
        long a = solution("50*6-3*2");
        System.out.println("a = " + a);
    }

    public static List<Long> result = new ArrayList<>();
    public static long solution(String expression) {
        long answer = 0;
        List<Character> operators = new ArrayList<>();
        List<Long> numbers = new ArrayList<>();

        // 연산자, 피연산자 분리
        String number = "";
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                operators.add(c);
                numbers.add(Long.parseLong(number));
                number="";
            } else {
                number += c;
            }
        }
        numbers.add(Long.parseLong(number));

        // 연산자 타입별 하나씩 추출
        List<Character> opType = new ArrayList<>();
        for (Character op : operators) {
            if (!opType.contains(op)) opType.add(op);
        }

        // 재귀를 통한 완전탐색
        boolean[] visited = new boolean[opType.size()];
        recursion(operators, numbers, opType, visited);

        for (Long aLong : result) {
            answer = Math.max(answer, aLong);
        }
        return answer;
    }

    private static void recursion(List<Character> operators, List<Long> numbers, List<Character> opType, boolean[] visited) {

        if (operators.isEmpty()) {
            result.add(Math.abs(numbers.get(0)));
            return;
        }

        // 연산자 경우의 수
        for (int i = 0; i < opType.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                Character op = opType.get(i);

                List<Character> cloneOperators = new ArrayList<>();
                cloneOperators.addAll(operators);
                List<Long> cloneNumbers = new ArrayList<>();
                cloneNumbers.addAll(numbers);

                // 연산
                calc(op, cloneOperators, cloneNumbers);
                // 다음 연산자 재귀
                recursion(cloneOperators, cloneNumbers, opType, visited);
                
                visited[i] = false;
            }
        }
    }
    private static void calc(Character op, List<Character> cloneOperators, List<Long> cloneNumbers) {
        for (int j = 0; j < cloneOperators.size(); j++) {
            if (op == cloneOperators.get(j)) {
                long val = 0;
                switch (op) {
                    case '-':
                        val = cloneNumbers.get(j) - cloneNumbers.get(j + 1);
                        break;
                    case '+':
                        val = cloneNumbers.get(j) + cloneNumbers.get(j + 1);
                        break;
                    case '*':
                        val = cloneNumbers.get(j) * cloneNumbers.get(j + 1);
                        break;
                }
                cloneNumbers.remove(j);
                cloneNumbers.remove(j);
                cloneNumbers.add(j, val);
                cloneOperators.remove(j);
                j--;
            }
        }
    }
}
/**
 * 숫자 , +, - , *  -> 가장 큰 수
 *  단. 연산자 우선순위를 자체 지정가능 ex) + > * > -
 *  음수라도 절댓값을 씌움
 */


/**
 * 완전탐색
 * 연산자 추출 -> 경우의 수 구함
 * 경수의 수 방법만큼 계산 구함
 */