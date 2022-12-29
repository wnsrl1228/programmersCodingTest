package prg3LV.page1;

// 힌트 및 유형 참고
public class 스티커_모으기2 {

    // dp 초기인덱스를 2까지 잡아주는게 아닌 거 같아서 시도하지 않았는데 맞는 방식이였다.
    // 단순하게 n의 n-2와 n-3 중 큰 수를 더해주면 된다.
    // 이때 첫 번째 인덱스를 선택할 경우 마지막 인덱스는 선택이 안 되기 때문에
    // dp를 첫 번째 인덱스를 선택하는 경우와 안 하는 경우 두 번 진행해 준다.
    // 또한 마지막 인덱스가 가장 큰 값이라는 것을 보장하지 않기 때문에 len-1. len-2 인덱스 값을 비교해서 큰 값을 리턴해준다.
    public static int solution(int sticker[]) {
        int len = sticker.length;
        int[] dp0 = new int[len];
        int[] dp1 = new int[len];
        if (len == 1) return sticker[0];
        if (len == 2) {
            return  Math.max(sticker[0], sticker[1]);
        }
        if (len == 3) {
            return Math.max(sticker[2], Math.max(sticker[0] , sticker[1]));
        }
        dp0[0] = sticker[0];
        dp0[1] = sticker[1];
        dp0[2] = sticker[0] + sticker[2];
        dp1[0] = 0;
        dp1[1] = sticker[1];
        dp1[2] = sticker[2];

        for (int i = 3; i < len; i++) {
            if (dp0[i-2] < dp0[i-3] ) {
                dp0[i] = dp0[i-3] + sticker[i];
            } else {
                dp0[i] = dp0[i-2] + sticker[i];
            }
            if (dp1[i-2] < dp1[i-3] ) {
                dp1[i] = dp1[i-3] + sticker[i];
            } else {
                dp1[i] = dp1[i - 2] + sticker[i];
            }
        }

        return  Math.max(
                    Math.max(dp0[len-2], dp0[len-1] - sticker[len-1]),
                    Math.max(dp1[len-1], dp1[len-2])
        );

    }


}
