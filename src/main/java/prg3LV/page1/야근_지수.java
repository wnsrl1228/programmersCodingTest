package prg3LV.page1;

import java.util.Collections;
import java.util.PriorityQueue;

public class 야근_지수 {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            p.offer(work);
        }
        boolean check = false;
        while (n-- > 0) {
            Integer poll = p.poll();
            if (poll == 0) {
                check = true;
                break;
            }
            p.offer(poll-1);
        }
        if (check) return 0;

        for (Integer integer : p) {
            answer += integer*integer;
        }
        return answer;
    }

    private void quickSort(int left, int right, int[] arr) {
        
        int pl = left;
        int pr = right;
        int p = arr[(right+left)/2];
        
        do {
            while (arr[pl] > p) pl++;
            while (arr[pr] < p) pr--;
            if (pl <= pr) {
                int temp = arr[pl];
                arr[pl] = arr[pr];
                arr[pr] = temp;
                pl++; pr--;
            }
        } while (pl <= pr);
        
        if (pl < right) quickSort(pl, right, arr);
        if (pr > left) quickSort(left, pr, arr);
        
    } // [2,1]
}
