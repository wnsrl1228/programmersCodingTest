package prg2LV.page3;

import java.util.ArrayList;
import java.util.List;

public class 삼각_달팽이 {

    // 나머지를 이용해서 좌표이동으로 쉽게 구하는 풀이도 있다.

    // 왼쪽, 아래, 오른쪽 순서로 값을 arr에 넣어줌
    public static int[] solution(int n) {
        List<ArrayList<Integer>> arrs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrs.add(new ArrayList<>());
        }

        int line = n;                      // 모서리 개수 , 왼쪽 변 = n, 아랫 변 = n-2, 오른쪽 변 = n-1
        int lastHeight = n-1;              // 아랫변 위치
        int number = 1;                    // 대입 숫자
        int top = 0, side = 0, bottom = 1; // 가장자리에서 부터 거리
        while (line > 0) {

            // 왼쪽 변
            for (int i = top; i < top + line; i++) {
                arrs.get(i).add(side, number++);
            }
            top += 2;
            line-=2;
            // 아래변
            int tempBottom = bottom;
            for (int i = 0; i < line; i++) {
                arrs.get(lastHeight).add(tempBottom++, number++);
            }
            bottom++;
            lastHeight--;
            line++;
            // 오른쪽 변
            for (int i = top - 1 + line - 1; i >= top - 1; i--) {
                int size = arrs.get(i).size();
                arrs.get(i).add(size - side, number++);
            }
            side++;
            line-=2;
        }
        int[] answer = new int[(n*(n+1))/2];
        int index = 0;
        for (ArrayList<Integer> arr : arrs) {
            for (Integer num : arr) {
                answer[index++] = num;
            }
        }
        
        return answer;
    }
}
