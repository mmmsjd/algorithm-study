package programmers.greedy;

// 그리디 2. 조이스틱 
/*
▲ - 다음 알파벳
▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.

- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.

따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.

 */

/*
 Z
 Y
 X
 .
 .
 J = 9
 I
 H
 G
 F
 E
 D
 C
 B
 A
 */

/*
 부가설명
 입력된 매개변수가 "AAA"입니다 그러므로 첫번째 글자부터 시작하여 J(+9)만들어준 뒤, 
 세번째 글자인 Z는 앞으로 2칸이 아니라 뒤로 1칸만 움직이면 되므로 (+1), 
 A에서 Z를 만들기 위해서는 이전 알파벳으로 한번만 이동하면 되므로(+1) = 11 이라는 답이 나온것같습니다
 */

/*
 * 순차적으로 이동해서 확인
 * 역으로 이동해서 확인 
 */
public class Solution2 {
	
    public int solution(String name) {
    	int answer = 0;
    	int alphabetA = 65;
    	int alphabetZ = 90;
    	int len = name.length();
    	 
    	int move = len -1; 
        for(int i = 0; i < len; i++){
        	char ch = name.charAt(i);
        	int value = ch;   
    		// A=65, 알파벳=26자리 Z=90, 26/2=13 앞에서 부터 찾으면 65+13=78 인 경우가 반까이 된다. 
    		// 따라서 78보다 작으면 앞에서부터 찾는게 빠르고 78보다 크면 뒤에서 찾는게 빠르다.
    		 		
        	// 1. 상하이동 count
    		if(value != 65) { // A가 아닌 경우만
    			answer += (value < 79) ? value - alphabetA : alphabetZ - value +1; // 커서이동을 해야하므로 +1 해준다.
    		}
    		// 2.좌우이동 count
    		/* 오른쪽으로만 순서대로 이동하는 경우 -> (len-1) 번 이동
    		 (오른쪽으로 가다가) 연속된 A를 만나 다시 왼쪽으로 돌아가 이동하는 경우
    		온 길을 다시 돌아가서 이동하는 경우가 오른쪽으로만 가는 경우(len-1) 보다 적은 이동횟수를 갖는 경우를 찾아야 합니다.
    		
    		이 경우를 생각해봅시다. 총 길이가 10이므로 오른쪽으로만 이동한다면, len-1 = 9 번의 이동을 하게 됩니다.
    		
    		JERAAAAOEN

			그런데, 여기서 무시해도 되는 가운데의 연속된 'A'를 봐야합니다.
			오른쪽으로 가다가 다시 왼쪽으로 이동하는 경우를 고려해봅니다.

			오른쪽으로 이동하다가 왼쪽으로 이동하는 경우 처음 오른쪽으로 idx(2)번 이동합니다. -> 2번 이동
			연속된 A를 만나고, 온길을 다시 되돌아갑니다.(왼쪽으로 idx번 이동) -> 2번 이동
			연속된 A가 끝나는 지점은 idx = 6일 때 입니다. 따라서 conA에 연속이 끝나 새로운 글자의 등장 위치인 7을 넣어줍니다.
			맨뒤에서 부터 왼쪽으로 이동하며 conA번째 글자까지 와야합니다. (len - conA)번 이동 -> 3번 이동
			총 이동 횟수는 2+2+3 = 7입니다. (idx + idx + len - conA)
			오른쪽으로만 이동하는 경우인 9번 이동보다 적은 이동횟수를 갖게 됩니다.
    		*/
    		
    		int alphabetN = i+1; 
            //다음 글자가 A여서 돌아가야하는 경우 i++;
            while(alphabetN < len && name.charAt(alphabetN) == alphabetA){
            	alphabetN++;
            }
            move = Math.min(move, i + len - alphabetN + i);
            
    		
		}
        System.out.println(move);
        System.out.println(answer);
        return answer += move;
    }
    
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
//		String name = "JEROEN";//56
//		String name = "LABLPAJM";// answer:61
		String name = "BMOABA";// answer:30
//		String name = "LAABAA";// answer:15
		//String name = "AAAAAAAAJAAAA";// answer:14
		//String name = "SAAAAAARRM";// answer:41
		//String name = "RABAMATAWADLAFAVAAE";// answer:78
		//String name = "XAAAAAABA";// answer:6
		//String name = "AYOZAAVADAY";// answer:35
		//String name = "AAFEASAAVA";// answer:30
		//String name = "UAGAAASAAFAFXZA";// answer:47
		//String name = "AAAAZAATAEA";// answer:19
		//String name = "AACALATLAHABAA";// answer:50
		//String name = "FAWJAAAFV";// answer:35
		//String name = "AACAVAAPSAAOAA";// answer:49
		//String name = "AKAAWAKX";// answer:33
		//String name = "LOAAAHAJAAFAEBAWO";// answer:79
		//String name = "AWAWVAQVAAA";// answer:35
		//String name = "RCETAAAAVUEAETZAAAK";// answer:75
		//String name = "GTAASKKAE";// answer:52
		//String name = "AAAABAAAAAAKSAIQ";// answer:49
		//String name = "ADASAAAUAAAPAA";// answer:39
		//String name = "AAAAADBAAELSPUAAAOA";// answer:70
		//String name = "VJAAIAFNAAAAA";// answer:47
		//String name = "AARUAUAAHTBJAAYS";// answer:69
		//String name = "IASAGITUPHE";// answer:74
		//String name = "AAALAAAAAA";// answer:14
		//String name = "AAAEASAHQAYTAAAJ";// answer:60
//		String name = "BAALEAAAPMAAAHSRAV";// answer:83
		//String name = "ASWAAATDAJAXA";// answer:45
//		String name = "DYAOAAAARQANAWA";// answer:66
//		String name = "AAIAPB";// answer:24
		
		System.out.println(sol.solution(name));

	}

}
