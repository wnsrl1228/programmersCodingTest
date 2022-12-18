package prg2LV.page4;

import java.util.ArrayList;


public class 하노이의_탑 {

    // 다른 사람풀이,
    // 하노이 문제는 나올 때마다 어렵다.
    public static ArrayList<int[]> result = new ArrayList<>();
    public int[][] solution(int n) {

        int[][] answer = new int[result.size()][];

        dfs(n, 1,3, 2);
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    }

    private static void dfs(int n, int start, int to, int mid) {
        if(n == 1){
            result.add(new int[]{start, to});
            return;
        }
        dfs(n-1, start, mid, to);

        result.add(new int[]{start, to});

        dfs(n-1, mid, to, start);
    }
}
