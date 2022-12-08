package prg2LV.page3;

import java.util.HashSet;
import java.util.Set;

public class 연속부분수열합의개수 {

    // 다른 사람 풀이, 각 요소마다 자신을 제외한 요소들을 차례로 더해 set에 추가해준다.
    public int solution1(int[] elements) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<elements.length; i++) {
            int n = 1;
            int idx = i;
            int sum = 0;
            while(n <= elements.length) {
                sum += elements[idx++];
                set.add(sum);
                if(idx >= elements.length)
                    idx = 0;
                n++;
            }
        }

        return set.size();
    }
    // 하나씩 구하는 방법
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        for (int len = 1; len <= elements.length; len++) {
            for (int i = 0; i < elements.length; i++) {
                int sum = 0;
                int index = i;
                for (int j = 0; j < len; j++) {
                    sum += elements[index%elements.length];
                    index++;
                }
                set.add(sum);
            }
        } // 7 9 1 1 4 , 7+9 ,
        //
        return set.size();
    }
}
