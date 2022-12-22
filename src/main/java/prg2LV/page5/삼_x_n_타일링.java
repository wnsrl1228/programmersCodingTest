package prg2LV.page5;

// 못 품
public class 삼_x_n_타일링 {
    // 규칙을 찾기 어렵다.
    // 홀수 타일의 경우 0
    // 짝수 타일일 경우
    //      1. n-2 타일 * 3
    //      2. 2(n-4) + 2(n-6) + 2(n-8) + ... 2(2) + 2
    //       1번과 2번을 더해주면 딘다.

    public int solution(int n) {

        if (n%2 != 0) return 0;

        int[] dp = new int[n+1];
        int[] xdp = new int[n+1];
        dp[2] = 3;
        dp[4] = 11;
        xdp[2] = 0;
        xdp[4] = 8;
        for (int i = 6; i <= n; i+=2) {
            xdp[i] =xdp[i-4] + dp[i-4]*2;
            System.out.println("xdp[i] = " + xdp[i]);
            dp[i] = dp[i - 2]*3 + xdp[i];

        }

        return dp[n];
    }
}
