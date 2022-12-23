package prg2LV.page5;

import java.util.Collections;
import java.util.PriorityQueue;

public class 디펜스_게임 {
    // 다른 사람 풀이 , 더 깔끔하다
    public int solution1(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int e : enemy) {
            queue.add(e);
            answer++;
            n -= e;
            if (n < 0) {
                if(k==0){
                    return answer-1;
                }
                n = n + queue.poll();
                k--;
            }
        }

        return enemy.length;
    }
    public static int solution(int n, int k, int[] enemy) {
        if (enemy.length <= k) return enemy.length;
        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < enemy.length; i++) {
            queue.offer(enemy[i]);
            if (n < enemy[i]) {

                if (k != 0) {
                    if (!queue.isEmpty()) {
                        n += queue.poll();
                        n -= enemy[i];
                    }
                    k--;
                    count++;
                    continue;
                }
                break;
            }
            n -= enemy[i];
            count++;
        }

        return count;
    }
}
