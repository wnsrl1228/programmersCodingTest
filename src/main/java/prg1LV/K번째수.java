package prg1LV;

import java.util.Arrays;

public class K번째수 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        solution(array, commands);
    }
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];

            int len = end - start + 1;
            int[] arr = new int[len];
            for (int j = 0; j < len; j++) {
                arr[j] = array[j+start-1];
            }
            sort(arr,0,len-1);
            answer[i] = arr[k-1];
        }

        return answer;
    }
    // 퀵 정렬
    public static void sort(int[] a, int left, int right){
        int pl = left;
        int pr = right;
        int x = a[(pl+pr)/2];

        do {
            while (a[pl] < x) pl++; // 1 2 3 4 5
            while (a[pr] > x) pr--;
            if (pl <= pr) {
                int temp = a[pl];
                a[pl] = a[pr];
                a[pr] = temp;
                pl++;
                pr--;
            }
        } while (pl <= pr);

        if (left < pr) sort(a, left, pr);
        if (right > pl) sort(a, pl, right);
    }

}
