package level2.위장;

import java.util.*;

public class Main {
}

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String,Integer> map = new HashMap<>();
        for(String[] str: clothes) {
            map.put(str[1], map.getOrDefault(str[1],0) + 1);
        }


        List<Integer> values = new ArrayList<>(map.values());
        for(int i : values ) {
            answer *= (i+1);
        }

        answer--;

        return answer;
    }
}