package prg2LV.page3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 메뉴_리뉴얼 {

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        ArrayList<String> result = new ArrayList<>();
        for (int co : course) {
            Map<String, Integer> map = new HashMap<>();

            // 모든 경우에 대한 코스를 map 에 추가
            for (String order : orders)
                plusMap(order, co,map, "", 0);

            // 최대 주문 횟수 구하기
            int max = 0;
            for (int count : map.values()) {
                max = Math.max(max, count);
            }
            if (max < 2) continue;

            for (String s : map.keySet()) {
                // 최대 주문 코스일 경우에만 result 에 추가
                if (map.get(s) == max) {
                    result.add(s);
                }
            }
        }
        return result.stream().sorted()
                .toArray(String[]::new);
    }

    // 해당 문자로 count 개수 만큼 만들 수 있는 문자 종류 (순서 중복X)
    private static void plusMap(String order,int count, Map<String, Integer> map, String str, int index) {
        if (str.length() == count) {
            str = Stream.of(str.split(""))
                    .sorted()
                    .collect(Collectors.joining());
            map.put(str, map.getOrDefault(str, 0) + 1);
            return;
        }
        for (int i = index; i < order.length(); i++) {
            if (!str.contains(String.valueOf(order.charAt(i)))) {
                plusMap(order, count,map, str + order.charAt(i), i+1);
            }
        }
    }
}
/**
 * 단품메뉴들을 코스요리 메뉴로 구성
 * 1. 최소 2가지 이상의 단품메뉴로 구성
 * 2. 최소 2명 이상의 손님으로부터 주문된 단품메뉴만 후보로 가능
 * 3. 최대로 주문된 코스요리만 선정
 */