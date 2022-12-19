package prg2LV.page4;

import java.util.Stack;

public class 택배상자 {

    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};
        solution(a);
    }
    public static int solution(int[] order) {
        int answer = 0;
        Stack<Integer> container = new Stack<>();

        int orderIndex = 0;

        // 박스 [1,2,3 ... 주문개수]
        for (int i = 1; i <= order.length; i++) {
            if (order[orderIndex] == i) {
                answer++;
                orderIndex++;
            } else {
                if (container.isEmpty()) {
                    container.push(i);
                } else {
                    // 컨테이너에 있는 박스랑 같을 경우
                    if (container.peek() == order[orderIndex]) {
                        container.pop();
                        answer++;
                        orderIndex++;
                        i--; // 컨테이너박스를 빼주기 때문에 i는 상태를 유지해야 된다.
                    } else {
                        container.push(i);
                    }
                }
            }
        }
        // 컨테이너에 상자가 남아있을 경우 비교
        while (!container.isEmpty()){
            int con = container.pop();
            if (con != order[orderIndex]) {
                break;
            }
            answer++;
            orderIndex++;
        }

        return answer;
    }
}
/**
 * 4 3
 * 4 3 1 2 5
 */