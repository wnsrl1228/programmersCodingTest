package prg2LV.page4;

public class 양궁대회 {
    public static void main(String[] args) {
        int[] info = {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};
        solution(9, info);

        int a = 3;
        int b= 1;
        int c = 5;
        a -= b = c;
        System.out.println("a = " + a);
        System.out.println("a = " + b);
        System.out.println("a = " + c);
    }
    static int[] apeachInfo;
    static int[] tempResult;
    static int[] result;
    static boolean check = true;
    static int maxScoreDiff = 0;
    static int[] score = {10,9,8,7,6,5,4,3,2,1,0};
    static int N;
    public static int[] solution(int n, int[] info) {
        N = info.length;
        tempResult = new int[N];
        result = new int[N];
        apeachInfo = info;

        int apeachScore = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] > 0)
                apeachScore += score[i];
        }

        recursion(0,0, apeachScore, n);

        // 최고차로 이겼는데 화살이 남는 경우
        int sum = 0;
        for (int i : result) sum += i;
        if (sum < n) result[N-1] += n-sum;


        if (check) return new int[]{-1};
        return result;
    }

    private static void recursion(int targetIndex, int lionScore,int apeachScore, int arrow) {
        if (targetIndex == N || arrow == 0) {
            if (lionScore <= apeachScore) return;

            // 라이언이 점수가 더 클 때
            // 기존의 최대 차이보다 큰 경우 갱신
            if (maxScoreDiff < lionScore - apeachScore) {
                changeResult(result, tempResult);
                maxScoreDiff = lionScore - apeachScore;
            } else if(maxScoreDiff == lionScore - apeachScore) {
                // 최대 차이와 같을 경우, 낮은 점수에 더 많이 맞춘 결과를 고름
                for(int i = N-1; i>=0; i--) {
                    if (result[i] < tempResult[i]) {
                        changeResult(result, tempResult);
                        break;
                    } else if (result[i] > tempResult[i]) {
                        break;
                    }
                }
            }
            check = false;
            return;
        }

        // 이길 수 없는 경우
        if (apeachInfo[targetIndex] >= arrow) {
            recursion(targetIndex+1,lionScore, apeachScore, arrow);
        } else {
            // 이기는 경우
            tempResult[targetIndex] = apeachInfo[targetIndex] + 1;
            int minusScore = apeachInfo[targetIndex] == 0 ? 0 : score[targetIndex];
            recursion(targetIndex+1,lionScore + score[targetIndex], apeachScore - minusScore, arrow - (apeachInfo[targetIndex] + 1));
            tempResult[targetIndex] = 0;
            // 지는 경우
            recursion(targetIndex+1,lionScore, apeachScore, arrow);
        }
    }
    public static void changeResult(int[] result, int[] tempResult) {
        for (int i = 0; i < N; i++) {
            result[i] = tempResult[i];
        }
    }
}
/**
 * 라이언(이전 우승자) vs 어피치
 *  - 어피치 n발
 *  - 라이언 n발
 *
 *  - k점에 맞은 개수
 *      - 어피치가 더 많거나 같으면 k점 얻음
 *
 *  라이언에게 n발이 주어졌을 경우 가장 큰 점수차로 이기는 방법
 *  - 방법이 여러가지일 경우 낮은 점수를 더 많이 맞힌 경우를 고름
 *  - 방법이 없으면 -1
 */