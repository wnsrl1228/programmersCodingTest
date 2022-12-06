package prg2LV.page2;


public class 땅따먹기 {
    // dp 문제 , 풀이참고
    int solution(int[][] land) {

        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
            land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
            land[i][2] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][3]);
            land[i][3] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][2]);
        }
        int lastIndex = land.length - 1;
        return Math.max(Math.max(land[lastIndex][0], land[lastIndex][1]), Math.max(land[lastIndex][2], land[lastIndex][3]));
    }
}
/**
 * 1 3 5 5
 * 5 6 7 8
 * 4 3 2 99
 *
 *
 */