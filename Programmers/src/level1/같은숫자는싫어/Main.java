package level1.같은숫자는싫어;
import java.util.*;


public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=1; i<arr.length; i++) {
            if( arr[i-1] != arr[i] ) {
                list.add(arr[i-1]);
            }
        }
        list.add(arr[arr.length-1]);

        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
