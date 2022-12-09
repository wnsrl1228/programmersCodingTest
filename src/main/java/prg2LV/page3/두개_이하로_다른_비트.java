package prg2LV.page3;

public class 두개_이하로_다른_비트 {

    // 다른 사람 풀이, 규칙 적용
    public long[] solution1(long[] numbers) {
        long[] answer = numbers.clone();
        for(int i = 0; i< answer.length; i++){
            answer[i]++;
            answer[i] += (answer[i]^numbers[i])>>>2;
        }
        return answer;
        /**
         *      011111
         *      100000
         * xor--------
         *      011111
         * >>>2-------
         *      000111
         *      100000
         * +----------
         *      100111
         */
    }

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {

            int diff = Long.bitCount(numbers[i] ^ (numbers[i]+1));
            StringBuilder sb= new StringBuilder(Long.toBinaryString(numbers[i]+1));

            for (int j = sb.length() - 1; j >= 0; j--) {
                if (diff-- <= 2) break;
                sb.setCharAt(j, '1');
            }
            answer[i] = Long.parseLong(sb.toString(), 2);
        }

        return answer;
    }

}
