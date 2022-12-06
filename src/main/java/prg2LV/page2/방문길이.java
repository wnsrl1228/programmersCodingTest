package prg2LV.page2;

import java.util.HashMap;
import java.util.Map;

public class 방문길이 {

    // 해시 없는 풀이
    public int solution1(String dirs) {
        int answer = 0;
        int x = 5;
        int y = 5;
        int[][][][] map = new int[11][11][11][11];

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for(int i = 0 ; i < dirs.length(); i++){
            char tmp = dirs.charAt(i);
            int dir = -1;
            if(tmp == 'U'){
                dir = 0;
            }
            else if(tmp == 'D'){
                dir = 1;
            }
            else if(tmp == 'R'){
                dir = 2;
            }
            else if(tmp == 'L'){
                dir = 3;
            }

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(0 > nx || nx >= 11 || 0 > ny || ny >= 11) continue;
            if(map[x][y][nx][ny] == 0){
                map[x][y][nx][ny] = 1;
                map[nx][ny][x][y] = 1;
                answer++;
            }
            x = nx;
            y = ny;
        }
        return answer;
    }
    // 해시 사용 풀이
    public static int answer = 0;
    public static Map<String, Boolean> map = new HashMap<>();
    public int solution(String dirs) {
        Map<String, Boolean> map = new HashMap<>();

        int y = 5;
        int x = 5;

        for (char c : dirs.toCharArray()) {
            if (c == 'U') {
                if (y - 1 < 0) continue;
                checkMap(y,x,y-1,x);
                y--;
            } else if (c == 'D') {
                if (y + 1 >= 11) continue;
                checkMap(y,x,y+1,x);
                y++;
            } else if (c == 'L') {
                if (x - 1 < 0) continue;
                checkMap(y,x,y,x-1);
                x--;
            } else if (c == 'R') {
                if (x + 1 >= 11) continue;
                checkMap(y,x,y,x+1);
                x++;
            }
        }

        return answer;
    }

    private void checkMap(int y1, int x1, int y2, int x2) {
        String s1 = y1 + "," + x1 + "," + y2 + "," + x2;
        String s2 = y2 + "," + x2 + "," + y1 + "," + x1;
        if (!map.containsKey(s1) && !map.containsKey(s2)) {
            answer++;
            map.put(s1, true);
            map.put(s2, true);
        }
    }
}
// LLURDDRULLURDDR

// 1 2 2 2
// 2 2 1 2