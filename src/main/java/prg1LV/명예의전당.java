package prg1LV;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class 명예의전당 {

    // 우선순위 큐 사용
    public int[] solution1(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            pq.add(score[i]);
            if (pq.size() > k) {
                pq.poll();
            }
            answer[i] = pq.peek();
        }
        return answer;
    }
    // 링크드리스트 사용
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        int listLen = 1;
        LinkedList<Integer> frameList = new LinkedList<>();
        frameList.add(score[0]);
        answer[0] = score[0];
        for (int i = 1; i < score.length; i++) {
            // 명예의전당에 점수가 더 들어갈 수 있는 경우
            if (listLen < k) {
                listLen++;
                int len = frameList.size();
                sort(score, frameList, i);
            } else {
                // 명예의전당에 점수가 더 들어갈 수 없는 경우
                // 명예의 전당의 최소값보다 큰 경우
                if (score[i] > frameList.get(0)) {
                    frameList.remove(0);
                    sort(score, frameList, i);
                    answer[i] = frameList.get(0);
                }
            }
            answer[i] = frameList.get(0);
        }

        return answer;
    }

    private static void sort(int[] score, LinkedList<Integer> frameList, int i) {
        int len = frameList.size();
        for (int j = 0; j < frameList.size(); j++) {
            if (score[i] <= frameList.get(j)) {
                frameList.add(j, score[i]);
                break;
            }
        }
        if (len == frameList.size()) frameList.add(score[i]);
    }
}
/**
 * 문자 투표수가 상위 k번째 이내이면 목록에 올려줌
 * k일 수 동안 명에의 전당에 올려준 뒤 그 다음날 부터는 k명만 올려줌
 * 매일 최하위 점수를 발표함
 */
