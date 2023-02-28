package level2.괄호_회전하기;

import java.util.Stack;

/**
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/76502
 * Problem: 괄호 회전하기
 * Level: 2
 * Algorithm: 문자열
 */
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("[)(]");
    }
}

class Solution {
    public int solution(String s) {
        int answer = 0;
        String target = s+s;
        int start = 0;
        int end = s.length();
        for(int i=0; i<s.length(); i++,start++,end++) {
            if(isRight(target.substring(start,end))) answer++;
        }

        return answer;
    }

    public boolean isRight(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(c == '[' || c == '{' || c == '(') stack.push(c);
            else {
                if(stack.isEmpty()) return false;

                if(c == ']' && stack.peek() == '[') stack.pop();
                if(c == '}' && stack.peek() == '{') stack.pop();
                if(c == ')' && stack.peek() == '(') stack.pop();

            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}

