package prg3LV.page1;

import java.util.Arrays;

public class 정수_삼각형 {

    public static int solution(int[][] triangle) {
        int n = triangle.length;

        for (int i = 0; i < triangle.length - 1; i++) {

            for (int j = 0; j < triangle[i+1].length; j++) {
                if (j == 0) {
                    triangle[i + 1][j] += triangle[i][j];
                } else if (j == triangle[i + 1].length - 1) {
                    triangle[i + 1][j] += triangle[i][j-1];
                } else {
                    int max = Math.max(triangle[i + 1][j] + triangle[i][j],
                            triangle[i + 1][j] + triangle[i][j - 1]);
                    triangle[i+1][j] = max;
                }
            }
        }

        Arrays.sort(triangle[n-1]);
        return triangle[n-1][n-1];
    }
}
