package nocode.programming;

//622. Design Circular Queue
//Linear Data Structure 로 implement 해야한다. array

//n == 6 이라면 
//idx % 6 

public class Queue1 {
	

	public static void main(String[] args) {
		
		
		String[] actions = {"put", "put", "get", "put", "get", "put", "get", "get", "get"};
		int[][] values = {{1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}};
		
		circularQueue(actions, values);
	}

	
	private static void circularQueue(String[] str, int[][] nums) {
		
	}
	
}
