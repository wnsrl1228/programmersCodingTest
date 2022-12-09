package prg2LV.page3;


import java.util.*;
import java.util.stream.Collectors;


public class 귤_고르기 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : tangerine) {
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        List<Integer> collect = map.values()
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        int sum = 0;
        for (Integer i : collect) {
            answer++;
            if (sum + i >= k) break;
            sum += i;
        }
        return answer;
    }

}
