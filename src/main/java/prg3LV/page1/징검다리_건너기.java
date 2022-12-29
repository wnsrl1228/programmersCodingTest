package prg3LV.page1;

import java.util.*;

// 못 품
public class 징검다리_건너기 {

    /**
     * 슬라이딩 윈도우 방식처럼 시도했지만 매번 최댓값을 구해야 되는 로직을 추가하여 시간초과로 풀지 못함
     */

    // 슬라이딩 윈도우 알고리즘
    public static int solution1(int[] stones, int k) {

        Deque<Node> deque = new ArrayDeque<>();

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < stones.length; i++) {

            // deque에 있는 가장 큰 값의 인덱스가 범위를 벗어날 경우 삭제,
            if (!deque.isEmpty() && deque.peekFirst().index <=  i - k) {
                deque.pollFirst();
            }

            // 디딤돌 개수가 deque의 디딤돌보다 큰 동안 deque를 삭제
            // deque에는 항상 큰 값이 앞에 있어야 됨.
            while (!deque.isEmpty() && deque.peekLast().val <= stones[i]) {
                deque.pollLast();
            }

            deque.offer(new Node(i, stones[i]));

            // 최초의 k번을 넘고 기존보다 디딤돌 개수가 더 적을 경우 갱신
            if (result >= deque.peekFirst().val && i >= k - 1) {
                result = Math.min(result, deque.peekFirst().val);
            }
        }
        return result;
    }
    static class Node {
        int index;
        int val;

        public Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    // 동작 방식
    /**
     * [2, 4, 5, 2, 3, 1, 4, 2, 5, 1] , k:3
     * i = 0 : deque [2]     result = Integer.MAX_VALUE
     * i = 1 : deque [2, 4]  result = Integer.MAX_VALUE
     * i = 2 : deque [5]     result = min(Integer.MAX_VALUE, 5) // 2와 4는 5보다 작아서 아웃
     * i = 3 : deque [5, 2]  result = min(5, 5)
     * i = 4 : deque [5, 3]  result = min(5, 5)  // 2, 3은 5보다 작아서 아웃
     * i = 5 : deque [3,1]   result = min(5, 3)  // 5의 index 범위초과로  아웃
     * i = 6 : deque [4]     result = min(3, 4)  // 3, 1은 4보다 작아서 아웃
     * i = 7 : deque [4, 2]  result = min(3, 4)
     * i = 8 : deque [5]     result = min(3, 5)  // 4, 2는 5보다 작아서 아웃
     * i = 9 : deque [5, 1]  result = min(3, 5)
     */

    // 이분 탐색
    public int solution(int[] stones, int k) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int stone : stones) {
            max = Math.max(stone, max);
            min = Math.min(stone, min);
        }
        return search(stones, k, min, max);

    }

    private int search(int[] stones, int k, int min, int max) {

        int row = min;
        int high = max;
        int result = Integer.MAX_VALUE;
        while (row <= high) {
            int mid = (row + high) /2;

            // 모두 건너는 경우, mid 를 높여야 됨
            if (cross(stones, k ,mid)) {
                row = mid + 1;
            } else {
                high = mid - 1;
                result = Math.min(result, mid);
            }
        }
        return result;
    }

    private boolean cross(int[] stones, int k, int mid) {

        int cnt = 0;
        for (int stone : stones) {
            if (stone - mid <= 0) {
                cnt++;
            } else {
                cnt = 0;
            }
            if (cnt == k)
                return false;
        }
        return true;
    }
}
