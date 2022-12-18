package prg2LV.page4;

import java.util.HashMap;
import java.util.Map;

public class 롤케이크_자르기 {
    // 다른 사람 풀이, 배열이용
    public int solution1(int[] topping) {
        int answer = 0;
        int[] left = new int[10001], right = new int[10001];
        int ls =0, rs =0;
        for (int i : topping) right[i]++;
        for (int i : right) rs += i > 0 ? 1 : 0;
        for (int i : topping) {
            right[i]--;
            if (right[i] == 0) rs--;
            if (left[i] == 0) ls++;
            left[i]++;
            if (rs == ls) answer++;
        }
        return answer;
    }

    // map을 이용한 풀이
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        if (topping.length == 1) return answer;
        left.put(topping[0], 1);
        for (int i = 1; i < topping.length ; i++) {
            right.put(topping[i], right.getOrDefault(topping[i], 0) + 1);
        }

        for (int i = 1; i < topping.length; i++) {

            if (left.keySet().size() == right.keySet().size()) {
                answer++;
            }

            right.put(topping[i], right.get(topping[i]) - 1);
            left.put(topping[i], left.getOrDefault(topping[i], 0) + 1);
            // 토핑이 0인 경우 map에서 제거
            if (right.get(topping[i]) == 0) {
                right.remove(topping[i]);
            }

        }

        return answer;
    }
}
