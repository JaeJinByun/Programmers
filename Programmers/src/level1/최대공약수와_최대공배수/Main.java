package level1.최대공약수와_최대공배수;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        answer[0] = gcd(n, m);
        answer[1] = lcm(n, m);

        return answer;
    }

    public int gcd(int a, int b) {
        if(a % b == 0) return b;

        return gcd(b, a%b);
    }

    public int lcm(int a, int b) {
        int gcd = gcd(a,b);

        return (a*b)/gcd;
    }
}
