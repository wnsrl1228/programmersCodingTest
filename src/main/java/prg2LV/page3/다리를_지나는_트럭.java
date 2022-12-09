package prg2LV.page3;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Truck> bridgeTruck = new LinkedList<>();
        bridgeTruck.add(new Truck(truck_weights[0],1));

        int time = 1;
        int totalWeight = truck_weights[0];

        for (int i = 1; i < truck_weights.length ; i++) {

            int truck = truck_weights[i]; // 4

            // 다리에 수용가능한 무게를 초과하는 경우
            if (totalWeight + truck > weight) {
                boolean check = false;
                while (totalWeight + truck > weight) {
                    Truck inTruck = bridgeTruck.poll();
                    totalWeight -= inTruck.weight;
                    // 아직 다리를 지나가지 않았을 경우, time 계산
                    if (time - inTruck.time < bridge_length) {
                        time += bridge_length - (time - inTruck.time);
                        check = true;
                    }
                }
                // 무게가 초과했는데 이미 다리를 지나갔을 경우
                if (!check) time++;

            } else {
                time++;
            }

            totalWeight += truck;
            bridgeTruck.add(new Truck(truck, time));
        }
        // 마지막 트럭의 시간을 더해줌
        return time + bridge_length;
    }
    static class Truck {
        private int weight;
        private int time; // 출발 시간

        public Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }

}
/**
 * - -
 * 6 6 6
 */