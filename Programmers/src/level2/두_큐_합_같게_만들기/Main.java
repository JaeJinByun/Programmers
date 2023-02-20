package level2.두_큐_합_같게_만들기;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long s1 = 0, s2 = 0, sum = 0;
        for (int i = 0; i < queue1.length; i++) {
            sum += queue1[i] + queue2[i];
        }
        if (sum % 2 != 0) return -1;
        sum /= 2;

        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            q1.add((long) queue1[i]);
            s1 += queue1[i];
            q2.add((long) queue2[i]);
            s2 += queue2[i];
        }

        int answer = 0;
        while (s1 != s2) {
            if (s1 > sum) {
                s1 -= q1.peek();
                s2 += q1.peek();
                q2.add(q1.poll());
            } else {
                s2 -= q2.peek();
                s1 += q2.peek();
                q1.add(q2.poll());
            }
            answer++;
            if(answer > 300000) return -1;
        }


        return answer;
    }
}