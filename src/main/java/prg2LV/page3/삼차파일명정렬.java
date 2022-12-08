package prg2LV.page3;

import java.util.*;

public class 삼차파일명정렬 {
    public static void main(String[] args) {

    }
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<File> arr = new ArrayList<>();

        for (String file : files) {
            String s = file.toUpperCase();
            int index = 0;
            while (!Character.isDigit(s.charAt(index))) {
                index++;
            }
            String head = s.substring(0, index);

            int numberIndex = index;
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                index++;
            }
            int number = Integer.parseInt(s.substring(numberIndex, index));

            arr.add(new File(file, head, number));
        }
        for (File file : arr) {
            System.out.print(file.head + " ");
        }
        System.out.println(" = ");
        Collections.sort(arr);
        for (File file : arr) {
            System.out.print(file.head + " ");
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = arr.get(i).fileName;
        }
        return answer;
    }

    static class File implements Comparable<File>{
        private String fileName;
        private String head;
        private int number;

        public File(String fileName, String head, int number) {
            this.fileName = fileName;
            this.head = head;
            this.number = number;
        }

        @Override
        public int compareTo(File o) {
            int result = this.head.compareTo(o.head);
            System.out.println("result = " + result);
            if (result > 0) return 1;
            else if (result < 0) return -1;
            else {
                if (this.number > o.number) return 1;
                else if (this.number < o.number) return -1;
            }
            return 0;
        }
    }
}
/**
 * HEAD : 문자    우선순위 1
 * NUMBER : 숫자  2
 * TAIL : 랜덤
 * */