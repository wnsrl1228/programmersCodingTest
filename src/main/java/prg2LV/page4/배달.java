package prg2LV.page4;

import java.util.*;

public class 배달 {
    // 다익스트라 문제 (visited 필요없음) 인접행렬 풀이
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[][] graph = new int[N+1][N+1];
        for (int[] arr : road) {
            graph[arr[0]][arr[1]] = graph[arr[0]][arr[1]] != 0
                    ? Math.min(graph[arr[0]][arr[1]], arr[2])
                    : arr[2];
            graph[arr[1]][arr[0]] = graph[arr[1]][arr[0]] != 0
                    ? Math.min(graph[arr[1]][arr[0]], arr[2])
                    : arr[2];
        }

        int[] minDistance = new int[N+1];
        for (int i = 2; i < minDistance.length; i++) {
            minDistance[i] = Integer.MAX_VALUE;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 1; i < graph[node].length; i++) {
                int num = graph[node][i];

                if (num == 0)
                    continue;

                if (minDistance[node] + num < minDistance[i]) {
                    minDistance[i] = minDistance[node] + num;
                    queue.add(i);
                }
            }
        }

        for (int i = 1; i < minDistance.length; i++) {
            if (minDistance[i] <= K) answer++;
        }

        return answer;
    }
}
/**
 * n개의 마을
 * 마을과 마을을 잇는 도로에 시간값이 붙음 (양방향 가능)
 * 1번마을에서 k 시간 이하로 가능한 마을 개수
 */