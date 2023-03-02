package level2.덧칠하기;

/**
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/161989
 * Problem: 덧칠하기
 * Level: 2
 * Algorithm: 구현
 */
public class Main {
    public static void main(String[] args) {

    }
}

/* Origin */
class Solution {
    static boolean[] visited;
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        visited = new boolean[n];
        for(int i : section) {
            visited[i-1] = true;
        }

        loop:
        for(int i=0; i<n; i++) {
            if(visited[i]) {
                answer++;
                for(int j=i; j<i+m; j++) {
                    if(j > n-1) break loop;
                    visited[j] = false;
                }
            }
        }

        return answer;
    }
}

/* Best */
class Solution2 {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int roller = section[0] + m - 1; //index 로 생각해야 하므로 -1

        for(int i=0; i<section.length; i++) {
            if(roller < section[i]) {
                answer++;
                roller = m-1 + section[i];
            }
        }

        return answer;
    }
}

/** 롤러의 위치를 기반으로 카운팅하는 방법
 *  칠해야 할 곳의 위치가 현재롤러의 위치보다 커지는 순간 롤러의 위치를 옮긴다.
 *  이때 롤러의 위치를 ( section[i] + 롤러의 길이 ) 로 이동시키는 것에 유의한다.
 */