package prg2LV.page4;

public class 문자열_압축 {

    // 다른 사람 풀이, 재귀
    public int solution1(String s) {
        int answer = 0;

        for (int i = 1; i <= s.length()/2+1; i++) {
            int result = getSplitedLength(s, i, 1).length();
            answer = i==1 ? result : (answer>result?result:answer);
        }

        return answer;
    }
    public StringBuilder getSplitedLength(String ss, int n, int repeat) {
        StringBuilder s = new StringBuilder(ss);
        if (s.length() < n) return s; // 문자 길이가 쪼갠 문자길이보다 작아질 경우
        StringBuilder result = new StringBuilder();
        String preString = s.substring(0, n);
        String postString = s.substring(n);

        // 압축이 안 되는 경우
        if (!postString.startsWith(preString)) {

            // 한 번도 압축이 안 된 경우
            if (repeat == 1) return result.append(preString).append(getSplitedLength(postString, n, 1));
            // 한 번이라도 압축이 되었던 경우
            return result.append(Integer.toString(repeat))
                    .append(preString)
                    .append(getSplitedLength(postString, n, 1));
        }
        // 압축되는 경우
        return result.append(getSplitedLength(postString, n, repeat + 1));
    }

    // 완전 탐색으로 품
    public static int solution(String s) {
        int answer = s.length();
        int len = 0;
        // 쪼개는 길이 마다
        while (len < s.length() / 2) {
            int rCount = s.length(); // 문자열 길이
            int i = 0;
            // 문장 전체를
            while (i < s.length() - len) {
                int index = i;
                int count = 1;  // 중복 개수
                String current = s.substring(index, index+len+1);
                index += len + 1;
                // 다음 문장과 비교
                while (index + len < s.length()) {
                    if (current.equals(s.substring(index, index+len+1))) {
                        count++;
                        index += len + 1; // 다음 시작 인덱스
                    } else {
                        i = index; // 다음 시작 인덱스
                        break;
                    }
                }
                // 중복된 문자 빼줌
                if (count > 1)
                    rCount -= count * (len+1);

                // 압축 문자 새로 추가
                if (count >= 2){
                    rCount += len + 1 + Math.log10(count) + 1;
                }

                // 압축도중에 문자열이 끝났을 경우 체크
                if (index + len >= s.length()) break;
            }
            answer = Math.min(answer, rCount);
            len++;
        }
        return answer;
    }
}

