package prg1LV;

public class 삼총사 {
    public int solution(int[] number) {
        int answer = 0;
        int len = number.length;
        for (int i = 0; i < len - 2; i++) {
            int first = number[i];
            for (int j = i+1; j < len - 1; j++) {
                int second = number[j];
                for (int k = j+1; k < len; k++) {
                    int third = number[k];
                    if (first + second + third == 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
