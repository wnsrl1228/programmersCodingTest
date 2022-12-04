package prg2LV.page2;

public class 삼차n진수게임 {
    public static void main(String[] args) {
        String num = getNum(10, 16);
        System.out.println("num = " + num);
        

    }
    // 진법 변환 메서드 사용
    public String solution1(int n, int t, int m, int p) {
        String answer = "";

        int startNum = 0;

        String targetString = "";
        String retString = "";

        // 구해야 될 숫자의 최대
        while (targetString.length() < m * t) {
            targetString += Integer.toString(startNum++, n); // 진법 변환 메서드
        }

        for (int i=0; i<t; i++) {
            retString += targetString.charAt(p - 1 + i * m);
        }

        answer = retString.toUpperCase();


        return answer;
    }
    // 진법 변환 메서드 미사용
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int order = 1;
        int i = 1;
        while (answer.length() < t) {
            String num = getNum(i - 1, n);
            for (char c : num.toCharArray()) {
                if ((order-p)%m == 0) {
                    answer += c;
                    if (answer.length() == t) return answer;
                }
                order++;
            }
            i++;
        }
        return answer;
    }

    // n을 num진수로 변환
    private static String getNum(int n, int num) {
        if (n==0) return "0";
        String result = "";
        while (n != 0 ) {
            int remainder = n % num;
            n = n / num;
            if (remainder >=10) {
                result = (char) (remainder + 55) + result;
            } else {
                result = remainder + result;
            }
        }
        return result;
    }
}
/**
 * 1 2 3 ~ 9 1 0 1 2 1 3
 */