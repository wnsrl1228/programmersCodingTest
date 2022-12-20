package prg2LV.page4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 못 품
public class 후보키 {
    // 다른 사람 풀이 참고
    // 완전탐색을 하면 되는 문제인데,
    // 중복되는 row index 를 가지고 유일성과 최소성을 처리하려다 보니 오히려 풀이가 어려워짐.
    // 그냥 전체 경우의 수를 다 체크해주면 되는 문제.
    public static int row;
    public static int col;
    public static List<Set<Character>> candidateKeys = new ArrayList<>();
    public static String[][] table;
    public static int solution(String[][] relation) {
        table = relation;
        row = relation.length;
        col = relation[0].length;

        // 컬럼이 여러 개일 경우
        for (int i = 0; i < col; i++) {
            getCandidateKey(0, i+1, "", new HashSet<>());
        }

        return candidateKeys.size();
    }

    private static void getCandidateKey(int start, int n, String current, Set<Character> out) {

        // 조합 완성일 경우
        if (current.length() == n) {
            if (isUnique(out) && isMinimal(out))
                candidateKeys.add(out);
            return;
        }

        for (int i = start; i < col; i++) {
            Set<Character> newOut = new HashSet<>(out);
            newOut.add(Character.forDigit(i,10));
            getCandidateKey(i+1, n, current + i, newOut);
        }
    }

    // 유일성 체크 : 직접 튜플을 str 로 더해서 중복여부를 체크해준다.
    static boolean  isUnique(Set<Character> key) {
        Set<String> set = new HashSet<>();
        for (String[] row : table) {
            String projection = "";
            for (char col : key) {
                projection += row[col - '0'];
            }
            if (set.contains(projection)) return false;
            else set.add(projection);
        }
        return true;
    }

    // 최소성 체크 : 해당 key 에 이미 존재하는 후보키가 모두 포함되어 있는지 체크
    static boolean  isMinimal(Set<Character> key) {
        for(Set<Character> candidateKey: candidateKeys) {
            if(key.containsAll(candidateKey)) return false;
        }
        return true;
    }

}
/**
 * 조합을 이용해서 튜플의 중복여부 체크
 * if 중복이 없을 경우
 *      count++;
 *      해당 컬럼에 체크표시를 해줌
 * else 중복이 있을 경우
 *      중복되는 열 정보 (3,5,6,2) 저장
 *      다른 컬럼의 해당 열 정보의 값이 다 다를 경우 count++;
 *
 */

/**
 * [["a", "1", "aaa", "c", "ng"],
 * ["b", "1", "bbb", "c", "g"],
 * ["c", "1", "aaa", "d", "ng"],
 * ["d", "2", "bbb", "d", "ng"]]
 *
 *  * [["a", "1", "aaa", "c", "ng"],
 *  * ["b", "1", "bbb", "e", "g"],
 *  * ["c", "1", "aaa", "d", "ng"],
 *  * ["d", "2", "bbb", "d", "ng"]]
 */