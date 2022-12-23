package prg2LV.page5;

import java.util.ArrayList;

public class 교점에_별_만들기 {

    // 주어진 변수를 그대로 사용하면 못 푸는 문제..
    // line 이 int 로 주어졌지만 모두 long 타입으로 변환해야 된다.
    public static String[] solution(int[][] line) {
        ArrayList<Point> arr = new ArrayList<>();
        for (int i = 0; i < line.length -1; i++) {
            int A = line[i][0];
            int B = line[i][1];
            int E = line[i][2];

            for (int j = i + 1; j < line.length; j++) {
                int C = line[j][0];
                int D = line[j][1];
                int F = line[j][2];
                if ((long)A*(long)D - (long)B*(long)C != 0) {
                    if (((long)B*(long)F - (long)E*(long)D) % ((long)A*(long)D - (long)B*(long)C) == 0
                    && ((long)E*(long)C - (long)A*(long)F) % ((long)A*(long)D - (long)B*(long)C) == 0) {
                        arr.add(new Point(
                                ((long)B*(long)F - (long)E*(long)D) / ((long)A*(long)D - (long)B*(long)C),
                                ((long)E*(long)C - (long)A*(long)F) / ((long)A*(long)D - (long)B*(long)C)));
                    }
                }
            }
        }
        long maxY = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;

        for (Point point : arr) {
            maxY = Math.max(maxY, point.y);
            minY = Math.min(minY, point.y);
            maxX = Math.max(maxX, point.x);
            minX = Math.min(minX, point.x);
        }

        int yLen = (int)(maxY - minY + 1);
        int xLen = (int)(maxX - minX + 1);


        StringBuilder[] sb = new StringBuilder[yLen];

        // init
        for (int i = 0; i < yLen; i++) {
            sb[i] = new StringBuilder(".".repeat(xLen));
        }
        for (Point point : arr) {
            long x = point.x;
            long y = point.y;

            sb[(int)Math.abs(y - maxY)].setCharAt((int)Math.abs(x-minX), '*');
        }

        String[] answer = new String[yLen];

        for (int i = 0; i < yLen; i++) {
            answer[i] = sb[i].toString();
        }

        return answer;
    }

    static class Point {
        long x;
        long y;
        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
