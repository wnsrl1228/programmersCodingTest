package prg2LV.page4;

import java.math.BigInteger;

public class 숫자_카드_나누기 {
    // arrayA의 최대공약수가 arrayB에서 나눠질 경우 arrayA의 모든 약수들도 나누어진다.
    public int solution(int[] arrayA, int[] arrayB) {
        int result1 = getResult(arrayA, arrayB);
        int result2 = getResult(arrayB, arrayA);

        return Math.max(result1, result2);
    }
    public static int getResult(int[] arrayA, int[] arrayB) {
        int gcd = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) {
            gcd = gcd(gcd, arrayA[i]);
        }
        if (gcd == 1) return 0;

        for (int i = 0; i < arrayB.length; i++) {
            if (arrayB[i] % gcd == 0) return 0;
        }
        return gcd;
    }

    public static int gcd(int a, int b) {
        int n = Math.max(a,b);
        int r = Math.min(a,b);

        while (r != 0) {
            int temp = r;
            r = n%r;
            n = temp;
        }
        return n;
    }

}
