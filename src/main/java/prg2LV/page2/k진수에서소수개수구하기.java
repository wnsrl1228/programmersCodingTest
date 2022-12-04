package prg2LV.page2;


public class k진수에서소수개수구하기 {

    public int solution(int n, int k) {
        int answer = 0;
        String number ="";
        // 진수 변환
        while (n != 0) {
            number = (n % k) + number;
            n = n / k;
        }
        // 소수만 분리
        number = number.replaceAll("[0]{2,}", "0");
        String[] split = number.split("0");

        // 소수 여부 체크
        for (String s : split) {
            double num = Double.parseDouble(s);
            if (isPrime(num)) answer++;
        }
        return answer;
    }
    public boolean isPrime(double num) {
        if (num == 2) return true;
        if (num == 1) return false;
        for (int i = 3; i <= Math.sqrt(num); i++) {
            if (num%i == 0) return false;
        }
        return true;
    }

}
