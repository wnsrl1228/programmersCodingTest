package prg3LV.page1;

import java.util.Arrays;

public class 숫자_게임 {
    // 다른 사람 풀이 (a기준으로 푼 풀이)
    public int solution1(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        int j = B.length - 1;
        for (int i = A.length - 1; i >= 0; i--) {
            if(A[i] < B[j]) {
                answer++;
                j--;
            }
        }

        return answer;
    }
    // b기준으로 푼 풀이
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int aIdx = A.length-1;
        for (int i = B.length -1; i >= 0; i--) {
            if (aIdx < 0) return answer;
            if (B[i] > A[aIdx]) {
                answer++;
                aIdx--;
            } else {
                while (aIdx >= 0 && B[i] <= A[aIdx]) {
                    aIdx--;
                }

                if (aIdx < 0) break;
                answer++;
                aIdx--;
            }
        }
        return answer;
    }
}
