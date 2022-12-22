package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//[3차] 파일명 정렬

/*
 * HEAD 문자기준 대소문자 안가림
 * NUMBER 숫자기준 0은 무시됨 9<10<0011<0012<13
 */
/*
 * 아이디어 
 * 우선 head와 number를 분리 
 * 출력을 위해 origin 을 보관 
 * ArrayList 에 순차적으로 저장 
 * 정렬 head 로 사전정렬 -> head 가 동일하다면 number 오름차순 정렬
 * 
 */

public class Ex32 {
			
    public String[] solution(String[] files) {
        
        
        ArrayList<File> fileList = new ArrayList<>();
        
        for (String file : files) {
        	String[] div = division(file);
        	fileList.add(new File(div[0], Integer.parseInt(div[1]), file));
		}
		
		for (File file : fileList) {
			System.out.println(file.head + " " + file.number + " " + file.origin);
		}
		System.out.println("-------------------------------------------------------");
	        
		Collections.sort(fileList, new Comparator<File>(){
			
			@Override
			public int compare(File o1, File o2) {				
				if ((o1.head).equals(o2.head)) { 	// HEAD 부분이 같다면 
                    return o1.number-o2.number; 	// NUMBER 오름차순 정렬
                }else{
                    return (o1.head).compareTo(o2.head); // HEAD 부분을 기준으로 사전 순 정렬
                }
			}
        });
		
		String[] answer = new String[fileList.size()];
		int add = 0;
		for (File file : fileList) {
			System.out.println(file.head + " " + file.number + " " + file.origin);
			answer[add++] = file.origin;
			
		}
        	
        return answer;
        
    }
    
    // 하 어렵넹 이것도 실패 
    String[] division(String file) {
    	
    	String[] div = new String[2];
    	
    	StringBuilder head = new StringBuilder();
    	StringBuilder number = new StringBuilder();
    	    	
    	int idx = 0;
    	for(char ch : file.toCharArray()) {
    		
			if(((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || ch == '-' || ch == '.') && idx == 0) {
				head.append(ch);
				continue;
			} 
			if(ch >= '0' && ch <= '9' && idx == 0)  {
				idx ++;
			}
			if(ch >= '0' && ch <= '9' && idx == 1)  {
				number.append(ch);
				continue;
			}
			if(((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || ch == '-' || ch == '.') && idx == 1) {
				idx ++;
			}
			
		}
    	
    	div[0] = head.toString().toLowerCase();
    	div[1] = number.toString();
    	
		return div;
	}
    
    // file name을 head, number, tail로 나누는 함수
    public static String[] splitFileName(String file){ 
        String str[] = new String[3];
        str[0] = ""; // HEAD
        str[1] = ""; // NUMBER
        str[2] = ""; // TAIL

        int idx = 0;
        for (int i = 0; i < file.length(); i++) {
            char c = file.charAt(i);

            if(idx==0 && !Character.isDigit(c)){
                str[idx] += c;
                continue;
            }

            if(idx==0 && Character.isDigit(c)){
                idx ++;
            }

            if(idx==1 && Character.isDigit(c)){
                str[idx] += c;
                continue;
            }

            if(idx==1 && !Character.isDigit(c)){
                idx ++;
            }
            str[idx] += c;
        }

        str[0] = str[0].toUpperCase();
        
        return str;
    }

	class File {
    	String head;
    	int number;
    	String origin;
    	
		public File(String head, int number, String origin) {
			this.head = head;
			this.number = number;
			this.origin = origin;
		}
    }
    
    
	public static void main(String[] args) {
		Ex32 sol = new Ex32();

		String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
//		String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		
		
		System.out.println(sol.solution(files)); 

	}

}
