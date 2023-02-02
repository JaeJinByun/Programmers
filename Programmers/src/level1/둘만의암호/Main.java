package level1.둘만의암호;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    static char[] arr;
    static int idx ;
    static String sk;

    public String solution(String s, String skip, int index) {
        arr = skip.toCharArray();
        idx = index;
        sk = skip;

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            sb.append( change(s.charAt(i)) );
        }
        return  sb.toString();
    }

    public char change(char c) {

        for(int i=0; i<idx; i++) {
            c++;
            if(c > 'z') c ='a';
            while(sk.contains(String.valueOf(c))) {
                c++;
                if(c > 'z') c = 'a';
            }
        }

        return  c;
    }
}
