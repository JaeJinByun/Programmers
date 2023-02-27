package level2.단체사진찍기;

/**
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/1835
 * Problem: 단체 사진 찍기
 * Level: 2
 * Algorithm: 순열, 백트래킹
 */
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(2, new String[]{"N~F=0", "R~T>2"});
    }
}

class Solution {
    static String[] arr;
    static int answer;
    static String[] datas;
    static boolean[] visited = new boolean[8];

    public int solution(int n, String[] data) {
        answer = 0;
        arr = new String[]{"A", "C", "F", "J", "M", "N", "R", "T"};
        datas = data;
        dfs("");
        return answer;
    }

    public void dfs(String s) {
        if(s.length() > arr.length) return;

        if(s.length() == arr.length) {
            if(check(s)) answer++;
            return;
        }

        for(int i=0; i<8; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(s+arr[i]);
            visited[i] = false;
        }
    }
    public boolean check(String s) {
        for(String ss : datas) {
            String[] sss = ss.split("");
            String t1 = sss[0];
            String t2 = sss[2];
            String t3 = sss[3];
            int num = Integer.parseInt(sss[4]) + 1;
            int diff = Math.abs(s.indexOf(t1) - s.indexOf(t2));
            switch (t3) {
                case "=" :
                    if(diff != num)
                        return false;
                    break;
                case "<" :
                    if(diff >= num)
                        return false;
                    break;
                case ">" :
                    if(diff <= num)
                        return false;
                    break;
            }
        }
        return true;
    }
}

//완탐 + 조건 부합 => 경우의 수
//A, C, F, J, M, N, R, T