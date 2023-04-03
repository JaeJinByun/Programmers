package KAKAO_2021_BLIND_RECRUITMENT.신규아이디추천;

/**
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/72410
 * Problem: 신규아이디추천
 * Level: 1
 * Algorithm: 문자열
 */
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("...!@BaT#*..y.abcdefghijklm"));
    }
}

class Solution {
    public String solution(String new_id) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        //1. 대문자 -> 소문자
        new_id = new_id.toLowerCase();

        //2. 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }

        new_id = sb.toString();
        //3. .. -> .
        while (new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }


        //4. 맨끝 . 체크
        if (new_id.charAt(0) == '.')
            new_id = new_id.substring(1);

        if (!new_id.equals("") && new_id.charAt(new_id.length() - 1) == '.')
            new_id = new_id.substring(0, new_id.length() - 1);

        //5. 빈문자열체크
        if (new_id.equals(""))
            new_id = "aaa";

        //6. 16이상이면
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);

            if (new_id.charAt(new_id.length() - 1) == '.')
                new_id = new_id.substring(0, new_id.length() - 1);
        }

        if (new_id.length() <= 2) {
            char c = new_id.charAt(new_id.length() - 1);
            while (new_id.length() <= 2) {
                new_id += c;
            }
        }


        return new_id;
    }
}