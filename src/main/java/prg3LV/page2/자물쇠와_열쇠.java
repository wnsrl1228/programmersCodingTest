package prg3LV.page2;

public class 자물쇠와_열쇠 {
    static int M;
    static int N;
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        M = key.length; // 열쇠 크기
        N = lock.length; // 자물쇠 크기 M <= N ,
        int[][] bigKey = new int[N*3][N*3]; // index 범위 벗어나는 것을 막기 위해 크기를 늘려줌

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                bigKey[i+N][j+N] = key[i][j];
            }
        }

        // key 배열에 lock 을 슬라이딩 윈도우 형식으로 이동시키면서 체크해줌
        for (int i = 0; i < 4; i++) {   // 회전 4번
            for (int h = N-(N-1); h <= N+(N-1); h++) {
                for (int w = N-(N-1); w <= N+(N-1); w++) {
                    // 암호가 풀리는지 체크
                    if (check(lock, bigKey, h, w))
                        return true;
                }
            }
            lock = rotation(lock);
        }

        return false;
    }
    // 암호 풀리는지 체크
    private boolean check(int[][] lock, int[][] bigKey, int h, int w) {
        // 비교
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((lock[i][j] ^ bigKey[h+i][w+j]) == 0)
                    return false;
            }
        }
        return true;
    }
    // 회전
    public int[][] rotation(int[][] map) {
        int n = map.length;
        int[][] temp = new int[n][n];

        int y = 0;
        for (int i = 0; i < n; i++) {
            int x = 0;
            for (int j = n-1; j >= 0 ; j--) {
                temp[y][x++] = map[j][i];
            }
            y++;
        }
        return temp;
    }
}
