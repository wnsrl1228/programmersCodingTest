package prg2LV.page4;

public class 거리두기_확인하기 {


    /**
     * 다른 사람 풀이
     * https://programmers.co.kr/learn/courses/30/lessons/81302
     * 좌표값이 P와 O일 때 주변 P의 개수를 따지는 방법
     *
     */

    // 모든 좌표를 체크해 주는 풀이.
    public static int[] xx = {0, 1, 0, -1, 1, 1, -1, -1};
    public static int[] yy = {-1, 0, 1, 0, -1, 1, 1, -1};
    public static int[] xxx = {0, 1, 0, -1, 0};
    public static int[] yyy = {-1, 0, 1, 0, -1};
    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int idx = 0;

        for (String[] p : places) {
            
            char[][] place = new char[p.length][p[0].length()];
            for (int i = 0; i < p.length; i++) {
                place[i] = p[i].toCharArray();
            }

            // 테이블 검사
            boolean condition = true;
            for (int i = 0; i < place.length; i++) {

                for (int j = 0; j < place[i].length; j++) {

                    if (place[i][j] == 'P') {
                        if (check(place, i, j) == false) {
                            condition = false;
                            break;
                        }
                    }
                }
                if (!condition) break;
            }
            if (condition) answer[idx] = 1;

            idx++;
        }
        return answer;
    }

    private static boolean check(char[][] place, int y, int x) {

        int n = xx.length - 4;
        for (int i = 0; i < n; i++) {
            int nextY = y + yy[i];
            int nextX = x + xx[i];

            if (!checkRange(place, nextY, nextX)) continue;

            if (place[nextY][nextX] == 'P') {
                return false;
            } else if (place[nextY][nextX] == 'O') {
                int nextYY = nextY + yy[i];
                int nextXX = nextX + xx[i];
                if (checkRange(place, nextYY, nextXX)) {
                    if (place[nextYY][nextXX] == 'P')
                        return false;
                }
            }
        }
        int right= 0;
        int left = 1;
        for (int i = n; i < xx.length; i++) {
            int nextY = y + yy[i];
            int nextX = x + xx[i];

            if (checkRange(place, nextY, nextX)) {
                if (place[nextY][nextX] == 'P') {
                    for (int j = right; j <= left; j++) {
                        int nextYY = y + yyy[j];
                        int nextXX = x + xxx[j];
                        if (checkRange(place, nextYY, nextXX)) {
                            if (place[nextYY][nextXX] != 'X')
                                return false;
                        }
                    }
                }
            }
            right++;
            left++;
        }

        return true;
    }

    private static boolean checkRange(char[][] place, int y, int x) {
        return  y < 0 || y >= place.length || x < 0 || x >= place[0].length;
    }

}
/**
 * - 대기실 5개 5X5 크기
 * - 응시자는 거리 2 초과로 떨어져 있어야 됨.
 *  - 단. 파티션으로 가려져 있을 경우 2이하여도 가능
 * 응시자 P
 * 빈 테이블 O
 * 파티션(벽) X
 *
 * return 1 or 0
 */

/**
 * 
 */