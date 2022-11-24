package prg1LV;

import java.util.Arrays;

// 과일 장수
public class Fruiterer {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        // 정렬한 뒤에 순서대로 상자에 담으면 된다.
        // (1) 1 2 (2) 2 2 (4) 4 4 (4) 4 4
        for (int i = score.length - m; i >= 0; i=i-m) {
            answer += score[i] * m;
        }

        return answer;
    }
}
/**
 * 상태에 따라 1 ~ k 점 (k점이 최상품)
 * 한 상자에 사과 m 개 씩 담음
 * 상자에 담긴 사과 중 가장 낮은 점수가 p
 * 사과 한 상자 가격 = p * m
 * 최저 사과 점수 * m * 상자 개수 = 최댓값 이 되는 값
 */
// 1 1 2 2 2 2 4 4 4 4 4 4
// 0 1 2 3 4 5 6 7 8 9 10 11