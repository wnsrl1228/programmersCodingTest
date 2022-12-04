package prg2LV.page2;

import java.util.ArrayList;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int day = 0;
        int count = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int leftProgress = 100 - progresses[i] - (speeds[i]*day); // 남은 기능

            if (0 < leftProgress) {
                if (count == 0) {
                    count++;
                } else {
                    arr.add(count);
                    count = 1;
                }
                day += leftProgress / speeds[i];
                if (leftProgress % speeds[i] != 0) day++;
            } else {
                count++;
            }
        }
        arr.add(count);
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
}
