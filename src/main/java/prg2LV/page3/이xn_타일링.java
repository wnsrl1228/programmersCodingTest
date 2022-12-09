package prg2LV.page3;

public class 이xn_타일링 {

    public int solution(int n) {
        int[] a = new int[n+1];
        a[1] = 1;
        a[2] = 2;
        for (int i = 3; i <= n; i++) {
            a[i] = (a[i-2] + a[i-1])%1000000007;
        }
        return a[n];
    }

}
