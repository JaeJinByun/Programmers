package level1.자릿수_더하기;

import java.io.IOException;

/**
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/12931
 * Problem: 자릿수 더하기
 * Level: 1
 * Algorithm: 구현
 */

public class Main {
    public static void main(String[] args) throws IOException {

    }
}

class Solution {
    public int solution(int n) {
        int answer = 0;
        String[] digits = String.valueOf(n).split("");

        for(int i=digits.length-1; i>=0; i--) {
            answer += Integer.parseInt(digits[i]);
        }

        return answer;
    }
}