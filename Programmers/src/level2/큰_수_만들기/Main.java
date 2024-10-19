package level2.큰_수_만들기;

public class Main {

  public static void main(String[] args) {
  }
}

class Solution {
  public String solution(String number, int k) {
    int len = number.length() - k;
    StringBuilder sb = new StringBuilder();

    int startIdx = 0;

    for (int i = 0; i < len; i++) {
      int max = Integer.MIN_VALUE;

      for (int j = startIdx; j <= i + k; j++) {
        if (number.charAt(j) - '0' > max) {
          max = number.charAt(j) - '0';
          startIdx = j + 1;
        }
      }
      sb.append(max);
    }

    return sb.toString();
  }
}
