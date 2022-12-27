package prg3LV.page1;

public class 기지국_설치 {
    public static void main(String[] args) {
        System.out.println(4%3);
    }
    public int solution(int n, int[] stations, int w) {
        int answer = 0;


        int start = 0;
        double range = w*2+1;
        for (int station : stations) {
            int stat = station - 1;
            int apartmentCount = (stat - w) - start;
            answer += Math.ceil(apartmentCount/ range);
            start = stat + w + 1;
        }
        if (start < n) {
            int remain = n - start;
            answer += Math.ceil(remain/range);
        }
        return answer;
    }
}
