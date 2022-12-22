package level1;

// 단속카메라 (greedy)

/*
 * 
 */
public class Ex3 {

    public int solution(int[][] routes) {
        int answer = 0;
        
//        String s = "try hello  world";
        String s = "  tRy hello  WORLD    ";
        StringBuilder sb = new StringBuilder();
        
        String[] word = s.split(" ");
        
        for(int i=0;i < word.length;i++){
            String str = word[i];
            
            for(int j=0;j < str.length();j++){
                char ch = str.charAt(j);
                if(j%2 == 0){
                    sb.append(String.valueOf(ch).toUpperCase());
                }else{
                    sb.append(String.valueOf(ch).toLowerCase());
                }
            }
            if(i < word.length-1) sb.append(" ");
                
        }
        System.out.println(sb.toString());
        return 0;
    }
    
	public static void main(String[] args) {
		Ex3 sol = new Ex3();
		
		int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}; //2
		
		System.out.println(sol.solution(routes)); 

	}

}
