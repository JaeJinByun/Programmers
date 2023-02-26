package level2.거리두기확인하기;

import java.util.*;

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
	public int[] solution(String[][] places) {
		int[] answer = new int[places.length];

		for(int i=0; i<5; i++) {
			String[] s = places[i];

			answer[i] = 1;

			loop:
			for(int r=0; r<5; r++) {
				for(int c=0; c<5; c++) {
					if(s[r].charAt(c) == 'P') {
						if(!bfs(r,c,s)) {
							answer[i] = 0;
							break loop;
						}
					}
				}
			}
		}
		return answer;
	}

	public boolean bfs(int row, int col, String[] map) {

		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};

		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(row,col));

		while(!queue.isEmpty()) {
			Node node = queue.poll();

			for(int i=0; i<4; i++) {
				int nR = node.r + dr[i];
				int nC = node.c + dc[i];
				int d = Math.abs(nR - row) + Math.abs(nC - col);

				if (nR < 0 || nC < 0 || nR >= 5 || nC >= 5 || (nR == row && nC == col) || d > 2)
					continue;


				if(map[nR].charAt(nC) == 'P' && d <= 2)
					return false;
				else if(map[nR].charAt(nC) == 'O' && d < 2)
					queue.offer(new Node(nR,nC));
			}
		}
		return true;
	}
}
class Node {
	int r;
	int c;

	public Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
}