package prg2LV.page2;

import java.util.ArrayList;

public class 일차프렌즈4블록 {
    /**
     *
     * board를 시계방향으로 한번 회전해주면 편함
     *
     * @param m 높이 = board.length
     * @param n 폭 = board[i].length
     */
    public static int[] xx = {0,1,0,1};
    public static int[] yy = {0,0,1,1};
    public static int solution(int m, int n, String[] board) {

        ArrayList<Character>[] block = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            block[i] = new ArrayList<>();
            for (int j = m - 1; j >= 0 ; j--) {
                block[i].add(board[j].charAt(i));
            }
        }
        int answer = 0;
        while (true) {
            boolean[][] visited = new boolean[n][m];
            int point = 0;
            for (int i = 0; i < block.length - 1; i++) {
                for (int j = 0; j < block[i].size() - 1; j++) {
                    point += check(block, visited,i,j, block[i].get(j));
                }
            }
            if (point == 0) break;
            answer += point;
            for (int i = 0; i < block.length; i++) {
                for (int j = block[i].size() -1; j >= 0 ; j--) {
                    if (visited[i][j] == true) {
                        block[i].remove(j);
                    }
                }
            }
            System.out.println(" ==== ");
            for (ArrayList<Character> characters : block) {
                System.out.println("characters = " + characters);
            }
        }
        return answer;
    }

    private static int check(ArrayList<Character>[] block, boolean[][] visited, int y, int x, char c) {
        int point = 0;
        for (int i = 0; i < xx.length; i++) {
            int currentX = x + xx[i];
            int currentY = y + yy[i];
            if (currentY >= block.length) return 0;
            if (currentX >= block[currentY].size()) return 0;
            if (block[currentY].get(currentX) != c) return 0;
            if (visited[currentY][currentX] == false) point++;
        }

        for (int i = 0; i < xx.length; i++) {
            int currentX = x + xx[i];
            int currentY = y + yy[i];
            visited[currentY][currentX] = true;
        }

        return point;
    }


}
/**
 * CCBDE
 * AAADE
 * AAABF
 * CCBBF
 *
 *    DE
 *    DE
 * CCBBF
 * CCBBF 6
 *
 *     E
 *     E
 *    DF
 *    DF 8
 */