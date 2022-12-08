package prg2LV.page3;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {
    public static int minVal;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] xx = {0,1,0,-1};
    public static int[] yy = {1,0,-1,0};
    public static int h;
    public static int w;
    public static int solution(int[][] maps) {

        map = maps;
        h = maps.length;
        w = maps[0].length;
        visited = new boolean[h][w];
        return bfs(0, 0);
    }

    private static int bfs(int startY, int startX) {

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startY, startX));
        int tempCount = 1;

        while (queue.size() != 0) {
            int count = tempCount;
            tempCount = 0;
            minVal++;
            for (int k = 0; k < count; k++) {
                Point poll = queue.poll();
                int y = poll.y;
                int x = poll.x;
                if (visited[y][x] == true) continue;

                for (int i = 0; i < xx.length; i++) {
                    int nextY = y + yy[i];
                    int nextX = x + xx[i];

                    if (nextX < 0 || nextX >= w || nextY < 0 || nextY >= h
                            || map[nextY][nextX] == 0
                            || visited[nextY][nextX]) {
                        continue;
                    }
                    if (nextY == h - 1 && nextX == w - 1) {
                        return minVal + 1;
                    }
                    visited[y][x] = true;
                    tempCount++;
                    queue.add(new Point(nextX,nextY));
                }
            }
        }
        return -1;
    }
}
