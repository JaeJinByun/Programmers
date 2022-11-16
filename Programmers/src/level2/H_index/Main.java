package Programmers.src.level2.H_index;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] arr = {3,0,6,1,4,8,9};
		System.out.println(solution( arr ) );
	}
	
	public static int solution(int[] citations) {
		int answer = 0;
		
		Arrays.sort(citations);
		
		for(int i=0; i<citations.length; i++) {
			int compare_num = citations.length - i;
			
			if(citations[i] >= compare_num) {
				answer = compare_num;
				break;
			}
		}
		
		
		return answer;
	}
	
}
