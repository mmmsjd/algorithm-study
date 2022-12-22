package nocode.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 93. ReStore IP addr
// 8bit 0~255

//case : brute
//case : bt

public class BT5 {
	
	
	public static void main(String[] args) {
//		String num = "222523125";		
		String num = "200023125";		
		
		addr(num);
		
		for(String s: result) {
			System.out.println(s);
		}
		
	}
	
	static String inStr;
	static List<String> result = new ArrayList<>();
	
	private static List<String> addr(String num) {
		
		inStr = num;
		bt(0, new ArrayList<>());		
		return result;
	}

	private static void bt(int idx, List<String> IPs) {
		
		System.out.println(idx);
		// exit conditions
		if(4 < IPs.size()) {
			return;
		}else if(idx == inStr.length() && IPs.size() == 4) {
			StringBuilder sb = new StringBuilder();
			
			for(String IP : IPs) {
				sb.append(IP);
				sb.append(".");
			}
			sb.deleteCharAt(sb.length()-1);
			
			result.add(sb.toString());
			return;
		}
		
		int inStrLen = inStr.length();
		int idxP3 = idx+3;
		
		for (int endIdx = idx; endIdx < Math.min(inStrLen, idxP3); endIdx++) {
			
			String numStr = String.valueOf(Arrays.copyOfRange(inStr.toCharArray(), idx, endIdx+1));
			
//			System.out.println("("+idx+" "+(endIdx+1)+")="+numStr);
			
			if(isValid(numStr)) {// candidates filtering
				IPs.add(numStr);
				bt(idx + numStr.length(), IPs); // recursive call
				IPs.remove(IPs.size()-1);
			}
		}
		return;
		
	}

	private static boolean isValid(String numStr) {
		if(numStr.length() ==1) {
			return true;
		}
		if(numStr.charAt(0) == '0') {
			return false;
		}
		if(Integer.parseInt(numStr) > 255) {
			return false;
		}
		
		return true;
	}
}
	
