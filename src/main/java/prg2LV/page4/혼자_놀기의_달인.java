package prg2LV.page4;

import java.util.Collections;
import java.util.PriorityQueue;

public class 혼자_놀기의_달인 {
    public int solution(int[] cards) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        boolean[] visited = new boolean[cards.length];
        for (int i = 0; i < cards.length; i++) {

            if (!visited[i]) {
                visited[i] = true;
                pq.add(check(cards[i], visited, cards));
            }
        }
        if (pq.size() < 2) return 0;
        return pq.poll() * pq.poll();
    }

    private int check(int val, boolean[] visited, int[] cards) {
        int count = 1;
        while (true) {
            if (visited[val - 1]) break;
            visited[val-1] = true;
            val = cards[val - 1];
            count++;
        }
        return count;
    }
}
// 배열을 한 바뀌 돌면서 그룹을 찾음
// 그룹 중에 개수가 젤 많은 그룹 2개를 곱해줌