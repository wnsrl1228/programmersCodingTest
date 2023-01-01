package prg3LV.page2;

import java.util.Stack;

public class 가장_긴_팰린드롬 {

    public int solution(String s)
    {
        int answer = 1;

        if (s.length() == 1) return 1;

        for (int i = 1; i < s.length(); i++) {
            for (int j = i-1; j >= 0 ; j--) {
                boolean check = true;

                int idx = 0;
                // 팰린드롬 체크 로직
                for (int k = j; k <= (i+j)/2; k++) {
                    if (s.charAt(k) != s.charAt(i-idx++)) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    answer = Math.max(answer, i-j+1);
                }
            }
        }

        return answer;
    }
}
