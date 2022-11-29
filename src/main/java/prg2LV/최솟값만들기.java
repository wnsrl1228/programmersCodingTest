package prg2LV;

import java.util.Arrays;

public class 최솟값만들기 {
    public static void main(String[] args) {
        int[] a = {1,2 ,5, 3, 5,7, 8, 5, 3};
        sort(a,0, a.length-1);
        for (int i : a) {
            System.out.println("i = " + i);
            
        }
    }
    public int solution(int []A, int []B) {
        int answer = 0;
        sort(A, 0, A.length-1);
        sort(B, 0, B.length-1);
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - 1 - i];
        }

        return answer;
    }

    public static void sort(int[] a, int left,int right) {
        int pl = left;
        int pr = right;
        int x = a[(pl+pr)/2];
        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr) {
                int tmp = a[pl];
                a[pl] = a[pr];
                a[pr] = tmp;
                pl++;
                pr--;
            }
        } while (pl <= pr);

        if (left < pr) sort(a, left, pr);
        if (right > pl) sort(a, pl, right);

    }
}
