package level2.주식가격;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0; i<prices.length-1; i++) {
            int cnt = 0;
            boolean check = false;
            for(int j=i+1; j<prices.length; j++){
                if(prices[j] < prices[i]) {
                    cnt++;
                    answer[i] = cnt;
                    check = true;
                    break;
                }
                cnt++;
            }
            if(!check) {
                answer[i] = cnt;
            }
        }

        return answer;
    }
}