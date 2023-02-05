package level1.문자열나누기;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(String s) {
        int answer = 0;

        int scnt = 1;
        int dcnt = 0;
        char x  = s.charAt(0);


        for(int i=1; i<s.length(); i++) {
            if(x == ' ') {
                x = s.charAt(i);
                continue;
            }

            if(x == s.charAt(i)) {
                scnt++;
            }else{
                dcnt++;
            }

            if(scnt == dcnt) {
                x  = ' ';
                answer++;
                scnt = 1;
                dcnt = 0;
            }
        }
        if(x != ' ') answer++;

        return answer;
    }
}
