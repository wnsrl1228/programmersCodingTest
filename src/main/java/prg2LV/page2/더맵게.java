package prg2LV.page2;

import java.util.PriorityQueue;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        int result = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i : scoville) {
            queue.offer(i);
        }

        while (queue.peek() < K) {
            if (queue.size() == 1) {
                return -1;
            }
            int first = queue.poll();
            int second = queue.poll();

            queue.offer(first + second * 2);
            result++;
        }
        return result;
    }
}
