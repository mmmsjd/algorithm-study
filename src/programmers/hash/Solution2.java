package programmers.hash;

import java.util.HashMap;

// 해시 2.전화번호 목록
public class Solution2 {

	public boolean solution(String[] phone_book) {
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String s:phone_book)
            map.put(s,1);
        
        for(int i=0;i<phone_book.length;i++){
            for(int j=1;j<phone_book[i].length();j++){
                if(map.containsKey(phone_book[i].substring(0,j))){
                    return false;
                }
            } 
        }
        return true;
    }
	
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		
		String[] s1= {"119", "97674223", "1195524421"};
		
		System.out.println(sol.solution(s1));

	}

}
