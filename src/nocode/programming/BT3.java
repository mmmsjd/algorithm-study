package nocode.programming;

import java.util.ArrayList;
import java.util.List;

// 46. Permutations

// �ߺ����� �ʴ� ������ ��ġ�� �ʴ� ���ڸ� ��� ��ȯ ��, �ڸ��� �ٲ㼭 ������ ������ �Ѵ�..
// part1 : �������� ��Ʈ 
// part2 : ���μ��� ��Ʈ
// part3 : ���(recursion) ȣ�� ��Ʈ 

// case : bt �� Ǫ�� ���
// case : �� ������� �����ϴ� ���̵�� 
// �� ���μ��� ��Ʈ���� !containsb �� ��츦 �ɷ� �´µ� 
// �� swap �� ���� for ���� ������� �ʾƵ� �ȴ�.
// a b c  ��� 
// b a    �� swap
// c   a  �� swap
//   c b  �� swap
// �̷��� swap �� ����ϸ� ���μ��� ��Ʈ�� O(n) -> O(1)  ���� �پ��� �ȴ�.




public class BT3 {
	
	
	public static void main(String[] args) {
		String[] num = {"a", "b", "c"};		//n!
				
		
		System.out.println(permutations(num));
		
	}

	private static String[] permutations(String[] num) {
		List<String> list = new ArrayList<>();
		
		bt(0, "", num, list);
		System.out.println(list.toString());
		
		return list.stream().toArray(String[]::new);
	}

	private static void bt(int idx, String letter, String[] num, List<String> list) {
		
		if(idx == num.length) {
			list.add(letter);
			return;
		}
		StringBuilder sb = new StringBuilder();
		for(String s: num) {
			if(!letter.contains(s)) {
				sb.append(s);
			}
		}
		String[] newnum = sb.toString().split("");
		
		for(String s: newnum) {
			bt(idx+1, letter + s, num, list);
		}
		
	}

}
