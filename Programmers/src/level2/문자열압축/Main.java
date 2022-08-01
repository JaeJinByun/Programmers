package level2.문자열압축;

public class Main {

	public static void main(String[] args) {
		Solution sol  = new Solution();
		System.out.println(sol.solution("aabbaccc"));
		System.out.println(sol.solution("ababcdcdababcdcd"));
		System.out.println(sol.solution("abcabcdede"));
		System.out.println(sol.solution("abcabcabcabcdededededede"));
		System.out.println(sol.solution("xababcdcdababcdcd"));


	}

}

class Solution {
    public int solution(String s) {
    	//1.입력한 문자열 길이로 초기화 
        int answer = s.length();
        //2.압축한 정도 
        int count = 1;
        //3.압축할 범위 , 입력받은 문자열 길이의 반보다 커지면 압축 불가능 
        for(int i=1; i<=s.length()/2; i++) {
        	StringBuilder result = new  StringBuilder();
        	//4. 압축할 대상 
        	String base = s.substring(0,i);
        	
        	//5.구간을 나누어 비교 시작 
        	for(int j=i; j<=s.length(); j += i) {
        		
        		//6. 문자열의 길이보다 커질수 없음  
        		int end =  Math.min(j + i, s.length());
        	
        		//7. 비교대상 
        		String target = s.substring(j,end);
        		
        		//8.비교 대상이 같다면 압축 
        		if(base.equals(target)) {
        			count++;
        			
        		//9. 같지 않다면 압축Level과 문자열 추가 
        		}else {
        			if(count >= 2) {
        				result.append(count);
        			}
        			result.append(base);
        			base = target;
        			//압축level 1로 초기화 
        			count = 1;
        		}
        	}
        	result.append(base);
        	answer = Math.min(answer, result.length()) ;
        }
        return answer;
    }
}
