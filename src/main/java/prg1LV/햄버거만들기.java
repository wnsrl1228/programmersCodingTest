package prg1LV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 힌트 참고함
public class 햄버거만들기 {
    public static void main(String[] args) {
        int[] a= {1,2,3,1,1,2,3,1,3,1,3,1};
        solution1(a);

    }
    // temp 활용 - 배열 사용
    public static int solution2(int[] ingredient) {

        int answer = 0;
        int[] stack = new int[ingredient.length];
        int index = 0;
        for (int val : ingredient) {
            stack[index++] = val;
            if (index >= 4 && stack[index - 1] == 1 &&
                    stack[index - 2] == 3 &&
                    stack[index - 3] == 2 &&
                    stack[index - 4] == 1) {
                answer++;
                index-=4;
            }
        }

        return answer;
    }
    // temp 활용 - list 사용
    public static int solution1(int[] ingredient) {

        int answer = 0;
        List<Integer> temp = new ArrayList<>();

        for (int val : ingredient) {
            temp.add(val);

            if (temp.size() >= 4) {
                int size = temp.size();
                if (temp.get(size - 1) == 1 && temp.get(size - 2) == 3 && temp.get(size - 3) == 2 && temp.get(size - 4) == 1) {
                    answer++;
                    for (int i = 0; i < 4; i++) {
                        temp.remove(temp.size() - 1);
                    }
                }
            }
        }

        return answer;
    }
    // 시간 초과
    public static int solution(int[] ingredient) {
        int answer = 0;
        String str = Arrays.toString(ingredient).replaceAll("[^0-9]","");

        do {
            String replace = str.replaceFirst("1231", "");
            System.out.println("replace = " + replace);
            if (str.equals(replace)) {
                break;
            }
            str = replace;
            answer++;
        } while (true);

        System.out.println("answer = " + answer);
        return answer;
    }
}
/**
 * 빵 - 야채 - 고기 - 빵
 * 재료가 주어질 경우 위의 순서대로 햄버거 몇 개 생기는 지 구해라
 */

