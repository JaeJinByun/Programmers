package level2.택배상자;
import java.util.*;

public class Main {
    public static void main(String[] args) {
    }
}
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        // 보조 컨베이어 벨트
        Stack<Integer> stack = new Stack<>();

        //가져와야 할 상자의 인덱스
        int idx = 0;

        // for문은 기본 컨테이너의 벨트라고 생각 1번상자부터 끝 상자까지 돌면서
        for(int i=1; i<=order.length; i++) {
            //1. 컨베이어 벨트에서 온 상자가 원하는 상자인지?
            if(order[idx] != i) {
                stack.add(i);
                continue;
            }

            //2. 상자가 맞다면 상자를담고(answer++), 가져와할 택배의 인덱스
            answer++;
            idx++;

            //스택에서 다음상자와 비교
            while(!stack.isEmpty() && order[idx] == stack.peek()) {
                stack.pop();
                answer++;
                idx++;
            }
        }

        return answer;
    }
}
