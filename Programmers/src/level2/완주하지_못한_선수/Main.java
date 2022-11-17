package level2.완주하지_못한_선수;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = sol.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},new String[]{"josipa", "filipa", "marina", "nikola"});
        System.out.println(s);

        Solution2 sol2 = new Solution2();
        String s2 = sol2.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},new String[]{"josipa", "filipa", "marina", "nikola"});
        System.out.println(s2);

        String [] alphabet = { "A", "B", "C" ,"A"};
        HashMap<String, Integer> hm = new HashMap<>();
        for (String key : alphabet){
            hm.put(key, hm.getOrDefault(key, 0) + 1);
        }
        System.out.println("결과 : " + hm);
        // 결과 : {A=2, B=1, C=1}
    }
}

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        /* 정렬 */
        Arrays.sort(participant);
        ArrayList cList = new ArrayList(List.of(completion));
        Collections.sort(cList);

        /* 완주하지 못한 사람 검사 */
        for(int i=0; i<cList.size(); i++) {
            if(!cList.get(i).equals(participant[i])){
                return answer = participant[i];
            }
        }

        /* 상단의 for 문 탈출하지 못할시에는 참가자 배열의 마지막이 완주하지 못한 사람이 됨*/
        return participant[participant.length-1];
    }
}
/* 다른 사람 풀이 */
class Solution2 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        /*
           💡 getOrDefault(Object key, V DefaultValue)

           key : 값을 가져와야 하는 요소의 키
           defaultValue : 지정된 키로 매핑된 값이 없는 경우 반환되어야 하는 기본값 => 키값이 없으면 반환할 값

           반환 값 : 찾는 key가 존재하면 해당 key에 매핑되어 있는 값을 반환하고, 그렇지 않으면 디폴트 값이 반환됩니다.
        */

        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}