package prg3LV.page1;


public class 등굣길 {
    // dp 문제, 좌표의 위, 왼쪽 값들을 더해나가면 된다.
    static int[] dx = {1,0};
    static int[] dy = {0,1};
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        for (int[] puddle : puddles) {
            map[puddle[1]-1][puddle[0]-1] = -1;
        }

        for (int i = 0; i < n; i++) {
            if (map[i][0] == -1)
                break;
            map[i][0] = 1;
        }

        for (int i = 0; i < m; i++) {
            if (map[0][i] == -1)
                break;
            map[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (map[i][j] != -1) {
                    int up = map[i][j-1] == -1 ? 0 : map[i][j-1];
                    int left = map[i-1][j] == -1 ? 0 : map[i-1][j];
                    map[i][j] = (up + left)%1000000007;
                }
            }
        }
        return map[n-1][m-1];
    }

}
