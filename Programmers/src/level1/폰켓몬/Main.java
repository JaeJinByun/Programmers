package level1.폰켓몬;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}


class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        // 2/n 의 값
        int n = nums.length/2;
        //정렬 하기
        Arrays.sort(nums);
        //배열에서 중복제거
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i : nums) {
            hashSet.add(i);
        }

        if(n >= hashSet.size()) {
            return n;
        }

        return hashSet.size();
    }
}
//123456
//3마리 가져가기
//123456
// -> 중복제거
// -> 정렬
// -> 2/n 의 값 구하기
// -> 중복제거후 정렬한 배열의 길이 = M\
// 2/n >= m => m의 길이
// 2/n < m => 2/n 의 값