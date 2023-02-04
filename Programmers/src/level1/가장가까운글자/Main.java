package level1.가장가까운글자;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        for(int i=0; i<s.length(); i++) {
            for(int j=i-1; j>=0 ; j--) {
                if(s.charAt(i) == s.charAt(j)) {
                    answer[i] = i-j;
                    break;
                }
            }
            if(answer[i]==0) answer[i] = -1;
        }
        return answer;
    }
}