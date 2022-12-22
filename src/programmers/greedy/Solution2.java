package programmers.greedy;

// �׸��� 2. ���̽�ƽ 
/*
�� - ���� ���ĺ�
�� - ���� ���ĺ� (A���� �Ʒ������� �̵��ϸ� Z��)
�� - Ŀ���� �������� �̵� (ù ��° ��ġ���� �������� �̵��ϸ� ������ ���ڿ� Ŀ��)
�� - Ŀ���� ���������� �̵� (������ ��ġ���� ���������� �̵��ϸ� ù ��° ���ڿ� Ŀ��)
���� ��� �Ʒ��� ������� "JAZ"�� ���� �� �ֽ��ϴ�.

- ù ��° ��ġ���� ���̽�ƽ�� ���� 9�� �����Ͽ� J�� �ϼ��մϴ�.
- ���̽�ƽ�� �������� 1�� �����Ͽ� Ŀ���� ������ ���� ��ġ�� �̵���ŵ�ϴ�.
- ������ ��ġ���� ���̽�ƽ�� �Ʒ��� 1�� �����Ͽ� Z�� �ϼ��մϴ�.

���� 11�� �̵����� "JAZ"�� ���� �� �ְ�, �̶��� �ּ� �̵��Դϴ�.
������� �ϴ� �̸� name�� �Ű������� �־��� ��, �̸��� ���� ���̽�ƽ ���� Ƚ���� �ּڰ��� return �ϵ��� solution �Լ��� ���弼��.

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
 �ΰ�����
 �Էµ� �Ű������� "AAA"�Դϴ� �׷��Ƿ� ù��° ���ں��� �����Ͽ� J(+9)������� ��, 
 ����° ������ Z�� ������ 2ĭ�� �ƴ϶� �ڷ� 1ĭ�� �����̸� �ǹǷ� (+1), 
 A���� Z�� ����� ���ؼ��� ���� ���ĺ����� �ѹ��� �̵��ϸ� �ǹǷ�(+1) = 11 �̶�� ���� ���°Ͱ����ϴ�
 */

/*
 * ���������� �̵��ؼ� Ȯ��
 * ������ �̵��ؼ� Ȯ�� 
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
    		// A=65, ���ĺ�=26�ڸ� Z=90, 26/2=13 �տ��� ���� ã���� 65+13=78 �� ��찡 �ݱ��� �ȴ�. 
    		// ���� 78���� ������ �տ������� ã�°� ������ 78���� ũ�� �ڿ��� ã�°� ������.
    		 		
        	// 1. �����̵� count
    		if(value != 65) { // A�� �ƴ� ��츸
    			answer += (value < 79) ? value - alphabetA : alphabetZ - value +1; // Ŀ���̵��� �ؾ��ϹǷ� +1 ���ش�.
    		}
    		// 2.�¿��̵� count
    		/* ���������θ� ������� �̵��ϴ� ��� -> (len-1) �� �̵�
    		 (���������� ���ٰ�) ���ӵ� A�� ���� �ٽ� �������� ���ư� �̵��ϴ� ���
    		�� ���� �ٽ� ���ư��� �̵��ϴ� ��찡 ���������θ� ���� ���(len-1) ���� ���� �̵�Ƚ���� ���� ��츦 ã�ƾ� �մϴ�.
    		
    		�� ��츦 �����غ��ô�. �� ���̰� 10�̹Ƿ� ���������θ� �̵��Ѵٸ�, len-1 = 9 ���� �̵��� �ϰ� �˴ϴ�.
    		
    		JERAAAAOEN

			�׷���, ���⼭ �����ص� �Ǵ� ����� ���ӵ� 'A'�� �����մϴ�.
			���������� ���ٰ� �ٽ� �������� �̵��ϴ� ��츦 ����غ��ϴ�.

			���������� �̵��ϴٰ� �������� �̵��ϴ� ��� ó�� ���������� idx(2)�� �̵��մϴ�. -> 2�� �̵�
			���ӵ� A�� ������, �±��� �ٽ� �ǵ��ư��ϴ�.(�������� idx�� �̵�) -> 2�� �̵�
			���ӵ� A�� ������ ������ idx = 6�� �� �Դϴ�. ���� conA�� ������ ���� ���ο� ������ ���� ��ġ�� 7�� �־��ݴϴ�.
			�ǵڿ��� ���� �������� �̵��ϸ� conA��° ���ڱ��� �;��մϴ�. (len - conA)�� �̵� -> 3�� �̵�
			�� �̵� Ƚ���� 2+2+3 = 7�Դϴ�. (idx + idx + len - conA)
			���������θ� �̵��ϴ� ����� 9�� �̵����� ���� �̵�Ƚ���� ���� �˴ϴ�.
    		*/
    		
    		int alphabetN = i+1; 
            //���� ���ڰ� A���� ���ư����ϴ� ��� i++;
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
