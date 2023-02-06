package level1.신고결과받기;
import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    // <유저<신고한사람들>>
    static Map<String,Set<String>> map = new HashMap<>();
    static Map<String,Integer> indexMap = new HashMap<>();

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        //초기화
        int cnt = 0;
        for(String name : id_list) {
            map.put(name,new HashSet<>());
            indexMap.put(name,cnt);
            cnt++;
        }

        //신고 처리
        for(String name : report) {
            String from = name.split(" ")[0];
            String to = name.split(" ")[1];

            map.get(to).add(from);
        }

        for(String name : id_list) {
            Set<String> set = map.get(name); //해당 유저를 신고한 유저들
            if(set.size() >= k ) {
                for(String user : set) {
                    answer[indexMap.get(user)]++;
                }
            }
        }

        return answer;
    }
}