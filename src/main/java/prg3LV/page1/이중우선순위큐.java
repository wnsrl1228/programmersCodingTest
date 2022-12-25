package prg3LV.page1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
    // 테스트 케이스가 부실하다.
    // PriorityQueue의 remove 메서드 사용하면 더 쉽게 풀 수 있다.
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();

        for (String operation : operations) {
            
            if (operation.equals("D -1")) {
                // 최솟값 삭제

                while (!minQueue.isEmpty() && map.get(minQueue.peek()) == 0) {
                    minQueue.poll();
                }
                if (!minQueue.isEmpty()) {
                    int poll = minQueue.poll();
                    map.put(poll, map.get(poll) - 1);
                }

            } else if (operation.equals("D 1")) {
                while (!maxQueue.isEmpty() && map.get(maxQueue.peek()) == 0) {
                    maxQueue.poll();
                }
                if (!maxQueue.isEmpty()) {
                    int poll = maxQueue.poll();
                    map.put(poll, map.get(poll) - 1);
                }
            } else {
                int number = Integer.parseInt(operation.split(" ")[1]);
                minQueue.offer(number);
                maxQueue.offer(number);
                map.put(number, map.getOrDefault(number, 0) + 1);
            }
        }

        while (!minQueue.isEmpty() && map.get(minQueue.peek()) == 0) {
            minQueue.poll();
        }
        while (!maxQueue.isEmpty() && map.get(maxQueue.peek()) == 0) {
            maxQueue.poll();
        }
        if (minQueue.isEmpty()) return new int[]{0,0};

        int[] answer = new int[2];
        answer[0] = maxQueue.poll();
        answer[1] = minQueue.poll();
        return answer;
    }
}
