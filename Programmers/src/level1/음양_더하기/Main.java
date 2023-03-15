package level1.음양_더하기;


/**
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/76501
 * Problem: 음양 더하기
 * Level: 1
 * Algorithm: 구현
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i=0; i<signs.length; i++) {
            int target = absolutes[i];
            boolean sign = signs[i];
            if(!sign)
                target *= -1;

            answer += target;
        }


        return answer;
    }
}