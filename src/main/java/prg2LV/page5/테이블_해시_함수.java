package prg2LV.page5;

import java.util.Arrays;

public class 테이블_해시_함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {

        // 이렇게도 가능. 디폴트가 오름차순이라 가능한 거 같다.
        // Arrays.sort(data,(o1, o2) -> o1[col-1]!=o2[col-1] ?o1[col-1]-o2[col-1] :o2[0]-o1[0]);
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col-1] < o2[col-1]) {
                return -1;
            } else if (o1[col-1] > o2[col-1]) {
                return 1;
            } else {
                if (o1[0] < o2[0]) {
                    return 1;
                } else if (o1[0] > o2[0]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int result = 0;
        for (int i = row_begin-1; i <= row_end-1; i++) {
            int sum = 0;
            for (int num : data[i]) {
                sum += num % (i+1);
            }
            result = result^sum;
        }

        return result;
    }
}
