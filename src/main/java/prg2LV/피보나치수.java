package prg2LV;

public class 피보나치수 {

    // 반복문
    public static int solution1(int n) {
        int[] arr = new int[n+1];
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i-1] + arr[i-2])%1234567;
        }
        return arr[n];
    }

    // 재귀
    public static int[] arr;
    public static int solution(int n) {
        arr = new int[n+1];
        return  fin(n);
    }
    public static int fin(int n) {
        if (n == 0 || n == 1) {
            return arr[n] = n;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        return arr[n] = (fin(n-1) + fin(n-2))%1234567;
    }
}
// 0 1 2 3 5 8 13 21 34 55 89 144
// 65