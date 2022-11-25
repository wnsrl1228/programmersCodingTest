package prg1LV;

public class 푸트파이터대회 {

    public String solution3(int[] food) {
        String answer = "0";

        for (int i = food.length - 1; i > 0 ; i--) {
            int count = food[i] / 2;
            String str = Integer.toString(i).repeat(count);
            answer = str + answer + str;
        }
        return answer;
    }
    public String solution2(int[] food) {
        String str = "";

        for (int i = 1; i < food.length; i++) {
            int count = food[i] / 2;
            if (count > 0) {
                str += Integer.toString(i).repeat(count);
            }
        }

        StringBuffer sb = new StringBuffer(str);
        String reversedStr = sb.reverse().toString();

        return str + "0" + reversedStr;
    }
    public String solution1(int[] food) {
        String str = "";

        for (int i = 1; i < food.length; i++) {
            int count = food[i] / 2;
            if (food[i] % 2 == 0) {
                str += Integer.toString(i).repeat(count);
            } else {
                if (food[i] - 1 > 1) {
                    str += Integer.toString(i).repeat(count);
                }
            }
        }

        StringBuffer sb = new StringBuffer(str);
        String reversedStr = sb.reverse().toString();

        return str + "0" + reversedStr;
    }
}

/**
 * 1대1 대결
 * 각각 왼쪽 오른쪽 끝에서 시작하여 가운데 물을 먼저 먹는 사람이 승리
 * 칼로리 적은 음식부터 먹도록 배치
 * 각 선수가 먹는 음식은 동일
 * 음식의 배치를 리턴
 */