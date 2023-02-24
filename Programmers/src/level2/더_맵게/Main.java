package level2.더_맵게;
import java.util.*;

/**
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/42626
 * Problem: 더 맵게
 * Level: 2
 * Algorithm: Heap
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i : scoville) {
            queue.add(i);
        }

        int answer = 0;
        while(queue.peek() < K) {
            if(queue.size() == 1) return -1;

            int first = queue.poll();
            int second = queue.poll();

            queue.add(first + (second * 2));
            answer++;
        }

        return answer;
    }
}