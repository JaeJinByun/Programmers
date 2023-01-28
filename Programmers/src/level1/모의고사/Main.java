package level1.모의고사;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(int[] answers) {

        int[] m1 = {1, 2, 3, 4, 5};
        int[] m2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] m3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] cnt = new int[3];
        int size = answers.length;

        for(int i=0; i<size; i++) {
            int target = answers[i];
            //1번
            if(m1[i%5] == target) {
                cnt[0]++;
            }

            //2번
            if(m2[i%8] == target) {
                cnt[1]++;
            }

            //3번
            if(m3[i%10] == target) {
                cnt[2]++;
            }

        }

        int max = Math.max(cnt[0], Math.max(cnt[1],cnt[2]));

        LinkedList<Integer> list = new LinkedList<>();

        for(int i=0; i<3; i++) {
            if(max == cnt[i]) {
                list.add(i+1);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

// 12345 ...
// 21232425 ...
// 3311224455 ...
