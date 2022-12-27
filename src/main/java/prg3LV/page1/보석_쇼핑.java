package prg3LV.page1;

import java.util.Arrays;
import java.util.HashSet;

import java.util.HashMap;
import java.util.Map;

public class 보석_쇼핑 {

    // 다른 사람 풀이, 더 깔끔하다.
    public int[] solution1(String[] gems) {
        int kind = new HashSet<>(Arrays.asList(gems)).size();

        int[] answer = new int[2];
        int length = Integer.MAX_VALUE, L = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int R = 0; R < gems.length; R++) {
            map.put(gems[R], map.getOrDefault(gems[R], 0) + 1);

            // L 인덱스의 보석이 2개 이상일 경우
            // index 를 한 칸 이동해도 해당 보석이 포함됨 + 중복 최소화
            while (map.get(gems[L]) > 1) {
                map.put(gems[L], map.get(gems[L]) - 1);
                L++;
            }

            // 종류별로 보석을 다 가졌을 경우 + 갱신해줘야 되는 경우
            if (map.size() == kind && length > (R - L)) {
                length = R - L;
                answer[0] = L + 1;
                answer[1] = R + 1;
            }
        }
        return answer;
    }

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        Map<String, Boolean> map = new HashMap<>();

        // map 에 종류 당 하나씩 담기
        for (String gem : gems) {
            if (map.containsKey(gem)) continue;
            map.put(gem, true);
        }
        int typeCount = map.size();

        int minCount = gems.length; // 모든 종류를 주워 담는 보석 개수
        Map<String, Boolean> temp = new HashMap<>();

        for (int i = 0; i < gems.length; i++) {
            if (temp.containsKey(gems[i])) continue;
            temp.put(gems[i], true);

            // temp 에 모든 종류가 찼다면,
            if (temp.size() == typeCount) {
                int end = i;
                int start = i;
                int size = typeCount;

                Map<String, Boolean> tempMap = new HashMap<>();
                for (String s : map.keySet()) {
                    tempMap.put(s, true);
                }

                // 현재 인덱스부터 역 방향으로 돌면서 모든 종류를 만족하는 인덱스에서 종료한다.
                while (size != 0) {
                    if (tempMap.containsKey(gems[start])) {
                        tempMap.remove(gems[start]);
                        size--;
                    }
                    start--;
                }
                start += 1;
                temp.remove(gems[start]); // 시작 지점에 있는 보석 삭제
                int count = (end - start) + 1; // 싹쓸이 한 보석 개수

                // 종류랑 싹쓸이한 보석 개수가 같을 경우 = 최소의 개수로 싹쓸이 한 경우로 리턴해준다.
                if (count == typeCount) return new int[]{start+1, end+1};

                // 이전에 싹쓸이한 보석 개수보다 적을 경우 갱신해준다.
                if (minCount > count) {
                    minCount = count;
                    answer[0] = start+1;
                    answer[1] = end+1;
                }
            }
        }
        // 모든 보석을 싹쓸해줘야 되는 경우
        if (minCount == gems.length) {
            answer[0] = 1;
            answer[1] = gems.length;
        }

        return answer;
    }

}
