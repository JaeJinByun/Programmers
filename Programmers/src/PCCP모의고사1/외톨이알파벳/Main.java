package PCCP모의고사1.외톨이알파벳;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String solution(String input_string) {
        String answer = "";

        int size = input_string.length();
        for(int i=0; i<size-1; i++) {
            if(input_string.charAt(i) == input_string.charAt(i+1)) {
                continue;
            }
            answer += input_string.charAt(i);
        }
        answer += input_string.charAt(size-1);

        int[] arr = new int[30]; //a-z 배열  // 'a' = 97
        for(int i=0; i<answer.length(); i++) {
            arr[answer.charAt(i) - 97]++;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > 1) {
                list.add(i+97);
            }
        }

        Collections.sort(list);
        answer = "";
        for(int c : list) {
            answer += (char)c;
        }

        if(answer.equals("")) {
            answer = "N";
        }

        return answer;
    }
}


