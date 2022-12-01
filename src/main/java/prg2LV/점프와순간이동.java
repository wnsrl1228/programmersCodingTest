package prg2LV;

public class 점프와순간이동 {
    public int solution(int n) {
        int ans = 1;

        while (n != 1) {
            if (n % 2 != 0) {
                ans++;
                n-=1;
            }
            n/=2;
        }

        return ans;
    }
}
/**
 * 점프 : k칸 앞으로  -> k의 건전지 소비
 * 순간이동 : 현재까지 온 거리 * 2
 * 건전지 최소한으로 사용하여 N 거리 이동하기
 */