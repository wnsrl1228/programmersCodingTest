package prg3LV.page1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 여행경로 {

    // dfs 풀이
    static int N;
    static Map<String, ArrayList<String>> graph;
    static String result = "";
    public static String[] solution(String[][] tickets) {

        graph = new HashMap<>();
        for (String[] ticket : tickets) {
            if (!graph.containsKey(ticket[0]))
                graph.put(ticket[0], new ArrayList<>());

            graph.get(ticket[0]).add(ticket[1]);
        }
        N = tickets.length;
        dfs("ICN", "ICN", N);

        return result.split(" ");
    }

    private static void dfs(String airline, String current, int count) {
        if (count == 0) {
            if (result.length() == 0) {
                result = airline;
            } else {
                result = result.compareTo(airline) < 0 ? result : airline;
            }
            return;
        }

        // 도착지에만 포함된 도시는 graph 에 존재하지 않는다.
        if (graph.containsKey(current)) {
            // 반복문을 거꾸로 해줌으로써 이미 전체 탐색에 실패한 티켓을
            // for 문에 포함시키지 않을 수 있다.
            for (int i = graph.get(current).size()-1; i >= 0 ; i--) {
                String str = graph.get(current).remove(i);
                dfs(airline+ " "+ str, str, count-1);
                graph.get(current).add(str); // 추후 다른 재귀에서 사용할 수 있기에 추가시켜준다.
            }
        }
    }
}
// [["ICN", "A"], ["ICN", "B"], ["B", "ICN"]],  답 : ["ICN", "B", "ICN", "A"]
