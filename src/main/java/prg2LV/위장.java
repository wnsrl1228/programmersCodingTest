package prg2LV;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class 위장 {
    /**
     * 안 입는 경우를 추가해준다.
     */
    // 풀이 참고
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> total = new HashMap<>();
        for(int i=0; i<clothes.length; i++) {
            total.put(clothes[i][1],total.getOrDefault(clothes[i][1],1)+1);
        }
        Collection<Integer> test = total.values();
        System.out.println("test = " + test);
        answer = test.stream().reduce(1, (a, b) -> a*b) - 1;
        return answer;
    }
}
/**
 * 서로 다른 옷의 조합의 수를 구하시오
 *  - 중복되는 옷은 없다.
 *  - 하루에 최소 하나의 옷은 입는다.
 */
