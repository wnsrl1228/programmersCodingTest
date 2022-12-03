package prg2LV;

public class n2배열자르기 {

    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) ((right - left) + 1)];
        int index = 0;

        while (left <= right) {
            int y = (int) (left / n);
            int x = (int) (left % n);

            if ( x <= y ) {
                answer[index++] = y+1;
            } else {
                answer[index++] = x + 1;
            }
            left++;
        }

        return answer;
    }
}
