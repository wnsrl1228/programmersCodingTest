package prg2LV.page3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class 소수_찾기 {
    public static void main(String[] args) {
        solution("011");
    }

    public static Set<Integer> set = new HashSet<>();
    public static boolean[] visited;
    public static int solution(String numbers) {

        int answer = 0;
        visited = new boolean[numbers.length()];
        makeNumber(numbers, "");
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (isPrime(next)) {
                answer++;
            }
        }
        return answer;
    }

    private static void makeNumber(String numbers, String current) {

        if (current.length() != 0) {
            set.add(Integer.parseInt(current));
        }
        if (current.length() == numbers.length()) {
            return;
        }
        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i] == false) {
                visited[i] = true;
                makeNumber(numbers, current+numbers.charAt(i));
                visited[i] = false;
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num%i == 0) return false;
        }
        return true;
    }
}


