package prg2LV.page3;

import java.util.*;

// 풀이 참고
public class 모음사전 {

    // 완전탐색 풀이
    List<String> list = new ArrayList<>();
    void dfs(String str, int len) {
        if(len > 5) return;
        list.add(str);
        for(int i = 0; i < 5; i++) dfs(str + "AEIOU".charAt(i), len + 1);
    }
    public int solution1(String word) {
        dfs("", 0);
        return list.indexOf(word);
    }


    // 경우의 수를 이용한 풀이
    public int solution(String word) {

        int answer = 0;

        int len = 4;
        for (String s : word.split("")) {
            double sum = 0;
            for (int i = 0; i <= len; i++) {
                sum += Math.pow(5,i);
            }
            answer += sum * "AEIOU".indexOf(s) + 1;
            len--;
        }

        return answer;
    }




}
/**
 *  'A', 'E', 'I', 'O', 'U'
 *  5 이하의 단어
 *  사전순
 *  AAE 보다 AAAE가 사전에서 더 앞에 옴
 */
/**
 *  1 6 31 156 781  (((6+1)*5)+1)*5
 */

