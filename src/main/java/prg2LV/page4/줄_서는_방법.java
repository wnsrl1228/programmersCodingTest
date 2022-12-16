package prg2LV.page4;

import java.util.ArrayList;

public class 줄_서는_방법 {

    public static int[] solution(int n, long k) {
        int[] answer = new int[n];

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= n ; i++) arr.add(i);

        int idx = 0;
        int nn = n-1;
        while (idx != n) {
            // n-1의 경우의 수 구하기
            long a = 1;
            for (int i = 1; i <= nn ; i++)
                a *= i;

            // 자리수 구하기
            for (int i = 1; i <= n; i++) {
                if (k <= a * i ) {
                    if (i != 1) {
                        k -= a * (i-1);
                    }
                    answer[idx++] = arr.remove(i-1);
                    break;
                }
            }
            if (k == 1) break;
            nn--;
        }
        // 남은 애들 추가
        for (Integer integer : arr) {
            answer[idx++] = integer;
        }

        return answer;
    }

    // 완전탐색을 할 경우 시간 부족
//    public static int result = 0;
//    public static boolean[] visited;
//    public static boolean check;
//    private static void makeLine(int n, long k, int[] answer, int num) {
//        if (num == 3) {
//            result++;
//            if (result == k) check = true;
//            return;
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (check) return;
//            if (visited[i] == false) {
//                visited[i] = true;
//                answer[num]=i + 1;
//                makeLine(n, k, answer, num + 1);
//                visited[i] = false;
//            }
//        }
//    }
}
/**
 * 줄 서기
 * 사전순
 */
