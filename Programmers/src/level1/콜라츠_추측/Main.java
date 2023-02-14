package level1.콜라츠_추측;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int num) {
        int answer = 0;
        if (num == 1) return 0;

        while (true) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num * 3 + 1;
            }
            answer++;
            if (num < 0) {
                answer = -1;
                break;
            }
            if (num == 1) {
                break;
            }
        }
        return answer;
    }
}

class Solution2 {
    public int solution(int num) {
        int answer = 0;
        if(num == 1) return 0;

        for(int i=1; i<=500; i++) {
            num = (num%2 ==0) ? num/2 : num*3 + 1;
            if(num == 1) return i;
        }
        return -1;
    }
}