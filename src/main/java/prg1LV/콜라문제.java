package prg1LV;

public class 콜라문제 {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while (n >= a) {
            int coke = (n / a) * b; // 받은 콜라 = 빈 콜라
            answer += coke;
            n = n % a + coke; // 새로 남은 빈병
        }
        return answer;
    }
}

