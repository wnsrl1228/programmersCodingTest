package prg2LV.page4;

public class 숫자_블록 {
    // 문제에 오류가 있음.
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end- begin)];
        int index = 0;
        for (long i = begin; i < end; i++) {
            long num = 2;
            int val = 1;
            while (num <= Math.sqrt(i)) {
                if (i % num == 0 && i / num <= 10000000) {
                    val = (int) (i / num);
                    break;
                }
                num++;
            }
            answer[index++] = val;
        }
        return answer;
    }
}
