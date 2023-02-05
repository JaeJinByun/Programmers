package level1.삼진법뒤집기;

import java.util.* ;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        // 10진법 -> 3진법
        while(n != 0) {
            list.add(n%3);
            n /= 3;
        }
        int size = list.size()- 1;

        for(int i : list) {
            answer += i*Math.pow(3,size);
            size--;
        }
        return answer;
    }
}

class Solution2 {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        // 10진법 -> 3진법 // 45 -> 1200
        String a = Integer.toString(n,3);
        int size = 0;
        for(int i=0; i<a.length(); i++) {
            answer += (a.charAt(i) - '0' ) *Math.pow(3,size);
            size++;
        }

        return answer;
    }

}




