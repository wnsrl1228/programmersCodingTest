package prg2LV.page4;

import java.util.LinkedList;
import java.util.Queue;

public class 가장_큰_정사각형_찾기 {

    public static int[] xx = {0,-1,-1};
    public static int[] yy = {-1,-1,0};
    // dp 풀이
    public static int solution(int [][]board) {
        if (board.length == 1 || board[0].length == 1) {
            for (int[] ints : board) {
                for (int anInt : ints) {
                    if (anInt == 1) return 1;
                }
            }
            return 0;
        }
        int side = 0;

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] == 0) continue;
                board[i][j] = Math.min(
                        Math.min(board[i + yy[0]][j + xx[0]], board[i + yy[1]][j + xx[1]]),
                        board[i + yy[2]][j + xx[2]]
                ) + 1;

                side = Math.max(side, board[i][j]);

            }
        }
        return side*side;
    }
    // bfs 로는 효율성 실패뜸
//    public static int[] xx = {1,1,0};
//    public static int[] yy = {0,1,1};
//    public static int solution1(int [][]board)
//    {
//        int side = 0;
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                if (side >= board.length - i) {
//                    return side*side;
//                }
//                if (side >= board[i].length - j) {
//                    break;
//                }
//                if (board[i][j] != 0) {
//                    boolean[][] visited = new boolean[board.length][board[0].length];
//                    side = Math.max(side, bfs(board, visited, i, j));
//                }
//            }
//        }
//        return side*side;
//    }
//
//    private static int bfs(int[][] board, boolean[][] visited, int startY, int startX) {
//
//        Queue<Point> queue = new LinkedList<>();
//        queue.add(new Point(startY, startX));
//        visited[startY][startX] = true;
//        int side = 1;
//        int range = 1;
//        while (!queue.isEmpty()) {
//
//            for (int i = 0; i < range; i++) {
//                Point p = queue.poll();
//                int y = p.y;
//                int x = p.x;
//
//                for (int j = 0; j < xx.length; j++) {
//
//                    int nextY = y + yy[j];
//                    int nextX = x + xx[j];
//
//                    if (nextY >= board.length || nextX >= board[0].length) {
//                        return side;
//                    }
//                    if (visited[nextY][nextX]) continue;
//
//                    if (board[nextY][nextX] == 0) {
//                        return side;
//                    }
//                    visited[nextY][nextX] = true;
//                    queue.add(new Point(nextY, nextX));
//                }
//            }
//            range += 2;
//            side++;
//        }
//        return side;
//    }
//    static class Point {
//        int y;
//        int x;
//        public Point(int y, int x) {
//            this.y = y;
//            this.x = x;
//        }
//    }
}
