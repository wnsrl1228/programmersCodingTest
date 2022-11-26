package prg1LV;

public class 약수의개수와덧셈 {

    // 제곱수가 존재하면 약수의 개수는 홀수임을 이용
    public int solution1(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right ; i++) {
            if (i % Math.sqrt(i) == 0) {
                answer-=i;
            } else {
                answer+=i;
            }
        }

        return answer;
    }
    // 약수 개수를 구한 뒤 체크하는 풀이
    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right ; i++) {
            if (getDivisorCount(i) % 2 == 0) {
                answer+=i;
            } else {
                answer-=i;
            }
        }

        return answer;
    }

    public static int getDivisorCount(int num) {
        if (num == 1) return 1;
        int count = 2;
        if (Math.sqrt(num) % 1 == 0) {
            count++;
        }

        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                count+=2;
            }
        }
        return count;
    }
}
