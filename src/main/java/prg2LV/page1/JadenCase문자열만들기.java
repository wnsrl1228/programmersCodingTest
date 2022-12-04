package prg2LV.page1;


import java.util.Locale;

public class JadenCase문자열만들기 {

    public static void main(String[] args) {
        String a = "adsfsdfsdf";
        System.out.println("a.toUpperCase() = " + a.toUpperCase());
    }
    //  String으로 해결하는 풀이
    public static String solution1(String s) {
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;
        for (String s1 : sp) {
            answer += flag ? s1.toUpperCase() : s1;
            flag = s1.equals(" ") ? true : false;
        }
        return answer;
    }
    // StringBuffer 사용하는 풀이
    public static String solution(String s) {

        boolean checking = false;
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < s.length(); i++) {

            // 단어체크중인 경우
            if (checking) {
                if (sb.charAt(i) == ' ') {
                    checking = false;
                    continue;
                } else {
                    if (Character.isUpperCase(sb.charAt(i))) {
                        String lower = String.valueOf(sb.charAt(i)).toLowerCase();
                        sb.replace(i, i + 1, lower);
                    }
                }
            } else {
                if (sb.charAt(i) != ' ') {
                    if (Character.isLowerCase(sb.charAt(i))) {
                        String upper = String.valueOf(sb.charAt(i)).toUpperCase();
                        sb.replace(i, i + 1, upper);
                    }
                    checking = true;
                }
            }
        }
        return sb.toString();
    }
}
/**
 * 모든 단어의 첫문자가 대문자
 * 단 첫 문자가 알파벳이 아닐 경우 무시
 */