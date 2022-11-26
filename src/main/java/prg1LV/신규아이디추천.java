package prg1LV;

public class 신규아이디추천 {
    public static void main(String[] args) {
//        solution("...!@BaT#*..y.abcdefghijklm");
        solution("...");
    }
    public static String solution1(String new_id) {
        // 소문자 변환
        new_id = new_id.toLowerCase();
        // 알파벳, 숫자, -_. 제외하고 삭제
        new_id = new_id.replaceAll("[^0-9a-zA-Z-_.]", "");

        // 연속되어 있는 . 을 하나로 변경
        new_id = new_id.replaceAll("[.]{2,}", ".");
        // 첫번째 마지막 . 제거
        new_id = new_id.replaceAll("^[.]|[.]$", "");

        // 빈 문자열일 경우 a 추가
        if (new_id.length() == 0) {
            new_id += "a";
        }
        // 문자열 16이상일 경우 15길이로 잘라줌, 마지막 문자가 . 일 경우 삭제
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("^[.]|[.]$", "");
        }

        // 문자열 길이가 2이하일 경우 마지막 문자로 길이3이 되도록 채워줌
        if (new_id.length() <= 2) {
            char lastStr = new_id.charAt(new_id.length() - 1);
            new_id += String.valueOf(lastStr).repeat(3 - new_id.length());
        }

        return new_id;
    }
    // 정규식을 잘 활용하지 못한 풀이
    public static String solution(String new_id) {
        // 소문자 변환
        new_id = new_id.toLowerCase();
        // 알파벳, 숫자, -_. 제외하고 삭제
        new_id = new_id.replaceAll("[^0-9a-zA-Z-_.]", "");

        // 연속되어 있는 . 을 하나로 변경
        while (true) {
            int len = new_id.length();
            new_id = new_id.replace("..", ".");
            if (len == new_id.length()) {
                break;
            }
        }
        // 첫번째 . 제거
        if (new_id.charAt(0) == '.') {
            new_id = new_id.replaceFirst("\\.", "");
        }
        // 마지막 . 제거
        if (new_id.length() != 0 && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        // 빈 문자열일 경우 a 추가
        if (new_id.length() == 0) {
            new_id += "a";
        }
        // 문자열 16이상일 경우 15길이로 잘라줌, 마지막 문자가 . 일 경우 삭제
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.charAt(new_id.length() - 1) == '.') {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }

        // 문자열 길이가 2이하일 경우 마지막 문자로 길이3이 되도록 채워줌
        if (new_id.length() <= 2) {
            char lastStr = new_id.charAt(new_id.length() - 1);
            new_id += String.valueOf(lastStr).repeat(3 - new_id.length());
        }

        return new_id;
    }
}
/**
 * 규칙에 맞는 아이디로 변환 작업
 * 3~15 , 알파벳 소문자, 숫자, '-', '_', '.'(처음과 끝X, 연속X)
 */