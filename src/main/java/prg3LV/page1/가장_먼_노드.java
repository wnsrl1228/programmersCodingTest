package prg3LV.page1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 가장_먼_노드 {
    // 전형적인 bfs 문제
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int N;
    public int solution(int n, int[][] edge) {
        N = n;
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] ints : edge) {
            graph.get(ints[0]).add(ints[1]);
            graph.get(ints[1]).add(ints[0]);
        }

        return bfs(1);
    }

    private int bfs(int start) {
        boolean[] visited = new boolean[N+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int len = 1;
        while (!queue.isEmpty()) {
            int count = 0;
            for (int i = 0; i < len; i++) {
                Integer poll = queue.poll();

                for (int node : graph.get(poll)) {
                    if (visited[node]) {
                        count++;
                        visited[node] = true;
                        queue.add(node);
                    }
                }
            }
            len = count;
        }
        return len;
    }
}
