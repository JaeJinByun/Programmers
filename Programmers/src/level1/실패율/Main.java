package level1.실패율;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        ArrayList<Double[]> arr = new ArrayList<>();


        int cnt = 0;
        int total = 0;
        for(int i=1; i<=N; i++) {
            for(int j : stages) {
                if(j >= i) {
                    total++;
                    if(j > i) cnt++;
                }
            }
            arr.add(new Double[]{(double)i,(double)cnt/total});

            cnt=0;
            total=0;
        }

        arr.sort((o1, o2) -> Double.compare(o1[1], o2[1]));

        cnt = 0;
        for(Double[] d : arr) {
            answer[cnt] = d[0].intValue();
            cnt++;
        }

        return answer;
    }
}