package prg2LV.page4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 전력망을_둘로_나누기 {
    // 다른 사람 풀이
    // dfs 를 이용하여 매번 노드를 지날때 마다 노드+자식노드 개수를 구할 수 있다.
    // dfs 탐색 한 번에 최소 차를 구할 수 있다.
    int N, min;
    int[][] map;
    int[] vist;
    public int solution1(int n, int[][] wires) {
        N = n;
        min = n;
        map = new int[n+1][n+1];
        vist = new int[n+1];
        for(int[] wire : wires) {
            int a = wire[0], b = wire[1];
            map[a][b] = map[b][a] = 1;
        }
        dfs(1);
        return min;
    }
    int dfs(int n){
        vist[n] = 1;
        int child = 1;
        for (int i = 1; i < N ; i++) {
            if (vist[i] == 0 && map[n][i] == 1) {
                vist[i] = 1;
                child += dfs(i);
            }
        }
        min = Math.min(min, Math.abs(child - (N - child)));
        return child;
    }

    // bfs를 이용한 완전탐색 풀이
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = 100;
        // 그래프 초기화
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        for (int[] wire : wires) {
            // 간선 짤라줌
            graph.get(wire[0]).remove(Integer.valueOf(wire[1]));
            graph.get(wire[1]).remove(Integer.valueOf(wire[0]));

            // 탐색
            visited = new boolean[n+1];
            int val1 = search(wire[0]);
            visited = new boolean[n+1];
            int val2 = search(wire[1]);

            // 탐색 결과 비교
            answer = Math.min(answer, Math.abs(val1 - val2));

            // 짤라준 간선 다시 붙임
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        return answer;
    }
    // bfs
    public int search(int start) {

        int count = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            System.out.println("queue = " + queue);
            int node = queue.poll();

            for (int n : graph.get(node)) {
                if (visited[n] == false) {
                    visited[n] = true;
                    queue.add(n);
                    count++;
                }
            }
        }
        return count;
    }
}
/**
 *
 */
