package prg3LV.page1;

public class 최고의_집합 {
    public int[] solution(int n, int s) {
        if (s < n) return new int[]{-1};
        int[] answer = new int[n];

        int a = s / n;
        int r = s % n;

        for(int i = n - 1; i >= 0; i--) {
            answer[i] = r-- > 0 ? a + 1 : a;
        }
        return answer;
    }
}
