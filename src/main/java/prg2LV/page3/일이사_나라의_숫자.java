package prg2LV.page3;

public class 일이사_나라의_숫자 {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder("");
        int[] a = {4,1,2};
        while (n > 0) {
            int r = n % 3;
            if (r == 0) {
                n = n / 3 - 1;
            } else {
                n = n / 3;
            }
            answer.insert(0, a[r]);
        }
        return answer.toString();
    }
}
