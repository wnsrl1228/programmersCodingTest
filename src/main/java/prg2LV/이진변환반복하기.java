package prg2LV;

public class 이진변환반복하기 {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while (s.length() > 1) {
            int before = s.length();
            s = s.replace("0", "");
            answer[1]+= before - s.length();
            s = Integer.toBinaryString(s.length());
            answer[0]++;
        }
        return answer;
    }
}
