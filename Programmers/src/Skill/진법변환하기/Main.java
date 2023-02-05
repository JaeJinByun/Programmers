package Skill.진법변환하기;

public class Main {
    public static void main(String[] args) {
        int a = 100000000;
        System.out.println("10진수 -> 2진수");
        System.out.println(Integer.toBinaryString(a)); // return String
        System.out.println(Integer.toString(a,2));

        System.out.println("10진수 -> 3진수");
        System.out.println(Integer.toString(a,3));

        System.out.println("10진수 -> 4진수");
        System.out.println(Integer.toString(a,4));

        System.out.println("10진수 -> 5진수");
        System.out.println(Integer.toString(a,5));

        System.out.println("10진수 -> 6진수");
        System.out.println(Integer.toString(a,6));

        System.out.println("10진수 -> 7진수");
        System.out.println(Integer.toString(a,7));

        System.out.println("10진수 -> 8진수");
        System.out.println(Integer.toString(a,8));

        System.out.println("10진수 -> 16진수");
        System.out.println(Integer.toString(a,16));
    }
}
