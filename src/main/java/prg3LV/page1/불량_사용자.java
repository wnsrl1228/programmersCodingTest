package prg3LV.page1;

import java.util.*;

public class 불량_사용자 {

    // dfs 완전탐색
    static String[] statUserId;
    static String[] statBanned_id;
    static List<ArrayList<Integer>> arr = new ArrayList<>();
    static boolean[] visited;
    static int count =0;
    static List<Set<String>> set = new ArrayList<>();
    public int solution(String[] user_id, String[] banned_id) {

        statUserId = user_id;
        statBanned_id = banned_id;
        visited = new boolean[user_id.length];

        for (int i = 0; i < banned_id.length; i++) {
            arr.add(new ArrayList<>());
        }

        // 미리 banned_id 에 가능한 user_id 목록을 구함.
        for (int i = 0; i < banned_id.length; i++) {
            for (int j = 0; j < user_id.length; j++) {
                if (check(banned_id[i], user_id[j])) {
                    arr.get(i).add(j);
                }
            }
        }
        dfs(0, new HashSet<>());

        return count;
    }

    public void dfs(int index, Set<String> temp) {
        if (index == statBanned_id.length) {
            if (!set.contains(temp)) {
                Set<String> a = new HashSet<>();
                for (String s : temp) {
                    a.add(s);
                }
                set.add(a);
                count++;
            }
            return;
        }

        for (int possibleId : arr.get(index)) {
            if (!visited[possibleId]) {
                visited[possibleId] = true;
                temp.add(statUserId[possibleId]);
                dfs(index+1, temp);
                temp.remove(statUserId[possibleId]);
                visited[possibleId] = false;
            }
        }
    }
    // 밴 아이디에 가능한 유저 아이디인지 여부
    public boolean check(String banId, String userId) {
        if (banId.length() != userId.length()) return false;

        for (int i = 0; i < banId.length(); i++) {
            if (banId.charAt(i) != '*' && banId.charAt(i) != userId.charAt(i))
                return false;

        }
        return true;
    }

}
