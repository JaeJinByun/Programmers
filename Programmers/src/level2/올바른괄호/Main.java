package level2.올바른괄호;


import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("(())("));
    }
}

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        /* stack 을 이용한 쌍값 체크 */
        // 닫히는 괄호가 나올경우 하나씩 pop size가 exception(-1) 되는 순간 잘못된 쌍값

        Stack<Character> check = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char a = s.charAt(i);
            if(a == '(') {
                check.push('(');
            }else{
                try{
                    check.pop();
                }catch(Exception e) {
                    return false;
                }
            }
        }

        if(check.size() != 0) {
            return false;
        }

        return true;
    }
}