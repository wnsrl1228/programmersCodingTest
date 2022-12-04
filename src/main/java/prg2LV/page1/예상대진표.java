package prg2LV.page1;

public class 예상대진표 {
    // 개선된 풀이 (접근 방식은 같음)
    public int solution1(int n, int a, int b)
    {
        int answer = 0;

        while (a!=b) {

            a = a/2 + a%2;
            b = b/2 + b%2;
            answer++;
        }
        return answer;
    }
    // 이상한 풀이
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        a = a % 2 != 0 ? a + 1 : a;
        b = b % 2 != 0 ? b + 1 : b;

        int max = Math.max(a,b);
        int min = Math.min(a,b);
        if (a == b) return 1;
        while (true) {
            if (max == 2 || min+1 == max || min==max) {
                break;
            }
            max/=2;
            min/=2;
            max = max % 2 != 0 ? max + 1 : max;
            min = min % 2 != 0 ? min + 1 : min;
            answer++;
        }

        return answer;
    }
}
// 16 /7 14 3 4
/**  4번
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 1 3 5 7 9 11 13 15
 * 1 7 11 13
 * 7 13
 *
 * 8 14
 * 4 8
 * 2 4
 * 1 2
 */
/**
 * 1 16
 * 1 8
 * 1 4
 * 1 2
 */
/**
 * 16 12 16 6 8 3 4
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 1 3 5 7 9 12 13 16
 * 1 5 12 16
 */


