package prg2LV;

import java.util.*;
import java.util.stream.Collectors;

public class 튜플 {
    // String 길이로 정렬 가능
    //      (
    //          불가능 한 줄 알고 한 번더 배열로 나눠줬었음
    //          따라서 배열의 길이가 각각 다르게 되어 이중 list를 쓰는 낭비를 범함
    //      )

    // 개선된 풀이
    public int[] solution1(String s) {
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});

        Set<String> set = new HashSet<>();
        int[] answer = new int[arr.length];
        int idx = 0;

        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }

    public int[] solution(String s) {

        String ss = s.substring(1, s.length() - 1); // {} 제거
        
        ss = ss.replaceAll("^[{]|[}]$", ""); // {} 제거
        
        String[] split = ss.split("},\\{"); // },{ 기준으로 나눔
        
        List<Set<Integer>> arrs = new ArrayList<>();

        for (String s1 : split) {
            String[] element = s1.split(",");
            Set<Integer> elementInt = Arrays.asList(element)
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());

            arrs.add(elementInt);
        }
        Collections.sort(arrs, new Comparator<Set<Integer>>() {
            @Override
            public int compare(Set<Integer> o1, Set<Integer> o2) {
                return o1.size() - o2.size();
            }
        });
        System.out.println("arrs = " + arrs);

        int[] answer = new int[arrs.size()];

        for (int i = arrs.size() - 1; i >= 1; i--) {
            arrs.get(i).removeAll(arrs.get(i -1));
            for (Integer integer : arrs.get(i)) {
                answer[i] = integer;
            }
        }
        for (Integer integer : arrs.get(0)) {
            answer[0] = integer;
        }
        
        return answer;
    }
}
