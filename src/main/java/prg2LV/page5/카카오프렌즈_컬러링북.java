package prg2LV.page5;

import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈_컬러링북 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static boolean[][] visited;
    static int M;
    static int N;
    public int[] solution(int m, int n, int[][] picture) {
        // m = y , n = x;
        M = m;
        N = n;
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    int size = bfs(i, j, picture[i][j], picture);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private int bfs(int startY, int startX, int color, int[][] picture) {

        int sizeOfArea = 1;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startY,startX));
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            int y = poll.y;
            int x = poll.x;

            for (int i = 0; i < dx.length; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                if (nextY < 0 || nextY >= M || nextX < 0 || nextX >= N)
                    continue;
                if (visited[nextY][nextX])
                    continue;

                if (picture[nextY][nextX] == color) {
                    visited[nextY][nextX] = true;
                    sizeOfArea++;
                    queue.add(new Point(nextY, nextX));
                }
            }
        }

        return sizeOfArea;
    }
    static class Point {
        int y;
        int x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
