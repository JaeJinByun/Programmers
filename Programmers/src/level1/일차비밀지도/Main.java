package level1.일차비밀지도;

/**
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/17681
 * Problem: [1차] 비밀지도
 * Level: 1
 * Algorithm: 비트연산, 문자열
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i=0; i<n; i++){
            String s = Integer.toBinaryString(arr1[i] | arr2[i]);
            String tmp = "";

            for(int j=0; j<s.length(); j++) {
                if(s.charAt(j) == '1')
                    tmp += "#";
                else
                    tmp += " ";
            }
            for(int j=tmp.length(); j<n; j++) {
                tmp = " " + tmp;
            }
            answer[i] = tmp;
        }

        return answer;
    }
}
