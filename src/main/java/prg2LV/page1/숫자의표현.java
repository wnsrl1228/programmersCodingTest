package prg2LV.page1;

public class 숫자의표현 {
    public static void main(String[] args) {
        int solution = solution(3);
        System.out.println("solution = " + solution);
    }
    // 정답은 n의 홀수인 약수 개수와 같다.
    public static int solution(int n) {
        int answer = 1;
        for (int i = 1; i < n/2 + 1; i++) {
            int sum = 0;
            for (int j = i; j <= n/2 + 1 ; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                    break;
                }
                if (sum > n) {
                    break;
                }
            }
        }
        return answer;
    }
}
/**
 * 연속된 자연수들로 n을 표현하는 방법의 수
 */

