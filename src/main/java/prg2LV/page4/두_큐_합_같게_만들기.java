package prg2LV.page4;

import java.util.LinkedList;
import java.util.Queue;

public class 두_큐_합_같게_만들기 {
    // 투 포인트를 이용하는 풀이
    public int solution1(int[] queue1, int[] queue2) {
        int n = queue1.length;
        int[] queue = new int[n * 2];

        long sum = 0;
        for (int i = 0; i < n; i++) {
            queue[i] = queue1[i];
            sum += queue1[i];
        }
        long sum1 = sum;

        for (int i = 0; i < n; i++) {
            queue[i+n] = queue2[i];
            sum += queue2[i];
        }
        if ( sum % 2 != 0) return -1;
        sum /= 2;
        int left = 0, right = n;
        int count = 0;
        while (left < right && right < queue.length) {
            if (sum1 == sum) {
                return count;
            } else if (sum1 < sum) {
                sum1 += queue[right++];
            } else {
                sum1 -= queue[left++];
            }
            count++;
        }
        return -1;
    }
    // 큐를 이용한 풀이
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0;
        for (int i : queue1) {
            sum1 += i;
            q1.add(i);
        }
        for (int i : queue2) {
            sum2 += i;
            q2.add(i);
        }
        if ( (sum1 + sum2) % 2 != 0) return -1;
        boolean fail = true;

        while (answer <= queue1.length * 3) {
            if (sum1 == sum2) {
                fail =false;
                break;
            } else if (sum1 > sum2) {
                int poll = q1.poll();
                sum1 -= poll;
                sum2 += poll;
                q2.add(poll);
            } else {
                int poll = q2.poll();
                sum2 -= poll;
                sum1 += poll;
                q1.add(poll);
            }
            answer++;
        }
        if (fail) return -1;
        return answer;
    }
}
/**
 * while 문 빠져나오는 조건에 대한 예시
 * [3,3,3,3,3,3,3,3] [3,3,3,3,3,3,45,3]
 * 즉 q1.size 를 q2 로 모두 옮기고
 * q2.size-1 을 q1 으로 모두 옮긴다.
 * q1의 45를 제외한 3을 모두 q2로 옮긴다.
 * 대략 q1.size * 3 일 경우가 최대가 된다.
 */