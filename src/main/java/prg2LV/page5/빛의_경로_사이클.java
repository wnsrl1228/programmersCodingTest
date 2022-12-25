package prg2LV.page5;

import java.util.ArrayList;


public class 빛의_경로_사이클 {

    // 결국에는 사이클이 생기기에 dfs 탐색을 해주면 된다.
    // 이때 들어오는 방향과 나가는 방향을 제대로 체크해줘야 된다.
    // 재귀로 풀면 StackOverFlow 에러가 발생하므로 while 문으로 바꿔주었다.
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[] move = {0,1,2,3}; // "up", "down", "left", "right"
    static String[] statGrid;
    static int row;
    static int col;
    static int count;
    static ArrayList<Boolean>[][] visited;
    public static int[] solution(String[] grid) {
        statGrid = grid;
        row = grid.length;
        col = grid[0].length();
        visited = new ArrayList[row][col];

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ArrayList<Boolean> arr =new ArrayList<>();
                arr.add(false);
                arr.add(false);
                arr.add(false);
                arr.add(false);
                visited[i][j] = arr;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < move.length; k++) {
                    if (!visited[i][j].get(move[k])) {
                        count = 0;
                        dfs(i, j, move[k]);
                        result.add(count);
                    }
                }
            }
        }
        int[] ints = result.stream().sorted().mapToInt(Integer::intValue).toArray();
        return ints;
    }

    private static void dfs(int y, int x, int prevMove) {

        while (true) {
            visited[y][x].set(prevMove, true);
            count++;

            int nextY = (row + y + dy[prevMove]) % row;
            int nextX = (col + x + dx[prevMove]) % col;

            char dire = statGrid[nextY].charAt(nextX);

            if (dire == 'S') {
                if (visited[nextY][nextX].get(prevMove)) return;
            } else if (dire == 'R') {
                if (prevMove == 0) {
                    // 밑에서 위로 화살표가 올 경우 오른쪽으로 이동
                    if (visited[nextY][nextX].get(3)) return;
                    prevMove = 3;
                } else if (prevMove == 1) {
                    // 위에서 아래로 화살표가 올 경우 왼쪽으로 이동
                    if (visited[nextY][nextX].get(2)) return;
                    prevMove = 2;
                } else if (prevMove == 2) {
                    // 오른쪽에서 왼쪽으로 화살표가 올 경우 위쪽으로 이동
                    if (visited[nextY][nextX].get(0)) return;
                    prevMove = 0;
                } else if (prevMove == 3) {
                    // 왼쪽에서 오른쪽으로 화살표가 올 경우 아래쪽으로 이동
                    if (visited[nextY][nextX].get(1)) return;
                    prevMove = 1;
                }
            } else if (dire == 'L') {
                if (prevMove == 0) {
                    if (visited[nextY][nextX].get(2)) return;
                    prevMove = 2;
                } else if (prevMove == 1) {
                    if (visited[nextY][nextX].get(3)) return;
                    prevMove = 3;
                } else if (prevMove == 2) {
                    if (visited[nextY][nextX].get(1)) return;
                    prevMove = 1;
                } else if (prevMove == 3) {
                    if (visited[nextY][nextX].get(0)) return;
                    prevMove = 0;
                }
            }
            y = nextY;
            x = nextX;
        }
    }


}
