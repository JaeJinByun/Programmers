package level1.대충_만든_자판;

import java.util.Arrays;

/**
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/160586
 * Problem: 대충 만든 자판
 * Level: 1
 * Algorithm: 구현
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        int[] min = new int[26];
        Arrays.fill(min,Integer.MAX_VALUE);

        /* 각 알파벳 입력 최소값 삽입 */
        for(String s : keymap) {
            for(int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                min[c - 'A'] = Math.min(min[c - 'A'], i+1);
            }
        }

        /* 타겟 단어의 입력 횟수 구하기 */
        for(int i=0; i<targets.length; i++) {
            String str = targets[i];
            int sum = 0;
            for(int j=0; j<str.length(); j++) {
                char c  = str.charAt(j);
                if(min[c - 'A'] == Integer.MAX_VALUE) {
                    sum = -1;
                    break;
                }
                sum += min[c - 'A'];
            }
            answer[i] = sum;
        }

        return answer;
    }
}
