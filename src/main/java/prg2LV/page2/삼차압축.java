package prg2LV.page2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 삼차압축 {
    public static int[] solution(String msg) {


        Map<String,Integer> map = new HashMap<>();
        for (int i = 65; i <= 90; i++) {
            map.put(String.valueOf((char) i), i-64);
        }

        int index = 0;
        List<Integer> arr = new ArrayList<>();
        while (index < msg.length()) {

            for (int i = index; i < msg.length(); i++) {
                String substring = msg.substring(index, i + 1);
                // 사전에 등록 안 되어있으면, 바로 이전에 등록된 단어의 색인을 저장한다.
                if (!map.containsKey(substring)) {
                    map.put(substring, map.size() + 1);
                    String prev = msg.substring(index, i);
                    index += prev.length();
                    arr.add(map.get(prev));
                    break;
                } else {
                    // 마지막 문자까지 사전에 등록되어 있다면, 그대로 사전에 저장한다.
                    if (i == msg.length() -1) {
                        arr.add(map.get(substring));
                        index += substring.length();
                    }
                }
            }
        }
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
}
