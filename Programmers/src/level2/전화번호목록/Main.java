package level2.전화번호목록;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean answer = sol.solution(new String[]{"119", "97674223", "1195524421"});
        System.out.println(answer);
    }
}

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for(int i=0; i<phone_book.length-1; i++) {
            /* i+1 부터 검사하는 정렬을 했기 때문에 이유는 2번째가 타겟이됨 */
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
                break;
            }
        }

        return answer;
    }
}