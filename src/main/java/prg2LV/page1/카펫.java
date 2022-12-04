package prg2LV.page1;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int sum = (brown / 2) + 2; // 가로 + 세로
        for (int h = 3; h <= sum/2; h++) {
            int w = sum - h;
            int yellowSize = (w - 2) * (h - 2);
            if (yellow == yellowSize) {
                answer[0] = w;
                answer[1] = h;
            }
        }

        return answer;
    }
}

/**
 * 갈색의 최소 가로 세로는 3
 * 노랑의 넓이 = (갈색의 가로 - 2) * (갈색의 세로 - 2)
 * 가로 >= 세로
 */
