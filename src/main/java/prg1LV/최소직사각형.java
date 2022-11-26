package prg1LV;

import java.util.Arrays;

public class 최소직사각형 {


    public int solution1(int[][] sizes) {
        int w = 0, h = 0;
        for (int[] size : sizes) {
            w = Math.max(w, Math.max(size[0], size[1]));
            h = Math.max(h, Math.min(size[0], size[1]));
        }
        return w * h;
    }

    // 지갑의 가로 세로 중 큰 값을 모은 big배열과 작은 값을 모은 small 배열을 만들어 준다
    // 각 배열에서 가장 큰 값을 구한다.
    // 비효율적인 방법.
    public int solution(int[][] sizes) {
        int answer = 0;
        int[] big = new int[sizes.length];
        int[] small = new int[sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] > sizes[i][1]) {
                big[i] = sizes[i][0];
                small[i] = sizes[i][1];
            } else {
                small[i] = sizes[i][0];
                big[i] = sizes[i][1];
            }
        }
        Arrays.sort(big);
        Arrays.sort(small);
        for (int i : small) {
            System.out.println("i = " + i);
        }

        return big[sizes.length - 1] * small[sizes.length - 1];
    }
}

