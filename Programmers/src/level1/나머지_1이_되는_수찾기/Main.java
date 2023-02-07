package level1.나머지_1이_되는_수찾기;

public class Main {
    public static void main(String[] args) {
    }
}
class Solution {
    public int solution(int n) {
        int answer = Integer.MAX_VALUE;
        for(int i=n-1; i>=1; i--) {
            if(n%i == 1) {
                System.out.println(i);
                answer = Math.min(answer,i);
            }
        }
        return answer;
    }
}
