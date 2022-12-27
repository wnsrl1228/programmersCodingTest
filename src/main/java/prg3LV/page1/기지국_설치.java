package prg3LV.page1;

public class 기지국_설치 {

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 0;
        int range = w*2+1;
        for (int station : stations) {
            int width = ((station - 1 - w) - start);
            answer += width % range > 0 ? width / range + 1 : width / range;
            start = station + w;
        }
        int width = n - start;
        answer += width % range > 0 ? width / range + 1 : width / range;
        return answer;
    }
}
