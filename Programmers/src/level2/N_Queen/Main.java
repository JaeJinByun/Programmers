package level2.N_Queen;

/**
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/12952
 * Problem: N Queen
 * Level: 2
 * Algorithm: 백트래킹
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    static int size;
    static int answer = 0;
    static int[] map;
    public int solution(int n) {
        map = new int[n];
        size = n;
        dfs(0);

        return answer;
    }

    public void dfs(int row) {
        if(row == size) {
            answer++;
            return;
        }
        //index 열 , value 행 으로 생각
        /** 같은 행에 존재하는지 검사 */
        for(int col=0; col<size; col++) {
            map[row] = col;
            if(isPossible(row)) dfs(row+1);
        }
    }

    public boolean isPossible(int col) {
        for(int i=0; i<col; i++) {
            //col 이전의 열 하나하나에 대해서 같은 행에 존재하는지 검사 => 같은 행에 존재하는지 검사
            if(map[col] == map[i]) return false;
            //대각선 검사 0,0 1,1 0-1 == 0-1 (기울기가 같은지 검사)
            if(Math.abs(i - col) == Math.abs(map[col] - map[i])) return false;
        }
        return true;
    }
}