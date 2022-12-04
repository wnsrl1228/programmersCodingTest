package prg2LV.page2;

public class 타겟넘버 {
    
    public static int result = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0,0);
        return result;
    }

    private void dfs(int[] numbers, int target, int index, int sum) {
        if (index >= numbers.length) {
            if (sum == target) result++;
            return;
        }
        int i = index;
        dfs(numbers, target, i+1, sum+numbers[i]);
        dfs(numbers, target, i+1, sum-numbers[i]);
    }
}
