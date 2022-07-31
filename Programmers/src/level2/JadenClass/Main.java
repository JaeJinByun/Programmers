package level2.JadenClass;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {

		System.out.println(solution("3People followed"));
		 
	}
	public static String solution(String s) {
		String answer = s;
		 
		StringTokenizer st = new StringTokenizer(answer);
		answer  = "";
		while(st.hasMoreElements()) {
			String str = st.nextToken();
			String str2 = str.substring(1);
			char first_word = str.charAt(0);
			String temp = "";
			
			//첫글자 소문자라면 
			if(first_word >= 97 && first_word <= 122) {
				first_word = (char) (first_word - 32);
			}
			
			//나머지 글자 대문자 존재 ? 
			temp = str2.toLowerCase();
			answer += Character.toString(first_word)+temp+" ";
		}
		
		answer = answer.trim();
		return answer;
	}
}
