package prg3LV.page2;

import java.util.Arrays;

public class 일차_셔틀버스 {

    // 복잡해 보이지만, 단순하게 풀렸다.
    // 한 번 더 꼬았다면 못 풀었을 거 같다.
    public String solution(int n, int t, int m, String[] timetable) {
        int answer = 0;

        // 시간을 int형 분으로 변환한 뒤 정렬
        int[] time = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            time[i] = strToTime(timetable[i]);
        }
        Arrays.sort(time);

        int startTime = 540; // 09:00
        int timeIndex = 0;   // 크루원 탑승 시간 index
        int person = 0;      // 수용 가능 인원

        for (int i = 0; i < n; i++) {

            // 버스 간격마다 탑승 인원 체크
            person = m; // 수용가능 인원
            while (timeIndex < time.length && time[timeIndex] <= startTime && 0 < person) {
                timeIndex++;
                person--;
            }
            // 대기 중인 크루가 더 이상 없을 경우, 막차를 타고가면 된다.
            if (timeIndex == time.length) {
                startTime += t * (n-i);
                break;
            }
            // 다음 버스 시간
            startTime += t;
        }
        // 수용인원이 남은 경우 막차 타면 된다.
        if (person != 0) {
            answer = startTime-t;
        } else {
            // 그게 아닌 경우 마지막에 탄 사람 탑승 시간 - 1 분에 타면 된다.
            answer = time[timeIndex-1]-1;
        }
        return timeToStr(answer);
    }

    public static String timeToStr(int time) {
        int hour = time / 60;
        int minute = time % 60;
        return String.format("%02d:%02d", hour, minute);
    }

    // ex) "09:00" -> 540
    public static int strToTime(String str) {
        String[] split = str.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
