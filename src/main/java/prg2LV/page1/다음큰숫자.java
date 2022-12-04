package prg2LV.page1;

public class 다음큰숫자 {

    // bitCount 메서드 사용
    public int solution1(int n) {
        int oneCount = Integer.bitCount(n);
        int nextOneCount = -1;
        while (oneCount != nextOneCount) {
            nextOneCount = Integer.bitCount(++n);
        }
        return n;
    }
    // bitCount 모른 상태에서 풀이
    public int solution(int n) {
        String s = Integer.toBinaryString(n);
        int oneCount = s.replace("0", "").length();
        int nextOneCount = -1;
        while (oneCount != nextOneCount) {
            s = Integer.toBinaryString(++n);
            nextOneCount = s.replace("0", "").length();
        }
        return n;
    }
}
