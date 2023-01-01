package prg3LV.page2;

// 못 품
public class 입국심사 {

    /**
     * 전형적인 이분탐색 문제이다. 하지만 기준을 어떤 것으로 잡을지 감이 오지 않아서 풀지 못하였다.
     *
     * - 예상 정답을 이분탐색으로 줄여나가면서 조건에 만족하는 값을 리턴하면 된다.
     * 최소 심사시간을 0으로, 최대 심사시간을 times[lastIndex] * n 로 잡고
     * 이분 탐색으로 알맞은 time값을 찾아 나가면 된다.
     *
     * + 처음 high 값을 구할 때 long으로 감싸줘야 된다.
     */
    public static long solution(int n, int[] times) {
        long answer = -1;
        long row = 0;
        long high = (long)times[times.length - 1]*n;
        while (row <= high) {
            long mid = (high + row) / 2;
            long cnt = 0;
            for (long time : times) {
                cnt += (mid / time);
            }

            if (n <= cnt) {
                if (answer == -1) {
                    answer = mid;
                } else {
                    answer = Math.min(answer, mid);
                }
                high = mid - 1;
            } else {
                row = mid +1;
            }
        }
        return answer;
    }
}
