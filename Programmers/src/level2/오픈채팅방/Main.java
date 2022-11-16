package level2.오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234",
						"Enter uid1234 Prodo","Change uid4567 Ryan"};
		for(String s : sol.solution(record)) {
			System.out.println(s);
		}
	}
}

class Solution {
    public String[] solution(String[] record) {
    	
    	
    	//1. Log를 남길 List 선언 
        List<String> result = new ArrayList<String>();
        
        //2. id : nick 맵 선언 
        Map<String,String> id_nick = new HashMap<String, String>();
        
        
        //2. 기록 순회 
        for(int i=0; i<record.length; i++) {
        	//3.{ 행위, 아이디, 닉네임} 으로 분리 
        	String[] detail = record[i].split(" ");
        	
        	if(detail[0].equals("Enter")) {
        		id_nick.put(detail[1], detail[2]);
        		result.add(detail[1] + "님이 들어왔습니다.");
        	}
        	
        	if(detail[0].equals("Leave")) {
        		result.add(detail[1] + "님이 나갔습니다.");
        	}
        	
        	if(detail[0].equals("Change")) {        		
        		id_nick.put(detail[1], detail[2]);
        	}
        	
        }
        //4. 최종 순회 
        String[] answer = new String[result.size()];
        
        //5. 
        for(int i=0; i<result.size(); i++) {
        	int idx = result.get(i).indexOf("님");
        	String id = result.get(i).substring(0,idx);
        	answer[i] = id_nick.get(id) + result.get(i).substring(idx);
        }
        
        return answer;
    }
}