package level2.기능개발;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = {93, 30, 55};
        int[] b = {1, 30, 5};
        sol.solution(a,b);
    }

}
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> deploy = new LinkedList<>();

        /* 남을 일자수를 큐에 넣기 */
        for(int i=0; i<progresses.length; i++) {
            int a = (100 - progresses[i]) / speeds[i];
            int b = (100 - progresses[i]) % speeds[i];
            if(b>0) ++a;
            deploy.add(a);
        }

        int cnt = 1;
        int target = deploy.poll();
        ArrayList<Integer> arrayList = new ArrayList<>();

        /* 하루에 배포되는 기능들 개수 비교 */
        while(!deploy.isEmpty()) {
            int next = deploy.poll();
            if(target >= next) {
                cnt++;
            }else {
                arrayList.add(cnt);
                target = next;
                cnt =1;
            }

        }
        arrayList.add(cnt);

        answer = new int[arrayList.size()];
        for(int i=0; i<arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }
        return answer;
    }
}