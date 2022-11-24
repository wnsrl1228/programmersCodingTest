package prg1LV;

//기사단원의 무기
public class TemplarWeapon {

    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int count = divisorCount(i); // 약수 개수 구함

            // 제한수치를 넘길 경우 power를 더해줌
            if (count > limit) {
                answer += power;
            } else {
                answer += count;
            }
        }
        return answer;
    }

    public int divisorCount(int num) {

        int answer = 0;

        if(Math.sqrt(num)%1==0){
            answer++;
        }

        for (int i = 1; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                answer += 2;
            }
        }
        return answer;
    }

    public int divisorCount2(int num) {
        if (num == 1) {
            return 1;
        }
        int answer = 2; // 초기 약수 개수 1과 num 2개
        int i = 2;      // 시작값
        int tempNum = (num / 2) + 1;

        // 약수의 큰 숫자보다 i값이 작은 동안에
        while (i < tempNum) {
            if (num % i == 0) {
                int val = num / i;
                // i와 나눈값이 같은 경우 약수 1추가 ex) 4의 2*2인 경우
                if (val == i) answer++;
                else answer+=2;
                tempNum = val;
            }
            i++;
        }
        return answer;
    }
}

/**
 * 기사 자신의 번호의 약수 개수 = 공격력
 * 기사는 공격력에 맞는 무기를 가질 수 있음
 * 공격력이 제한수치를 넘길 경우 정해진 무기를 부여 받음
 * 공격력1 = 1kg 철 필요
 */
