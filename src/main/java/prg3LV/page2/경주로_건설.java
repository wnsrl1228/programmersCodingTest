package prg3LV.page2;

import java.util.LinkedList;
import java.util.Queue;
// 힌트 참고
public class 경주로_건설 {

    // bfs + dp 문제, 3차원 dp
    // 기존 bfs 의 경우 두 방향에서 좌표 x,y 에 도달했을 때 각 방향별로 금액을 비교하여 최소 금액을 x, y에 넣어준다.
    // 하지만 당장의 최소 금액이 추후 커브곡선의 개수에 따라 최소금액이 아니게 될 수 있다.
    // 따라서 3차원 배열에 방향별 최소 금액을 넣어주어 해결한다.
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int[][] statBoard;
//    static boolean[][] visited;
    static int N;
    static int result = 400000;
    static int[][][] dp;
    public int solution(int[][] board) {
        N = board.length;
        dp = new int[N][N][4];
        statBoard = board;
//        visited = new boolean[N][N];
//        visited[0][0] = true;
        bfs(0, 0);
        return result;
    }
    private void bfs(int startY, int startX) {

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startY, startX));

        while (!q.isEmpty()) {
            Point point = q.poll();
            int y = point.y;
            int x = point.x;
            for (int i = 0; i < dx.length; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                // 배열 범위를 벗어나거나 벽인 경우
                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >=N
                    || statBoard[nextY][nextX] == 1)
                    continue;

                // 현재 위치에서의 방향별 금액 중 최소 금액을 구함.
                int minVal = 400000;
                for (int j = 0; j < 4; j++) {
                    if (dp[y][x][j] != 0) {
                        // 직진도로
                        int fee = i == j ? 100 : 600;

                        if (minVal > dp[y][x][j] + fee) {
                            minVal = dp[y][x][j] + fee;
                        }
                    }
                }
                // 0,0 좌표에서 최소금액이 0이므로 따로 처리
                if (minVal == 400000) {
                    minVal = 100;
                }

                // 금액이 다음 좌표값 금액보다 작을 경우 갱신
                if (dp[nextY][nextX][i] == 0 || dp[nextY][nextX][i] > minVal) {
                    dp[nextY][nextX][i] = minVal;
                    q.add(new Point(nextY, nextX));
                }
            }
        }
        // n,n 좌표에서 방향별 최소 금액이 결과값
        for (int i = 0; i < 4; i++) {
            if (dp[N-1][N-1][i] != 0) {
                result = Math.min(result, dp[N-1][N-1][i]);
            }
        }
    }
    static class Point {
        int y;
        int x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    // dfs 시간 초과
//    private void dfs(int y, int x, int fee, int direction) {
//
//
//        if (y == N - 1 && x == N - 1) {
//            result = Math.min(fee, result);
//            return;
//        }
//
//        for (int i = 0; i < dx.length; i++) {
//            int nextY = y + dy[i];
//            int nextX = x + dx[i];
//
//            if (nextY < 0 || nextY >= N || nextX < 0 || nextX >=N)
//                continue;
//            if (visited[nextY][nextX] || statBoard[nextY][nextX] == 1)
//                continue;
//            visited[nextY][nextX] = true;
//            if (direction == i || direction == -1) {
//                dfs(nextY, nextX, fee + 100, i);
//            } else {
//                dfs(nextY, nextX, fee + 600, i);
//            }
//            visited[nextY][nextX] = false;
//        }
//    }
}
