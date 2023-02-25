package level1.하샤드수;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean solution(int x) {

        int sum = Stream.of(String.valueOf(x).split("")).mapToInt(Integer::parseInt).sum();

        return x % sum == 0;
    }
}