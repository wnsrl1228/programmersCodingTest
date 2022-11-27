package prg1LV;

public class 키패드누르기 {
    public String solution(int[] numbers, String hand) {
        String answer = "";

        int[] left = {0,3};
        int[] right = {2,3};
        for (int number : numbers) {

            switch (number) {
                case 1: case 4: case 7:
                    left[0] = 0;
                    left[1] = (number - 1) / 3;
                    answer+="L";
                    break;
                case 3: case 6: case 9:
                    right[0] = 2 ;
                    right[1] = (number - 1) / 3;
                    answer+= "R";
                    break;
                default:
                    if (number == 0) number = 10;
                    int x = 1;
                    int y = (number - 1) / 3;
                    int leftDiff = Math.abs(x - left[0]) + Math.abs(y - left[1]);
                    int rightDiff = Math.abs(x - right[0]) + Math.abs(y - right[1]);

                    if (leftDiff < rightDiff) {
                        left[0] = 1;
                        left[1] = (number - 1) / 3;
                        answer+="L";
                    } else if (leftDiff > rightDiff) {
                        right[0] = 1 ;
                        right[1] = (number - 1) / 3;
                        answer+= "R";
                    } else {
                        if (hand.equals("right")) {
                            right[0] = 1 ;
                            right[1] = (number - 1) / 3;
                            answer+= "R";
                        } else {
                            left[0] = 1;
                            left[1] = (number - 1) / 3;
                            answer+="L";
                        }
                    }
            }
        }

        return answer;
    }
}
/**
 * 1 2 3  0
 * 4 5 6  1
 * 7 8 9  2
 * * 0 #
 */