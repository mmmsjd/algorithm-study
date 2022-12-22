package level2;

import java.util.ArrayList;
import java.util.HashMap;

// 오픈채팅방
/*
 * 
 { 
 "Enter uid1234 Muzi",
 "Enter uid4567 Prodo",
 "Leave uid1234",
 "Enter uid1234 Prodo",
 "Change uid4567 Ryan"
 }
 
 Prodo 가 들어왔습니다. 원래 uid1234
 Ryan 가 들어왔습니다.  원래 uid4567
 Prodo 가 나갔습니다.
 Prodo 가 들어왔습니다.
 
 아이디어가.. 음 어떤 자료구조를 써야하나?
 
 1.
 일단 uid는 HashMap<String, String> uid, name
 액션은 순서가 있는 List<String> uid
 이렇게 가면 될듯?
 
 2.
 uid는 HashMap 으로 취합. 
 action 과 uid 는 각자의 List 로 순서를 맞춤. 
 순서대로 조합.
 
 
 
 */
public class Ex25 {
	
    public String[] solution(String[] record) {
        
        HashMap<String, String> last_uid = new HashMap<>();
        ArrayList<String> actions = new ArrayList<>();
        ArrayList<String> uids = new ArrayList<>();
        
        for (int i = 0; i < record.length; i++) {
        	String[] rec = record[i].split(" ");
        	
        	String action 	= "";
        	String uid 		= "";
        	String nickname = "";
        	
        	if(rec.length > 2){
            	action 		= rec[0];
            	uid 		= rec[1];
            	nickname 	= rec[2];
        	}else { 		// record에 nickname 이 없는 경우는 나간 경우 밖에 없음.. 이전에 들어왔던 놈이라는 증거 
        		action 	 	= rec[0];
            	uid 	 	= rec[1];
            	nickname 	= last_uid.get(uid);
        	}
        	//중복제거로 마지막 uid 취합
        	last_uid.put(uid, nickname);
        	
        	if(!action.equals("Change")) {//는 안찍어도 되기에 삭제
        		uids.add(uid);       	
        		actions.add(action);       	
        	}
			
		}
        String[] answer = new String[actions.size()];
        
        for (int i = 0; i < actions.size(); i++) {
        	StringBuilder sb = new StringBuilder();
        	
        	String action 	= actions.get(i);
        	String uid	 	= uids.get(i);
        	
        	sb.append(last_uid.get(uid));
			sb.append(buildString(action));
			
			answer[i] = sb.toString();
		}
        
        return answer;
    }
    
    
	private String buildString(String action) {
		if(action.equals("Enter")) {
			return "님이 들어왔습니다.";
		}else if(action.equals("Leave")){
			return "님이 나갔습니다.";
		}
		return "";
	}


	public static void main(String[] args) {
		Ex25 sol = new Ex25();

		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		
		System.out.println(sol.solution(record)); 

	}

}
