package level1.평균구하기;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{1,2,3,4});
    }
}

class Solution {
    public double solution(int[] arr) {
        double answer = 0;

        double size = arr.length;
        double total = 0;
        for(int i : arr) {
            total += i;
        }

        answer = total/size;

        /* Stream Api 를 이용한 풀이 */
        Arrays.stream(arr).average().orElse(0);
        return answer;
    }
}
