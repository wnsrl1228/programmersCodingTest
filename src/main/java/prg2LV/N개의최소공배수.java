package prg2LV;

import java.util.Arrays;

public class N개의최소공배수 {

    //유클리드 호제법 응용
    public int solution1(int[] arr) {
        int answer = 1;
        for (int i = 0; i < arr.length; i++) {
            int g = gcd(arr[i], answer);
            answer = arr[i] * answer / g; // (a * b) / gcd(a,b)
        }
        return answer;
    }

    // 최대공약수
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    // 내가 푼 풀이
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int max = arr[arr.length - 1];
        int result = max;
        while (true) {
            boolean check = true;
            for (int i = 0; i < arr.length -1; i++) {
                if (result%arr[i] != 0) {
                    check = false;
                    break;
                }
            }
            if (!check) {
                result+=max;
            } else {
                return result;
            }
        }
    }

}

