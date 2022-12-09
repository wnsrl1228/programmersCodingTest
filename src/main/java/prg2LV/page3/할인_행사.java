package prg2LV.page3;

import java.util.HashMap;
import java.util.Map;

public class 할인_행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        int totalNumber = 0;
        for (int i : number) {
            totalNumber+=i;
        }

        for (int i = 0; i <= discount.length - totalNumber; i++) {

            // map 초기화
            Map<String, Integer> temp = new HashMap<>();
            for (int j = 0; j < want.length; j++) {
                temp.put(want[j], number[j]);
            }

            // 장바구니 체크
            for (int j = i; j < i + totalNumber; j++) {
                if (temp.containsKey(discount[j]) && temp.get(discount[j]) != 0) {
                    temp.replace(discount[j] , temp.get(discount[j]) - 1);
                }
                System.out.println("temp = " + temp);
            }

            // want에 있는 제품이 전부 포함되었는지 체크
            boolean check = true;
            for (Integer value : temp.values()) {
                if (value != 0) {
                    check = false;
                    break;
                }
            }
            if (check) answer++;
        }

        return answer;
    }
}
/**
 * 본인이 원하는 제품이 할인하는 날짜에 맞춰서 회원가입
 */