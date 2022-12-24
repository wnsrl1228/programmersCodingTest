package prg2LV.page5;

// 못 품
public class 단체사진_찍기 {
    // 경우의 수를 구해야 되는 문제로 접근하여 풀지 못하였다.
    // 완전탐색인 것을 안다면 쉽게 풀 수 있는 문제이다.
    // dfs 를 통한 완전탐색을 하며 모든 대열을 구하고 조건에 맞는 경우만 찾아주면 된다.
    static char[] friend = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static boolean[] visited = new boolean[8];
    static String[] info;
    static int count;
    public static int solution(int n, String[] data) {
        info = data;
        count = 0;  // 여기서 초기화해줘야 통과 됨.
        dfs("");
        return count;
    }

    public static void dfs(String rank) {
        if (rank.length() == 8) {
            System.out.println("rank = " + rank);
            if (check(rank)) {
                count++;
            }
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(rank + friend[i]);
                visited[i] = false;
            }
        }
    }

    public static boolean check(String rank) {
        for (String s : info) {
            int p1 = rank.indexOf(s.charAt(0));
            int p2 = rank.indexOf(s.charAt(2));
            int dist = Math.abs(p1 - p2) - 1;

            int condNum = Character.getNumericValue(s.charAt(4));
            if (s.charAt(3) == '>') {
                if (dist <= condNum) return false;
            } else if (s.charAt(3) == '<') {
                if (dist >= condNum) return false;
            } else {
                if (dist != condNum) return false;
            }
        }
        return true;
    }


}

