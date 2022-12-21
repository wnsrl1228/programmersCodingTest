package prg2LV.page4;

import java.util.*;
import java.util.stream.Collectors;
// 못 품
public class 순위_검색 {

    // 다른 사람 풀이,
    // info 에 있는 조건의 모든 경우의 수를 구해서 key 값에 넣고 value 에 점수를 담아준다.
    // query 에 맞춰서 map 에 있는 점수들 중 조건에 맞는 애들의 개수를 이진탐색으로 구한다.
    public static String[] strInfo;
    public static HashMap<String, ArrayList<Integer>> scoreMap = new HashMap<>();
    static int score;
    static String[] strings;
    public int[] solution(String[] info, String[] query) {

        for (String s : info) {
            strings = new String[4];
            strInfo = s.split(" ");
            score = Integer.parseInt(strInfo[4]);
            dfs(0);
        }

        for (String key : scoreMap.keySet()) {
            Collections.sort(scoreMap.get(key));
        }
        int index = 0;
        int[] answer = new int[query.length];
        for (String q : query) {
            String[] strs = q.split(" and | ");
            String key = strs[0] + strs[1] + strs[2] + strs[3];

            if (!scoreMap.containsKey(key)) {
                answer[index++]=0;
            } else {
                ArrayList<Integer> ansList = scoreMap.get(key);
                answer[index++] = ansList.size() - lowerBound(ansList, Integer.parseInt(strs[4]));
            }
        }
        return answer;
    }
    public void dfs(int level) {
        if (level == 4) {
            String str = String.join("", strings);
            if (!scoreMap.containsKey(str)) {
                scoreMap.put(str, new ArrayList<>());
            }
            scoreMap.get(str).add(score);
            return;
        }
        strings[level] = strInfo[level];
        dfs(level + 1);
        strings[level] = "-";
        dfs(level + 1);
    }
    public static int lowerBound(ArrayList<Integer> list, int key) {
        int left = 0, right = list.size() - 1;
        // 10 20 30 40 50 40
        while (left <= right) {
            int mid = (left + right) / 2;

            if (list.get(mid) < key)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }

    // 효율성 실패, set 의 교집합 연산이 n이라 그런듯 하다.
    public int[] solution1(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, Set<Integer>> language = new HashMap<>();
        Map<String, Set<Integer>> job = new HashMap<>();
        Map<String, Set<Integer>> career = new HashMap<>();
        Map<String, Set<Integer>> soulFood = new HashMap<>();
        List<Integer> score = new ArrayList<>();

        mapInit(language, new String[]{"cpp","java","python"});
        mapInit(job, new String[]{"backend","frontend"});
        mapInit(career, new String[]{"junior","senior"});
        mapInit(soulFood, new String[]{"chicken","pizza"});

        Set<Integer> temp = new HashSet<>();
        for (int i = 0; i < info.length; i++) {
            temp.add(i);
            String[] row = info[i].split(" ");
            language.get(row[0]).add(i);
            job.get(row[1]).add(i);
            career.get(row[2]).add(i);
            soulFood.get(row[3]).add(i);
            score.add(Integer.valueOf(row[4]));
        }
        int index = 0;
        for (String s : query) {
            Set<Integer> rows = new HashSet<>();
            rows.addAll(temp);

            String[] q = s.split(" ");


            if (!q[0].equals("-")) {
                rows.retainAll(language.get(q[0]));
            }
            if (!q[2].equals("-")) {
                rows.retainAll(job.get(q[2]));
            }
            if (!q[4].equals("-")) {
                rows.retainAll(career.get(q[4]));
            }
            if (!q[6].equals("-")) {
                rows.retainAll(soulFood.get(q[6]));
            }

            System.out.println(rows);
            answer[index++] = (int) rows.stream()
                    .filter((integer -> score.get(integer) > Integer.valueOf(q[7]))).count();
        }

        return answer;
    }

    private void mapInit(Map<String, Set<Integer>> language, String[] strs) {
        for (String str : strs) {
            language.put(str, new HashSet<>());
        }
    }
}
/**
 *
 */
