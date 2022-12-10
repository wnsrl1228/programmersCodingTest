package prg2LV.page3;


import java.util.Arrays;
import java.util.Comparator;

public class 가장_큰_수 {
    // 다른 사람 풀이 참고
    public String solution1(int[] numbers) {
        String answer = "";

        String[] numStr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numStr[i] = String.valueOf(numbers[i]);
        }
        // 문자열 정렬의 경우 같은 문자열로 되어있을 경우 문자열 길이를 우선시함
        // 따라서 직접 문자열을 더해서 비교해줌
        Arrays.sort(numStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        if (numStr[0].equals("0")) return "0";
        for (String s : numStr) {
            answer += s;
        }

        return answer;
    }
    // 퀵 정렬 , 정렬에 필요한 문자열 비교 직접 구현
    public String solution(int[] numbers) {
        String answer = "";

        String[] numStr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numStr[i] = String.valueOf(numbers[i]);
        }

        quickSort(numStr, 0, numStr.length -1);

        if (numStr[0].equals("0")) return "0";

        for (String s : numStr) {
            answer += s;
        }

        return answer;
    }

    private void quickSort(String[] numStr, int left, int right) {
        int pl = left;
        int pr = right;
        String x = numStr[(pl+pr)/2];

        do {
            while (compare(numStr[pl], x) < 0) pl++;
            while (compare(numStr[pr], x) > 0) pr--;
            if (pl <= pr) {
                String temp = numStr[pr];
                numStr[pr] = numStr[pl];
                numStr[pl] = temp;
                pl++;
                pr--;
            }
        } while (pl <= pr);

        if (left < pr) quickSort(numStr, left, pr);
        if (right > pl) quickSort(numStr, pl, right);
    }

    // a < b 1
    // a == b 0
    // a > b -1
    private short compare(String a, String b) {
        int i = 0;
        int j = 0;
        if (a.equals(b)) return 0;
        // a와 b 중 len이 작은 변수의 최대 길이 까지 비교
        while (i < Math.min(a.length(), b.length())) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else if (a.charAt(i) < b.charAt(j)) {
                return 1;
            }
            else if (a.charAt(i) > b.charAt(j)) {
                return -1;
            }
        }

        // a의 len이 더 짧을 경우 b의 나머지 비교
        if (i == a.length()) {
            char first = a.charAt(0);
            char ac = a.charAt(--i);
            for (int k = j; k < b.length(); k++) {
                char bc = b.charAt(k);
                if (bc > first) return 1;
                if (bc < first) return -1;
            }
            // b의 나머지 문자가 a의 첫번째 index랑 같은 경우
            if (first < ac) return 1;
            if (first > ac) return -1;

        } else if (j == b.length()) {
            char first = b.charAt(0);
            char bc = b.charAt(--j);

            for (int k = i; k < a.length(); k++) {
                char ac = a.charAt(k);
                if (ac > first) return -1;
                if (ac < first) return 1;
            }
            if (first < bc) return -1;
            if (first > bc) return 1;
        }
        return 0;
    }

}

/**
 * 3 -1 0 01 412 485
 */