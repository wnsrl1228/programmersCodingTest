package prg1LV;

import java.util.Arrays;
import java.util.Collections;

public class 숫자짝꿍 {
    public static void main(String[] args) {

        solution1("100", "123450");
    }
    // n + n + 9 복잡도
    public static String solution1(String X, String Y) {

        String answer = "";
        int[] countX = new int[10];
        int[] countY = new int[10];

        for (int i = 0; i < X.length(); i++) {
            countX[X.charAt(i)-48]++;
        }
        for (int i = 0; i < Y.length(); i++) {
            countY[Y.charAt(i)-48]++;
        }

        for (int i = 9; i >= 0 ; i--) {
            int min = Math.min(countX[i], countY[i]);

            if (min == 0) {
                continue;
            }
            answer += Integer.toString(i).repeat(min);
        }

        if (answer.length() == 0) return "-1";
        if (answer.charAt(0) == '0') return "0";

        return answer;
    }

    // 해결법 1의 경우 10 * n 복잡도
    // 0~ 9번 까지 for문으로 X와 Y를 동시에 돌면서 각 숫자의 개수를 배열에 담는다.
    // 각 자리수의 개수를 담은 배열 X,Y를 비교하여 작은 수의 개수만큼 숫자를 문자열로 변환해 준다.
    public static String solution(String X, String Y) {
        int lenX = X.length();
        int lenY = Y.length();
        String answer = "";
        if (lenX > lenY) {
            answer = check(X, Y);
        } else {
            answer = check(Y, X);
        }
        return answer;
    }

    public static String check(String big, String small) {
        int[] count1 = new int[10];
        int[] count2 = new int[10];
        String result = "";

        for (int i = 9; i >= 0; i--) {

            for (int j = 0; j < small.length(); j++) {
                if (Character.getNumericValue(big.charAt(j)) == i) {
                    count1[i]++;
                }
                if (Character.getNumericValue(small.charAt(j)) == i) {
                    count2[i]++;
                }
            }
            for (int j = small.length(); j < big.length() ; j++) {
                if (Character.getNumericValue(big.charAt(j)) == i) {
                    count1[i]++;
                }
            }
            int min = Math.min(count1[i], count2[i]);
            if (min == 0) {
                continue;
            }
            result += Integer.toString(i).repeat(min);
        }
        if (result.length() == 0) {
            return "-1";
        }
        if (result.charAt(0) == '0') {
            return "0";
        }
        return result;
    }
}
