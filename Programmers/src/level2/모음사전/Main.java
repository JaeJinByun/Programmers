package level2.모음사전;

import java.util.ArrayList;

/**
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 * Problem: 모음 사전
 * Level: 2
 * Algorithm: dfs, 완전 탐색
 */
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("EIO");
    }
}

class Solution {
    static ArrayList<String> arr = new ArrayList<>();
    static String[] words = {"A","E","I","O","U"};

    public int solution(String word) {

        dfs("");

        return arr.indexOf(word)+1;
    }

    public void dfs(String s) {
        if(s.length() > 5) return;
        else if(!s.equals("")){
            System.out.println(s);
            arr.add(s);
        }

        for(int i=0; i<5; i++) {
            dfs(s+words[i]);
        }

    }
}



