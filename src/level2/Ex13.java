package level2;

// 점프와 순간 이동
/*
 * K 칸을 앞으로 점프하거나, (현재까지 온 거리) x 2 에 해당하는 위치로 순간이동
 * 점프하면 K 만큼 배터리 소모
 * 최대한 배터리 소모를 줄여서 이동해라.
 * 
 * 이건 문제가 좀.. 애매 했어..
 * 숫자 N: 1 이상 10억 이하의 자연수 
 * 딱 맞춰야 하는 거네.. ㅆㅂ
 * dfs bfs 를 대입할게 아니라 
 * top-down 방식으로 꺼꾸로 나눠가면 좋겠다..
 * 나눠서 떨어지면 반으로 나누고 
 * 안떨어지면 n에서 하나 빼주고 count++; 
 * 
 * 
 */
public class Ex13 {
	public int solution(int n) {
		int answer = 0;
        
        while(n != 0){
            if(n % 2 == 0){
                n /= 2;
            } else {
                n--;
                answer++;
            }
        }
        return answer;
        
    }
	public static void main(String[] args) {
		Ex13 sol = new Ex13();

		int n = 5000;
		
		System.out.println(sol.solution(n));

	}

}
