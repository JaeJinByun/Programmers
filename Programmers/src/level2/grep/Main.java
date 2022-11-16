package Programmers.src.level2.grep;

public class Main {

	public static void main(String[] args) {
		System.out.println("ss");
		
	}
	 public static int[] solution(long begin, long end) {
	       
			int[] answer = new int[(int) (end - begin) + 1];	
			// begin ~ end 사이의 값 판별 
			// 인덱스의 번호는 최대 공약수 
			// 조건 소수일시 1 
			
			for(long i=begin; i<=end; i++) {
				answer[(int) (i-begin)] = (int)isPrime(i);
			}			
			 return answer;
		}	
		public static long isPrime(long number) {
	        if(number == 1) {
	            return 0;
	        }
	        
			for(int i=2; i <= (int)Math.sqrt(number); i++) {
				if(number % i == 0) {
					return number/i;
				}
			}
			// 소수 
			return 1;
		}
}
