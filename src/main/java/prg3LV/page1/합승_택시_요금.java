package prg3LV.page1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// 못 품
public class 합승_택시_요금 {

    /**
     * 고급 그래프 알고리즘 응용 문제
     *
     * s에서 부터 전체 노드에 대한 최단거리를 구한 뒤,
     * s에서 전체 노드까지를 합석해서 가는 경우라 취급하고
     * S에서 n 노드까지의 최단거리 + A에서 n 노드까지의 최단거리 + B에서 n 노드까지의 최단거리
     * 를 구해준 뒤 n 개의 노드들 중에 최솟값을 리턴해주면 된다
     */

    //플로이드 워셜
    public int solution1(int n, int s, int a, int b, int[][] fares) {
        int[][] dist = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (i==j) {
                    dist[i][j] = 0;
                    continue;
                }
                dist[i][j] = 2000000;
            }
        }

        for (int[] fare : fares) {
            dist[fare[0]][fare[1]] = Math.min(dist[fare[0]][fare[1]], fare[2]);
            dist[fare[1]][fare[0]] = Math.min(dist[fare[1]][fare[0]], fare[2]);
        }

        // k 노드를 거쳐서 가는 경우와 기존 비용을 비교해줌
        for (int k = 1; k < n+1; k++) {
            for (int i = 1; i < n+1; i++) {
                for (int j = 1; j < n+1; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < n+1; i++) {
            answer = Math.min(answer, dist[s][i] + dist[a][i] + dist[b][i]);
        }

        return answer;

    }
    // 다익스트라 풀이
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        ArrayList<Node>[] graph = new ArrayList[n+1];

        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] fare : fares) {
            graph[fare[0]].add(new Node(fare[1],fare[2]));
            graph[fare[1]].add(new Node(fare[0],fare[2]));
        }

        int[] startA = new int[n + 1];
        int[] startB = new int[n + 1];
        int[] startS = new int[n + 1];

        Arrays.fill(startA, Integer.MAX_VALUE);
        Arrays.fill(startB, Integer.MAX_VALUE);
        Arrays.fill(startS, Integer.MAX_VALUE);

        dijkstra(a, startA, graph, n);
        dijkstra(b, startB, graph, n);
        dijkstra(s, startS, graph, n);

        for (int i = 1; i < n+1; i++) {
            answer = Math.min(answer, startA[i] + startB[i] + startS[i]);
        }
        return answer;
    }

    public void dijkstra(int start, int[] dist, ArrayList<Node>[] graph, int n) {

        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        boolean[] visited = new boolean[n+1];

        while (!pq.isEmpty()) {

            Node poll = pq.poll();

            if (!visited[poll.id]) {
                visited[poll.id] = true;
            }
            
            for (Node next : graph[poll.id]) {
                if (!visited[next.id] && dist[next.id] > poll.val + next.val) {
                    dist[next.id] = poll.val + next.val;
                    pq.add(new Node(next.id, dist[next.id]));
                }
            }
        }
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
