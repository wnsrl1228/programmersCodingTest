package prg2LV;


import java.util.ArrayList;
import java.util.HashSet;

public class 영어끝말잇기 {
    // 개선된 풀이 set 사용
    public int[] solution1(int n, String[] words) {
        int[] answer = new int[2];

        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        char end = words[0].charAt(words[0].length() - 1);

        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            set.add(word);
            if (set.size() != i+1 || word.charAt(0) != end) {
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                return answer;
            }
            end = word.charAt(word.length() - 1);
        }

        return answer;
    }
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        ArrayList<String> wordList = new ArrayList<>();
        wordList.add(words[0]);
        for (int i = 0; i < words.length - 1; i++) {
            String word = words[i];

            String nextWord = words[i + 1];
            if (word.charAt(word.length() - 1) != nextWord.charAt(0)
                    || wordList.contains(nextWord)) {
                answer[0] = (i+1)%n + 1;
                answer[1] = (i+2)%n == 0 ? (i+2)/n : (i+2)/n + 1;
                return answer;
            }
            wordList.add(nextWord);
        }

        return answer;
    }
}
/**
 * 탈락하는 사람번호, 몇 번째 턴에 탈락하는지
 */