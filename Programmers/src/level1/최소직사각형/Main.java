package level1.최소직사각형;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}
class Solution {
    static int max = 0; //고정
    static int min = 0;
    static ArrayList<Integer> arr;
    public int solution(int[][] sizes) {
        int answer = 0;

        arr = new ArrayList<>();

        for(int i=0; i<sizes.length; i++) {
            arr.add(sizes[i][0]);
            arr.add(sizes[i][1]);
        }

        Collections.sort(arr);

        max = arr.get(arr.size() - 1);

        for(int i=0; i<arr.size()-1; i++) {
            for(int j[] : sizes) {
                if(min <= Math.min(j[0],j[1])) {
                    min = Math.min(j[0],j[1]);
                }
            }
        }

        return max * min;
    }
}
