package level1.소수_찾기;

/**
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/12921
 * Problem: 소수 찾기
 * Level: 1
 * Algorithm: 수학
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int i=2; i<=n; i++) {
            if(isPrime(i) == true)
                answer++;
        }

        return answer;
    }
    public boolean isPrime(int num) {
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i == 0)
                return false;
        }
        return true;
    }
}

