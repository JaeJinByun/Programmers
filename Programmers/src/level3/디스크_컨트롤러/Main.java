package level3.디스크_컨트롤러;

import java.util.*;


/**
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/42627
 * Problem: 디스크 컨트롤러
 * Level: 3
 * Algorithm: Heap
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int[][] jobs) {
        int total = 0; //총 시간
        int time = 0;  //지금까지 진행된 시간
        int cnt = 0;   //처리된 디스크의 개수
        int index = 0; //디스크 배열의 인덱스용 변수

        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); //요청을 기준으로 오름차순으로 정렬
        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));  //처리시간이 작은 순대로 정렬

        while (cnt < jobs.length) {

            //지금까지 진행된 시간전에 들어온 요청을 우선순위 큐에 삽입
            while (index < jobs.length && jobs[index][0] <= time) {
                queue.add(jobs[index++]);
            }

            //큐가 비어있다면 진행된 시간을 다음 요청으로 갱신
            if (queue.isEmpty()) {
                time = jobs[index][0];
            }

            //디스크 처리하기
            else {
                int[] arr = queue.poll();
                total += arr[1] - arr[0] + time;
                time += arr[1];
                cnt++;
            }
        }

        return total / jobs.length;
    }
}