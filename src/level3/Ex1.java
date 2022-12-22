package level3;

import java.util.PriorityQueue;

// ���߿켱����ť 

/*
 * �켱���� ť �ΰ����!!
 */

public class Ex1 {
	
    public int[] solution(String[] operations) {
                
        PriorityQueue<Integer> min = new PriorityQueue<>();    				//��������
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2)-> o2-o1);
        
        for (String s : operations) {
			String oper = s.split(" ")[0];
			String value = s.split(" ")[1];
			
			if(oper.equals("I")) {				
				min.add(Integer.parseInt(value));
				max.add(Integer.parseInt(value));
				continue;
			}
			
			if(oper.equals("D")) {
				
				if(min.size() == 0) continue;
				
				if(Integer.parseInt(value) > 0) {// �ִ밪 ����
					int max_number = max.peek();
					max.remove(max_number);
					min.remove(max_number);
					
					
				}else {// �ּҰ� ����
					int min_number = min.peek();					
					max.remove(min_number);
					min.remove(min_number);
				}
			}
			
		}
        if(max.size() == 0) return new int[] {0, 0};
        
        // ���: [�ִ밪, �ּҰ�]
        int min_value = min.peek();
        int max_value = max.peek();
        
        return new int[] {max_value, min_value};
    }

	public static void main(String[] args) {
		Ex1 sol = new Ex1();
		
//		String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		System.out.println(sol.solution(operations));

	}

}
