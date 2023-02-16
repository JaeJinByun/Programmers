package level1.카드_뭉치;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Queue<String> a = new LinkedList<>();

    }
}

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> c1 = new LinkedList<>();
        Queue<String> c2 = new LinkedList<>();

        for (String str : cards1) {
            c1.add(str);
        }
        for (String str : cards2) {
            c2.add(str);
        }

        for (String str : goal) {
            if (!c1.isEmpty() && c1.peek().equals(str)) {
                c1.poll();
                continue;
            }else if (!c2.isEmpty() && c2.peek().equals(str)) {
                c2.poll();
                continue;
            }

            return "No";
        }

        return "Yes";
    }
}