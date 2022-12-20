package prg2LV.page4;

public class 점_찍기 {
    // x^2 + y^2 = d^2 공식만 알면 풀 수 있다.
    // long 타입 주의, 제곱에 long 타입 걸어주지 않으면 실패뜸
    public long solution1(int k, int d) {
        long answer = 0;
        for (int i = 0; i <= d; i+=k) {
            long y = (long) Math.sqrt((long)d*d - (long)i*i) / k;
            answer += y + 1;
        }
        return answer;
    }

    // 시간초과
    public long solution(int k, int d) {
        long answer = 0;
        int x = 0;
        int len = d;
        do {
            double diff = Math.sqrt(Math.pow(0 - x, 2) + Math.pow(0 - d, 2));
            while (diff > len) {
                d--;
                diff = Math.sqrt(Math.pow(0 - x, 2) + Math.pow(0 - d, 2));
            }
            System.out.println(Math.ceil((d+1) / k));
            answer += Math.ceil((d+1) / k);
            x++;
        } while (d-- > 0);
        return answer;
    }
}
