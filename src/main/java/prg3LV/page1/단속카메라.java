package prg3LV.page1;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {
    // 다른 사람 풀이
    public int solution1(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int ans = 0;
        int last_camera = Integer.MIN_VALUE;
        for (int[] a : routes) {
            if (last_camera < a[0]) {
                ++ans;
                last_camera = a[1];
            }
        }
        return ans;
    }
    // 정렬해주면 겹치는 구간을 쉽게 구할 수 있다.
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));

        for (int i = 0; i < routes.length; i++) {
            if (i != routes.length -1 && routes[i][1] < routes[i+1][0]) {
                answer++;
                continue;
            }
            int end = routes[i][1];
            int index = i + 2;
            while (index < routes.length) {
                if (routes[index][0] > end) {
                    break;
                }
                index++;
            }
            answer++;
            i = index-1;

        }
        return answer;
    }
}
