package prg3LV.page1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 섬_연결하기 {

    // 다른 사람 풀이
    // find union 알고리즘
    public int solution1(int n, int[][] costs) {
        int answer = 0;
        int[] island = new int[n];

        for (int i = 0; i < n; i++) {
            island[i] = i;
        }
        // 최소 간선 순서대로 섬을 붙여준다.
        Arrays.sort(costs, (a,b) -> Integer.compare(a[2], b[2]));
        for (int i = 0; i < costs.length; i++) {

            // 각 섬이 떨어져 있을 경우에만 붙여준다.
            if(find(island, costs[i][0]) != find(island, costs[i][1])) {
                union(island, costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }
        return answer;
    }
    // root node 찾기
    private int find(int[] island, int n) {
        if (island[n] == n) {
            return n;
        }
        return find(island, island[n]);
    }
    // 각 노드의 root node 붙이기
    private void union(int[] island, int x, int y) {
        int a = find(island, x);
        int b = find(island, y);
        island[a] = b;
    }

    // 프림 알고리즘
    static ArrayList<Node>[] graph;
    static int N;
    static boolean[] visited;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        N = n;
        graph = new ArrayList[n];
        for (int[] cost : costs) {
            if (graph[cost[0]] == null)
                graph[cost[0]] = new ArrayList<>();
            if (graph[cost[1]] == null)
                graph[cost[1]] = new ArrayList<>();
            graph[cost[0]].add(new Node(cost[1], cost[2]));
            graph[cost[1]].add(new Node(cost[0], cost[2]));
        }
        visited = new boolean[n];


        // 0 node 추가
        visited[0] = true;
        PriorityQueue<Node> edges = new PriorityQueue<>();
        for (Node node : graph[0])
            edges.add(node);

        int checkedNode = 1;

        while (checkedNode != n) {

            Node node = edges.poll();

            if (!visited[node.id]) {
                answer += node.val;
                visited[node.id] = true;
                checkedNode++;
                for (Node edge : graph[node.id]) {
                    edges.add(edge);
                }
            }
        }
        return answer;
    }
    static class Node implements Comparable<Node>{
        int id;
        int val;

        public Node(int id, int val) {
            this.id = id;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }
}
