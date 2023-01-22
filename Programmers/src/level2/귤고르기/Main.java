package level2.귤고르기;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    static Map<Integer,Integer> map = new HashMap<>();
    public int solution(int k, int[] tangerine) {

        for(int i : tangerine) {
            // 크기 : 개수 형태의 Map 자료구조를 선언
            map.put(i, map.getOrDefault(i,0) + 1);
        }

        List<Integer> values = new ArrayList<>(map.values());
        values.sort(Integer::compareTo);

        Collections.reverse(values);

        int cnt = 0;
        for(int i : values) {
            if(k <= 0) {
                break;
            }
            k -= i;
            cnt++;
        }

        return cnt;
    }
}