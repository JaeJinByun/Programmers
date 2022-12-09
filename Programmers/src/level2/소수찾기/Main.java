package level2.소수찾기;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("171");
    }
}
class Solution {
    static char[] arr;
    static boolean[] visited;
    static HashSet<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;

        arr = new char[numbers.length()];
        visited = new boolean[numbers.length()];

        for(int i=0; i<numbers.length(); i++) {
            arr[i] = numbers.charAt(i);
        }

        recursion("",0);

        answer = set.size();

        return answer;
    }

    /* dfs 완전 탐색  */
    public void recursion(String str, int idx) {
        int num ;
        if(str != "") {
            num = Integer.parseInt(str);
            if(isPrime(num)) set.add(num);
        }

        if(idx == arr.length) return;

        /* 하나의 노드마다 모든 경우의 수 탐색 주의할 점은 중복값이 들어가면안되기 때문에 백트래킹 해주어야 함*/
        for(int i=0; i<arr.length; i++){ /* 각 노드에 대해서 완전 탐색 ! 각 노드 각 노드 각 노드 */
            if(visited[i]) continue;
            visited[i] = true;
            recursion(str+arr[i],idx+1);
            visited[i] = false;
        }
    }

    /* 소수 판별 */
    public boolean isPrime(int number) {
        if(number == 0 || number == 1) return false;

        for(int i=2; i<=Math.sqrt(number); i++) {
            if(number%i == 0) return false;
        }
        return true;
    }
}

