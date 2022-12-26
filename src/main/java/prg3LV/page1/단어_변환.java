package prg3LV.page1;

import java.util.LinkedList;
import java.util.Queue;

public class 단어_변환 {

    // 완전탐색

    // 다른 사람 풀이 bfs
    static class Node {
        String next;
        int edge;
        public Node(String next, int edge) {
            this.next = next;
            this.edge = edge;
        }
    }

    public int solution1(String begin, String target, String[] words) {
        int n = words.length, ans = 0;
        Queue<Node> q = new LinkedList<>();

        boolean[] visit = new boolean[n];
        q.add(new Node(begin, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.next.equals(target)) {
                ans = cur.edge;
                break;
            }

            for (int i=0; i<n; i++) {
                if (!visit[i] && isNext(cur.next, words[i])) {
                    visit[i] = true;
                    q.add(new Node(words[i], cur.edge + 1));
                }
            }
        }

        return ans;
    }
    static boolean isNext(String cur, String n) {
        int cnt = 0;
        for (int i=0; i<n.length(); i++) {
            if (cur.charAt(i) != n.charAt(i)) {
                if (++ cnt > 1) return false;
            }
        }
        return true;
    }

    // dfs 풀이
    static boolean[] visited;
    static String statTarget;
    static String[] statWord;
    static int result = Integer.MAX_VALUE;
    public static int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        statTarget = target;
        statWord = words;

        dfs(begin, 0);
        if (result == Integer.MAX_VALUE) return 0;
        return result;
    }

    public static void dfs(String begin, int count) {

        if (begin.equals(statTarget)) {
            result = Math.min(result, count);
            return;
        }

        for (int i = 0; i < begin.length(); i++) {
            String beginSub = begin.substring(0, i) + begin.substring(i + 1);

            for (int j = 0; j < statWord.length; j++) {
                if (!visited[j]) {
                    String wordSub = statWord[j].substring(0, i) + statWord[j].substring(i + 1);
                    if (beginSub.equals(wordSub)) {
                        visited[j] = true;
                        dfs(statWord[j], count+1 );
                        visited[j] = false;
                    }
                }
            }
        }
    }

}
