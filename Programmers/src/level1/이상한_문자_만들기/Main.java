package level1.이상한_문자_만들기;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("abcd  abcd abc "));
    }
}

/* 효율성 Up +4점 */
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        int cnt = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                sb.append(" ");
                cnt = 0;
                continue;
            }

            if(cnt % 2 == 0) {
                if(c >= 'a') {
                    sb.append((char)(c - 32));
                }else {
                    sb.append(c);
                }
            }else {
                if(c >= 'a') {
                    sb.append(c);
                }else {
                    sb.append((char)(c + 32));
                }
            }
            cnt++;
        }

        return sb.toString();
    }
}

/* 정석 */
class Solution2 {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split("");
        int cnt = 0;

        for(int i=0; i<str.length; i++) {
            if(str[i].equals(" ")) {
                cnt = 0;
                answer += " ";
            }else if(cnt % 2 == 0) {
                answer += str[i].toUpperCase();
                cnt++;
            }else {
                answer += str[i].toLowerCase();
                cnt++;
            }
        }
        return answer;
    }
}