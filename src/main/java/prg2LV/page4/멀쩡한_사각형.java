package prg2LV.page4;

import java.math.BigInteger;

// 각각의 경우를 처리하는 방식으로 시도했지만 풀지 못함.
public class 멀쩡한_사각형 {

    // 최대공약수를 이용하는 풀이
    public long solution(int w, int h) {
        int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
        long tile = (((long) w / gcd) + ((long) h / gcd) - 1) * gcd;
        return ((long) w * (long) h) - tile;
    }
}
