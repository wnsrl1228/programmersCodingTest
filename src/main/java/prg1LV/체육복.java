package prg1LV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 체육복 {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n];

        for (int i : lost) {
            arr[i-1]--;
        }
        for (int i : reserve) {
            arr[i-1]++;
        }

        //1 -1 1 -1 1
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                answer++;
            } else if (arr[i] == 1) {
                if (i-1 >= 0 && arr[i-1] == -1) {
                    arr[i-1] = 0;
                    answer++;
                } else if (i+1 < arr.length && arr[i+1] == -1) {
                    arr[i+1] = 0;
                }
                answer++;
            }
        }
        return answer;
    }
}
/**
 * 바로 앞 혹은 뒤 학생에게 체육복 빌릴 수 있음.
 * 여벌 가져온 사람도 도난 당했을 수 있음 그러면 못 빌려줌
 */

// 1 2 [3] 4 [5 6] 7 [8] 9
