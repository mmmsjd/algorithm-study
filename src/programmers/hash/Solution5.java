package programmers.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// 해시 15.베스트앨범
public class Solution5 {
	
	public int[] solution(String[] genres, int[] plays) {
		
		// 장르별 총건수
	    HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
        }
        
        List<String> keySet = new ArrayList<>(map.keySet());
        // Value 기준으로 내림차순 정렬.
        keySet.sort((o1, o2) -> map.get(o2) - map.get(o1));
        
        ArrayList<Music> result = new ArrayList<>();
        for(String key : keySet){
        	ArrayList<Music> list = new ArrayList<>();
        	// 같은 장르내 
            for(int i=0; i<genres.length; i++){
                if(genres[i].equals(key)){
                	list.add(new Music(key, plays[i], i));
                }
            }
            Collections.sort(list, (o1, o2) -> o2.play - o1.play); // 내림차순 소팅
            
            
            for (int i = 0; i < list.size(); i++) {  
            	if(list.size() == 1) {
            		result.add(list.get(i));
            		break;
            	}
            	if(i < 2) {// 최대 2개 까지만 가능
            		result.add(list.get(i));
            	}
			}
        }
        int[] answer = new int[result.size()];
        int c = 0;
        for (Music m : result) {        	
        	answer[c++] = m.idx;        	
		}
        
        //debug
        for (int i : answer) {
        	System.out.println(i);
		}
	    return answer;
	}
	
	class Music{
        String genre;
        int play;
        int idx;

        public Music(String genre, int play, int idx) {
            this.genre = genre;
            this.play = play;
            this.idx = idx;
        }
	}
	
	public static void main(String[] args) {
		Solution5 sol = new Solution5();
		
		String[] nums = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		System.out.println(sol.solution(nums, plays));

	}

}
