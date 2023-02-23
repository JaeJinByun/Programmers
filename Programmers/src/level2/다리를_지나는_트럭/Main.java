package level2.다리를_지나는_트럭;

import java.util.*;

/**
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/42583
 * Problem: 다리를 지나는 트럭
 * Level: 2
 * Algorithm: Stack/Queue
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int currentWeight = 0;
        int index = 0;
        int time = 0;

        while (true) {
            if (index == truck_weights.length) break;

            if (queue.size() == bridge_length) {
                currentWeight -= queue.poll();
            }
            //무게가 초과한다면
            else if (currentWeight + truck_weights[index] > weight) {
                queue.add(0); // <--- 자리를 채운다
                time++;
            } else {
                queue.add(truck_weights[index]);
                currentWeight += truck_weights[index];
                time++;
                index++;
            }

        }
        return bridge_length + time;
    }
}
