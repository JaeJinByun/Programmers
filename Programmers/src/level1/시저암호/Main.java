package level1.시저암호;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i=0; i<s.length(); i++) {
            char a = s.charAt(i);
            if(a == ' ') {
                answer += " ";
                continue;
            }
            if(a >= 'a' && a <= 'z') {
                if( a + n > 'z') a += n - 26;
                else a += n;
            }else {
                if( a + n > 'Z') a += n - 26;
                else a += n;
            }
            answer += a;
        }
        return answer;
    }
}
//A == 65, Z == 90 , a == 97