package prg1LV;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        int[] result = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % one.length]) result[0]++;
            if (answers[i] == two[i % two.length]) result[1]++;
            if (answers[i] == three[i % three.length]) result[2]++;
        }

        List<Integer> arr = new ArrayList<>();
        int max = Math.max(Math.max(result[0], result[1]), result[2]);
        for (int i = 0; i < result.length; i++) {
            if (result[i] == max) arr.add(i + 1);
        }

        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}
