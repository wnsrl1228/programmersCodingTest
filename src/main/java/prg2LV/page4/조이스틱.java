package prg2LV.page4;

public class 조이스틱 {


    // 다른 사람 풀이 : 좌표를 이용한 풀이
    // AABAAAB, AABAAAAABAB 와 같이 왼쪽으로 갔다가 오른쪽으로, 오른쪽으로 갔다가 왼쪽으로 (왼쪽으로 갔다 오른쪽에서 다시 왼쪽으로 가는 경우는 존재하지 않음)
    // 가는 경우를 체크해줘야 한다.
    // 단. BBBB의 경우 오른쪽으로 쭉 가는 경우가 최소값이기 때문에 len -1을 디폴트값으로 둔다.
    public int solution1(String name) {
        int answer = 0;
        int move = name.length() - 1; // 오른쪽으로 쭉 간 횟수

        for(int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A')); //상,하 알파벳 맞추기
            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                int endA = i + 1;
                while(endA < name.length() && name.charAt(endA) == 'A')
                    endA++;
                move = Math.min(move, i * 2 + (name.length() - endA));// 오른쪽으로 갔다 다시 왼쪽으로 꺾기
                move = Math.min(move, i + (name.length() - endA) * 2);// 왼쪽으로 갔다 다시 오른쪽으로 꺾기
            }
        }
        return answer + move;
    }

    // 완전 탐색 방법. 코드를 답에 끼어맞춘 느낌이다.
    // n이 최대 20이라 가능
    static int[] alp = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1};
    static String target;
    static int len;
    static int result = Integer.MAX_VALUE;
    public static int solution(String name) {
        int answer = 0;
        target = name;
        len = name.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append("A");
        }
        recursion(0, 0, sb, 0);

        return result;
    }

    private static void recursion(int index, int count, StringBuilder sb, int dire) {
        System.out.println("a");
        // count 를 이미 초과한 경우
        if (count > result) return;

        // 값이 같을 경우
        if (sb.toString().equals(target)) {
            // count가 0일 경우는 name이 전부 A인 경우임으로 마지막 이동 count 를 빼주지 않는다.
            if (count != 0) count--;
            result = Math.min(result, count);
            return;
        }

        StringBuilder temp = new StringBuilder(sb);
        if (target.charAt(index) != 'A' && target.charAt(index) != sb.charAt(index)) {
            count += alp[target.charAt(index) - 65];
            temp.setCharAt(index, target.charAt(index));
        } else {
            // A 이거나 이미 같을 경우 해당 방향으로만 진행
            if (dire != 0) {
                recursion((len + index + dire) % len, count + 1, temp, dire);
                return;
            }

        }
        // 양 방향 재귀
        for (int i = -1; i < 2; i+=2) {
            recursion((len + index + i) % len, count + 1, temp, i);
        }
    }

}
/**
 * 예시 JAZ
 *
 * 시작 AAA
 *  up * 9
 *      JAA
 *  left * 1
 *      JAA
 *  down * 1
 *      JAZ
 */
// 9 1 4 1 9 1 12 1 4 1 13
// 25 18 13