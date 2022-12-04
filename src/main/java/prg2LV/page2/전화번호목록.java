package prg2LV.page2;

import java.util.HashMap;
import java.util.Map;

public class 전화번호목록 {

    // 해시 없는 풀이 (효율은 안 좋음)
    public boolean solution1(String[] phoneBook) {
        for(int i=0; i<phoneBook.length-1; i++) {
            for(int j=i+1; j<phoneBook.length; j++) {
                if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
            }
        }
        return true;
    }
    // 해시 풀이
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();

        for (String s : phone_book) {
            map.put(s, 1);
        }
        for (String s : map.keySet()) {
            int i = 1;
            while (i <= s.length()) {
                String substring = s.substring(0, i++);
                if (map.containsKey(substring)) {
                    if (s != substring){
                        return false;
                    }
                }
            }

        }
        return answer;
    }
}
