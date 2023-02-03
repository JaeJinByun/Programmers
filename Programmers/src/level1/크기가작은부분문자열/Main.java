package level1.크기가작은부분문자열;

public class Main {
    public static void main(String[] args) {

    }
}
class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        int size = p.length();
        int start = 0;

        Long pp = Long.parseLong(p);

        for(int i=size; i<=t.length(); i++,start++) {
            Long target = Long.parseLong(t.substring(start,i));
            if(pp >= target) answer++;
        }

        return answer;
    }
}