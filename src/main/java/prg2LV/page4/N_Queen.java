package prg2LV.page4;

public class N_Queen {
    // 힌트 참고하여 품, 1차원 배열을 사용하면 쉽게 풀 수 있다.
    // 하지만 1차원으로 풀 생각을 하기 힘든 문제이다.
    static int[] board;       // value : row, index : column;
    static boolean[] visited; // row line 존재 여부 ,
    static int N;
    static int result = 0;
    public int solution(int n) {
        board = new int[n];
        visited = new boolean[n];
        N = n;
        recursion(0);
        return result;
    }
    // 반환타입을 void 로 지정한 재귀 (static 변수 사용)
    private void recursion(int col) {
        if (col == N) {
            result++;
            return;
        }
        // 행을 돌면서 조건메 맞으면 퀸을 넣어준다.
        for (int row = 0; row < N; row++) {

            if (visited[row]) continue;

            // 대각선 체크
            boolean check = true;
            for (int i = 0; i < col; i++) {
                if (Math.abs(col - i) == Math.abs(row - board[i])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                board[col] = row;
                visited[row] = true;
                recursion(col+1);
                visited[row] = false;
            }
        }
    }
    // 반환 타입을 int 로 지정한 재귀
    private int recursion1(int col) {
        int sum =0;
        if (col == N) {
            return 1;
        }
        // 행을 돌면서 조건메 맞으면 퀸을 넣어준다.
        for (int row = 0; row < N; row++) {

            if (visited[row]) continue;

            // 대각선 체크
            boolean check = true;
            for (int i = 0; i < col; i++) {
                if (Math.abs(col - i) == Math.abs(row - board[i])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                board[col] = row;
                visited[row] = true;
                sum += recursion1(col+1);
                visited[row] = false;
            }
        }
        return sum;
    }
}
