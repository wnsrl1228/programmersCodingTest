package prg2LV.page5;

import java.util.ArrayList;

public class 우박수열_정적분 {
    public static double[] solution(int k, int[][] ranges) {

        ArrayList<Double> area = new ArrayList<>();

        while (k != 1) {
            double prev = k;
            double sum;
            if (k % 2 == 0) {
                k /= 2;
                sum = (prev - k)/2 + k;
            } else {
                k = k * 3 + 1;
                sum = (k - prev)/2 + prev;
            }
            area.add(sum);
        }
        System.out.println(area);
        double[] answer = new double[ranges.length];
        int index = 0;
        for (int[] range : ranges) {
            int a = range[0];
            int b = area.size() + range[1];

            if (b < a) {
                answer[index++] = -1.0;
            } else {
                double sum = 0;
                for (int i = a; i < b; i++) {
                    sum += area.get(i);
                }
                answer[index++] = sum;
            }
        }
        return answer;
    }
}
