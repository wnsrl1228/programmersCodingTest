package prg2LV;

public class 멀리뛰기 {

    // 처음에 조합 풀이로 접근했지만 숫자가 너무 커져서 실패
    // 피보나치 문제.
    public static long solution(int n) {
        long a1 = 1;
        long a2 = 2;
        if (n==1) return 1;
        if (n==2) return 2;
        for (int i = 3; i <= n; i++) {
            long tmp = a2%1234567;
            a2 = a1 + a2;
            a1 = tmp;
        }
        return a2;
    }

}

/**
 * 1 or 2 칸 멀리 뛰기 가능
 * n칸을 가는 경우의 수 % 1234567
 */
