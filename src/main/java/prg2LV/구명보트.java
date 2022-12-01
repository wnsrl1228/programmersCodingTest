package prg2LV;

public class 구명보트 {
    public static void main(String[] args) {

    }

    public int solution(int[] people, int limit) {

        int result = 0;
        sort(people, 0, people.length - 1);

        int start = 0;
        int end = people.length -1;
        while (start < end) {
            if (people[start] + people[end] <= limit) {
                start++;
            }
            end--;
            result++;
        }
        if (start == end) {
            result++;
        }

        return result;
    }

//	[10,10, 25, 40, 55, 80, 80] 85
    public static void sort(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int x = a[(pl+pr)/2];

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr) {
                int tmp = a[pl];
                a[pl] = a[pr];
                a[pr] = tmp;
                pl++;
                pr--;
            }
        } while (pl <= pr );

        if (left < pr) sort(a, left, pr);
        if (right > pl) sort(a, pl, right);
    }
}
/**
 * 구명보트 최대 !2명씩! 탑승 가능 + 무게제한
 * 최대한 적게 구명보트 사용하는 경우
 */
