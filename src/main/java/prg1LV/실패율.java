package prg1LV;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 실패율 {
    public static void main(String[] args) {
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        solution(5, stages);
    }
    public static int[] solution(int N, int[] stages) {

        int[] temp = new int[N+2];
        for (int stage : stages) {
            temp[stage]++;
        }

        List<Stage> stageScore = new ArrayList<>();
        double clearPlayer = stages.length;
        for (int i = 1; i < temp.length - 1; i++) {
            if (clearPlayer == 0) {
                stageScore.add(new Stage(i, 0));
                continue;
            }
            stageScore.add(new Stage(i, temp[i] / clearPlayer));
            clearPlayer -= temp[i];
        }
        Collections.sort(stageScore, Collections.reverseOrder());
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stageScore.get(i).stage;
        }
        return answer;
    }
    static class Stage implements Comparable<Stage> {
        int stage;
        double failRate;

        public Stage(int stage, double failRate) {
            this.stage = stage;
            this.failRate = failRate;
        }

        @Override
        public int compareTo(Stage o) {
            // 내림차순, 큰 값이 인덱스 -1 왼쪽으로
            if (failRate < o.failRate) return -1;
            if (failRate > o.failRate) return 1;
            return 0;
        }
    }
}
//2 2 2 3 3 4 1 6