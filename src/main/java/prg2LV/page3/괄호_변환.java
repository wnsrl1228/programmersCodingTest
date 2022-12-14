package prg2LV.page3;


public class 괄호_변환 {

    // 해당 문제는 문제의 요구사항에 맞게 기능만 구현하면 쉽게 풀 수 있지만
    // 문제를 자세하게 해석하려고 하는 순간 막히게 된다.
    public String solution(String p) {
        return solution1(p);

    }
    public String solution1(String p) {
        
        if (p.length() == 0) {
            return p;
        }
        //u, v 분리
        int idx, count = 0;
        for (idx = 0; idx < p.length(); idx++) {
            char c = p.charAt(idx);
            if (c == '(') count++;
            else if (c == ')') count--;
            if (count == 0) break;
        }

        // u가 올바른 괄호 문자열인지 체크
        String u = p.substring(0, idx + 1);
        String v = p.substring(idx + 1);
        if (isCorrectBracket(u)) {
            return u + solution1(v);
        }

        // 4-1 ~ 4-3
        String result = "(" + solution1(v) + ')';

        // u 맨 앞뒤 문자 제거
        u = u.replaceAll(".$", "")
                .replaceAll("^.", "");

        // u 괄호 방향 뒤집기 !! reverse 는 문자열 자체를 뒤집기 때문에 쓰면 안된다.
        String[] split = u.split("");
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals(")")) split[i] = "(";
            else if (split[i].equals("(")) split[i] = ")";
        }

        return result + String.join("", split);
    }
    private static boolean isCorrectBracket(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') {
                if (count <= 0) return false;
                count--;
            }
        }
        if (count == 0) return true;
        return false;
    }
}