package level2.혼자_놀기의_달인;
import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int[] cards) {
        boolean[] opened = new boolean[cards.length];
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<cards.length; i++) {
            if(opened[i]) continue;
            int cnt = 1;
            opened[i] = true;
            int tmp = i;
            while(!opened[cards[tmp]-1]){
                opened[cards[tmp]-1] = true;
                cnt++;
                tmp = cards[tmp]-1;
            }
            arr.add(cnt);
        }
        Collections.sort(arr,Collections.reverseOrder());
        if(arr.size() == 1) return 0;

        return arr.get(0) * arr.get(1);
    }
}