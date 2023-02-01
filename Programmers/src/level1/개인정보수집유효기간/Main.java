package level1.개인정보수집유효기간;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
    }

}

class Solution {
    static int[] t = new int[3];
    static Map<String,Integer> map = new HashMap<>();

    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<>();
        String[] aa = today.split("\\.");

        t[0] = Integer.parseInt(aa[0]);
        t[1] = Integer.parseInt(aa[1]);
        t[2] = Integer.parseInt(aa[2]);


        for(int i=0; i<terms.length; i++) {
            String[] a = terms[i].split(" ");

            map.put(a[0],Integer.parseInt(a[1]));
        }


        for(int i=0; i<privacies.length; i++) {
            if(check(privacies[i])) {
                arr.add(i+1);
            }
        }

        return arr.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean check(String pri) {
        String[] a = pri.split(" ");
        String date = a[0]; //날짜
        String type = a[1]; //종류

        return compare(date,type);
    }

    public boolean compare(String target, String type) {
        int validate = map.get(type);

        int y = validate/12;
        int d = validate%12;

        String[] a = target.split("\\.");
        int year = Integer.parseInt(a[0]) + y;
        int month = Integer.parseInt(a[1]) + d;
        if(month > 12) {
            year += month/12;
            month = month%12;
        }

        int date = Integer.parseInt(a[2]);

        //최종비교
        if(t[0] < year) {
            return false;
        }

        if(t[0] == year && t[1] < month){
            return false;
        }

        if(t[0] == year && t[1] == month && t[2] < date) {
            return false;
        }

        return true;
    }
}