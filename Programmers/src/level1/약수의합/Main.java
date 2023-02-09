package level1.약수의합;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int i=1; i<=n/2; i++) {
            if(n%i == 0) answer += i;
        }
        //1 2 4 8 16
        return answer;
    }
}
