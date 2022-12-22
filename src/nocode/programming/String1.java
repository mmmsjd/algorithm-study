package nocode.programming;

import java.util.Arrays;

// 796. Rotate String
// �ذ��� case
// case : brute-force 				-> O(mn)
// case : KMP(Knuth-Morris-pratt)	-> O(n)
// case : rabin-karp (Rolling-hash) 
//    �� : hash-map+sliding window(hash==values) ���ڿ� üũ

public class String1 {

	public static void main(String[] args) {

//		String string = "abcdefgh";
//		String sub = "defgh";
//		bruteForce(string, sub);
		
//		String a = "dabcabkabcabd";
//		String b = "abcabd";		
//		kmp(a, b);

		String c = "dabcabkabcabd";
		String d = "abcabd";
		rabinKarp(c, d);

	}

	private static void rabinKarp(String str, String pattern) {
		boolean answer = false;
		int len = pattern.length();
		int hashValue = 0;
		
		for(char ch: pattern.toCharArray()) {
			hashValue += ch;
		}
		
		int idx = 0;
		int max = str.length();
		
		while(idx <= (max-len)) {			
			int newHashValue = 0;
			
			char[] newCh = Arrays.copyOfRange(str.toCharArray(), idx, len + idx);

			for(char ch: newCh) {
				newHashValue += ch;							
			}
			
			if(hashValue == newHashValue) {
				if(pattern.equals(String.copyValueOf(newCh))) {
					answer = true;
					break;
				}
			}
			idx++;
		}
		System.out.println(answer);
	}
	
	private static void kmp(String str, String pattern) {

		boolean answer = false;

		//"dabcabkabcabd";
		//"abcabd";
		
		int[] kmpArr = new int[pattern.length()];
		
		for (int i = 1, j = 0; i < kmpArr.length; i++) {
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = kmpArr[j-1];
			}
			if(pattern.charAt(i) == pattern.charAt(j)) {//������ 
				kmpArr[i] = ++j;
			}
		}
		System.out.print("Pi:");
		for(int i: kmpArr) {
			System.out.print(i);
		}
		System.out.println();
		
		
		int m = pattern.length();		
		for (int i = 0, j = 0; i < str.length(); i++) {
			while(j > 0 && str.charAt(i) != pattern.charAt(j)) {	
				System.out.println("index "+j+"���� ��ġ ����");
				j = kmpArr[j-1];//j�� ���� ��ġ���� -1 �ؼ� ���� �ε��� ��������
				System.out.print("��ġ ���� ���� j�� �ٲ��ش�.(shift)"+j);
				System.out.println("���� �ٽ� ���Ѵ�.");
			}
			if(str.charAt(i) == pattern.charAt(j)) {
				if(j == m - 1) {// ��ü ���̰� ��ġ�� ���
					System.out.println("index "+j+ "���� ��ġ");
					System.out.println("������ġ "+((i)-(m-1))+" index �������� ã�Ҵ�");
					j = kmpArr[j];//n�� ����
				}else { // ��Ī�� �̷������ 
					System.out.println("index "+j+ "���� ��ġ");
					j++;
				}
			}
		}
		
	}

	// ����Ž��
	private static void bruteForce(String string, String sub) {

		boolean answer = false;

		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		String[] arr1 = string.split("");
		String[] arr2 = sub.split("");
		int idx  = 0;
		int idx1 = 0;
		int idx2 = 0;
		
		while(idx < arr1.length-1) {
			
			while(idx2 < arr2.length) {	
				sb1.append(arr1[idx1++]);
				sb2.append(arr2[idx2++]);
			}
			if(sb1.toString().equals(sb2.toString())) {
				answer = true; break;
			}  
			else {
				sb1.setLength(0);
				sb2.setLength(0);
				idx++;
				idx1 = idx;
				idx2 = 0;	
			}
			
		}
		System.out.println(answer);

	}


}
