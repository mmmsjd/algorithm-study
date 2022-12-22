package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// ÃÖ´ñ°ª°ú ÃÖ¼Ú°ª
public class Ex1 {
	
	public String solution(String s) {        
        List<Integer> list = new ArrayList<>();
        String[] arr = s.split(" ");
        for(String str : arr){
            list.add(Integer.parseInt(str));
        }
        
        Collections.sort(list);
        
        return list.get(0)+" "+list.get(list.size() -1);
    }

	public static void main(String[] args) {
		Ex1 sol = new Ex1();
		
		String s = "-1 -2 -3 -4";
		
		System.out.println(sol.solution(s));

	}

}
