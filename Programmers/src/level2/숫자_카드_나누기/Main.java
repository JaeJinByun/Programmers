package level2.숫자_카드_나누기;

/**
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/135807
 * Problem: 숫자 카드 나누기
 * Level: 2
 * Algorithm: 구현, 최대공약수 구하기
 */

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(new int[]{10, 20}, new int[]{5, 17});
    }
}

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        //각 배열의 최대 공약수 구하기
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }

        //서로의 배열을 나눌 수 없는지 확인
        if (notDivisible(gcdA, arrayB)) answer = gcdA;

        if (notDivisible(gcdB, arrayA)) answer = Math.max(answer, gcdB);


        return answer;
    }

    /**
     * @return 배열의 요소를 하나도 나눌수 없다면 true 반환합니다.
     */
    public boolean notDivisible(int a, int[] arr) {
        for (int i : arr) {
            if (i % a == 0) return false;
        }
        return true;
    }

    /**
     * @return 최대공약수를 반환합니다.
     */
    public int gcd(int a, int b) {
        if (a % b == 0) return b;

        return gcd(b, a % b);
    }
}
