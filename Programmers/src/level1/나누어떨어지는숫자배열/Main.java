package level1.나누어떨어지는숫자배열;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : arr) {
            if(i%divisor == 0) {
                list.add(i);
            }
        }
        if(list.size() == 0) return new int[]{-1};
        Collections.sort(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}