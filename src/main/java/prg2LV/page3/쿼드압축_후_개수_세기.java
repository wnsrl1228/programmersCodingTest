package prg2LV.page3;

public class 쿼드압축_후_개수_세기 {

    public int one;
    public int zero;
    // 다른 사람 풀이, 재귀를 이용한 풀이
    public int[] solution1(int[][] arr) {
        press(arr, 0, arr.length, 0, arr.length);
        return new int[]{zero, one};
    }
    private void press(int[][] arr, int xs, int xe, int ys, int ye) {
        int oneCnt = 0;
        int max = (int) Math.pow(xe - xs, 2);

        for (int i = xs; i < xe; i++) {
            for (int j = ys; j < ye; j++) {
                oneCnt += arr[i][j];
            }
        }
        if (oneCnt == 0) zero++;
        else if (oneCnt == max) one++;
        else {
            int xm = (xe - xs) / 2;
            int ym = (ye - ys) / 2;
            press(arr, xs, xm, ys, ym);
            press(arr, xm, xe, ys, ym);
            press(arr, xs, xm, ym, ye);
            press(arr, xm, xe, ym, ye);
        }
    }

    // 반복문을 사용한 풀이
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int len = arr.length;
        int n = len/2;
        if (n==0) {
            answer[arr[0][0]]++;
            return answer;
        }

        boolean[][] visited = new boolean[len][len];

        while (n != 0) {

            int startW = 0, endW = n;
            int startH = 0, endH = n;
            // n의 범위 나눠서 배열 전체를 탐색
            while (endH <= len) {
                int num = arr[startH][startW];
                boolean check = true;

                // 범위 내의 모든 수가 같은지 체크
                for (int i = startH; i < endH; i++) {
                    for (int j = startW; j < endW; j++) {
                        if (arr[i][j] != num || visited[i][j]) {
                            check = false;
                            break;
                        }
                        if (!check) break;
                    }
                }
                // 범위 내의 모든 수가 같을 경우 방문표시
                if (check) {
                    for (int i = startH; i < endH; i++) {
                        for (int j = startW; j < endW; j++) {
                            visited[i][j] = true;
                        }
                    }
                    // 카운팅
                    answer[num]++;
                }
                // 세로로 이동
                if (endW != len) {
                    startW = endW;
                    endW += n;
                } else {
                    // 가로로 이동
                    startW = 0;
                    endW = n;
                    startH += n;
                    endH += n;
                }
            }
            // 범위 축소
            n/=2;
        }
        return answer;
    }
}
