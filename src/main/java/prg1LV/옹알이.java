package prg1LV;

public class 옹알이 {
    public static void main(String[] args) {
        String[] s = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        String[] s1 = {"ayawooyewooma"};
        int solution = solution(s);
        System.out.println("solution = " + solution);
    }

    public static int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        for (String bab : babbling) {
            boolean isSequence = false;
            for (String word : words) {
                int len = word.length();

                int prevIndex = bab.indexOf(word);
                int index = prevIndex;

                while (index != -1) {
                    bab = bab.replaceFirst(word, " ".repeat(len));
                    index = bab.indexOf(word);
                    if (prevIndex + len == index) {
                        isSequence = true;
                        break;
                    }
                    prevIndex = index;
                }
                if (isSequence) {
                    break;
                }
            }

            if (bab.trim().length() == 0 && !isSequence) {
                answer++;
            }

        }
        return answer;
    }
}
/**
 * 4가지 발음만 가능
 * 한가지 발음 연속 불가
 */