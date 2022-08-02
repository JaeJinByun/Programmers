package level2.거리두기확인하기;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
							 {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
							 {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
							 {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
							 {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		
		
		for(int i : sol.solution(places)) {
			System.out.print(i+" ");
		}

	}

}


class Solution {
	//상하좌우 좌표 
	int x1[] = {0,  1,  0,  -1};
	int y1[] = {-1, 0,  1,   0}; 
	
	//대각선 좌표 
	int x2[] = {1, 1, -1, -1};
	int y2[] = {-1, 1, 1, -1};
	
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        String place[];
        
    	for(int i=0; i<5; i++) {
    		place = places[i];
    		answer[i] = bfs(place);        	
        }
        return answer;
    }
    
    //범위 검사
    public boolean range(int x, int y) {
    	
    	if(x > 4 || y > 4 || x < 0 || y < 0 ) {
    		return false;
    	}
    	
    	return true;
    }
    
    //탐색
    public int bfs(String[] place) {
    	
    	for(int i=0; i<5; i++) { //y 축 
    		for(int j=0; j<5; j++) { //x 축 
    			if(place[i].charAt(j) == 'P') {
    				
    				for(int k=0; k<4; k++) {
    					int x = x1[k] + j;
    					int y = y1[k] + i;
    					
    					//범위 검사 
    					if(range(x,y)) {
    						//상하좌우 탐색 
    						if(place[y].charAt(x) == 'P') return 0;
    						
    						//한칸 이동후 상하좌우 다시 탐색 
    						int dx = x + x1[k];
    						int dy = y + y1[k];
    						
    						// 상하좌우가 'O' 이면서 대각선이 P 이면 0리턴 
    						if(range(dx, dy) && place[y].charAt(x) =='O' && place[dy].charAt(dx) == 'P' ) {
    							return 0;
    						}
    					}
    					
    					//대각선 탐색 
    					x = j + x2[k];
    					y = i + y2[k];
    					// 범위안에 있고 대각선에 P 가 존재 || 상하좌우에 O 로 뚫려있을때 0리턴 = 맨해튼 지키지 못한경우 
    					if( (range(x,y) && place[y].charAt(x) == 'P') && (place[y].charAt(j) =='O' || place[i].charAt(x) == 'O')){
    						return 0;
    					}
    					
    				}
    				
    			}
    		}
    	}
    	//전부 통과시 1리턴 
    	return 1; 
    }
    
}







