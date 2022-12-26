package prg3LV.page1;

public class 네트워크 {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[computers.length];

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int i, int[][] computers) {
        visited[i] = true;

        for (int j = 0; j < computers[i].length; j++) {
            if (!visited[j] && computers[i][j] == 1) {
                dfs(j, computers);
            }
        }
    }
}
