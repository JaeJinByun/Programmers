package level2.뒤에있는큰수찾기;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(new int[]{9,1,5,3,6,2});
    }
}

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<numbers.length; i++) {

            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                //뒤에 있는 수가 더 큰수 인 경우
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}