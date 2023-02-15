package level1.실패율;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer,Integer> map = new HashMap<>();

        Arrays.sort(stages);

        int cnt = 0;
        int total = 0;
        for(int i=1; i<=N; i++) {
            for(int j : stages) {
                if(j >= i) {
                    total++;
                    if(j > i) cnt++;
                }
            }
            double d = cnt/total;

            map.put(i,(int)d*100);
            cnt=0;
            total=0;
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        cnt = 0;
        for(Map.Entry<Integer,Integer> entry : list) {
            answer[cnt] = entry.getKey();
            cnt++;
        }

        return answer;
    }
}
