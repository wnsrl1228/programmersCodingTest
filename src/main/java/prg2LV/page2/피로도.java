package prg2LV.page2;

public class 피로도 {
    public static int maxResult = 0;
    public static int count =0;
    public static boolean[] visited;
    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        check(dungeons, k, 0);
        return maxResult;
    }
    public static void check(int[][] dungeons, int currentK, int result) {
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] == false && currentK >= dungeons[i][0]) {
                visited[i] = true;
                check(dungeons, currentK - dungeons[i][1], result+1);
                visited[i] = false;
            }
        }
        maxResult = Math.max(maxResult, result);
    }

//    public static void check(int[][] dungeons, int currentK) {
//
//
//        for (int i = 0; i < dungeons.length; i++) {
//
//            if (visited[i] == false && currentK >= dungeons[i][0]) {
//
//                visited[i] = true;
//                count++;
//                check(dungeons, currentK - dungeons[i][1]);
//                System.out.println("count = " + count);
//                maxResult = Math.max(maxResult, count);
//                count--;
//                visited[i] = false;
//            }
//        }
//    }
}

