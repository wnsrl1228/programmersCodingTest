package prg2LV.page1;

public class 최댓값과최솟값 {
    public String solution(String s) {
        String[] s1 = s.split(" ");
        int max = Integer.parseInt(s1[0]);
        int min = Integer.parseInt(s1[0]);

        for (int i = 1; i < s1.length; i++) {
            int num = Integer.parseInt(s1[i]);
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        return min+" "+max;
    }
}
