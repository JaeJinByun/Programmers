package level2.숫자_변환하기;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(2, 5, 4);
    }
}

class Solution {
    private static final int MAX = Integer.MAX_VALUE;

    public int solution(int x, int y, int n) {
        int answer = 0;

        int[] dp = new int[y+1];

        for(int i=x+1; i<y+1; i++) {
            int a = MAX, b = MAX, c = MAX, d;
            //i/2 , i/3, i-n
            if( isDivided(i,2) && aboveX(x,i/2)) a = dp[i/2];
            if( isDivided(i,3) && aboveX(x,i/3)) b = dp[i/3];
            if( aboveX(x, i-n) ) c = dp[i-n];

            d = Math.min( Math.min(a,b), c);

            dp[i] = (d < MAX) ? d+1 : MAX;
        }

        if(dp[y] == MAX) answer = -1;
        else answer = dp[y];

        return answer;
    }

    public boolean aboveX(int x, int n) {
        return n >= x;
    }

    public boolean isDivided(int x, int n) {
        return x/n > 0 && x%n ==0;
    }

}
// 현재위치에서 i-n, i/2, i/3 의 위치에 있는 값과 비교하여 카운팅