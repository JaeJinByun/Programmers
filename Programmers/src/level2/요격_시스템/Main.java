package level2.요격_시스템;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

  public static void main(String[] args) {

  }
}

class Solution {

  public int solution(int[][] targets) {
    Arrays.sort(targets, Comparator.comparingInt(a -> a[1]));

    int answer = 0;

    int end = 0;

    for (int[] target : targets) {
      if (target[0] >= end) {
        answer++;
        end = target[1];
      }
    }

    return answer;
  }
}
