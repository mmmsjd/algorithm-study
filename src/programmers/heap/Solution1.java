package programmers.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// �� 1.�� �ʰ� 
public class Solution1 {
    public int solution(int[] scoville, int K) {
    	
    	/** ���� ������ ���ں� ���� 
    		= ���� ���� ���� ������ ���ں� ���� 
    		+ (�� ��°�� ���� ���� ������ ���ں� ���� * 2)
    	*/

    	// 1. ����� ť (���� ����), ������ ������ ���� ���� �켱������ ���� �ͺ��� ������ ��.
    	Queue<Integer> pq = new LinkedList<Integer>();
    	/*
    	 * �⺻ ��������
    	 */
//    	Arrays.sort(scoville);
    	
    	/* �������� String, Integer, Double ��� ���� obj Ÿ���� �迭�� Collections.reverseOrder() �� �����ϰ� 
    	 * �⺻Ÿ���� int, double, char, float ����� �Ұ��ϹǷ�
    	 * �⺻Ÿ���� �迭�� obj�� ����ϴ� wrapper class �� �ڽ����ָ� ���������� �����ϴ�.
    	 * Integer[] tmp = Arrays.stream(scoville).boxed().toArray(Intger[]::new); 
    	*/
    	
//    	Integer[] tmp = Arrays.stream(scoville).boxed().toArray(Integer[]::new);
//    	Arrays.sort(tmp, Collections.reverseOrder());
    	
    	for (int i : scoville) {
    		pq.add(i);
    	}
    	
    	int answer = 0;
    	while(pq.peek() < K) {
    		if(pq.size() == 1) return -1; // �� �� �ߴµ��� K���� ����ġ�� -1 
    		answer++;
    		int new_scoville = pq.poll() + (pq.poll() * 2);
    		pq.add(new_scoville);
    	}
    	
    	/////////////////////////////////////////////////////////////
    	// 2. ������
//    	
//    	// ���� ������ ����� �θ� IDX
//    	int parentIdx = getParent(size -1) ;
//    	
//    	// �ִ��� �����(��for��)
//    	for (int i = parentIdx; i >= 0; i--) {
//			heapify(scoville, i, size -1);
//		}
//    	for (int i : scoville) {
//    		System.out.print(i);
//		}
//    	System.out.println();
//    	
//    	//���� (�ִ� ���� ��������Ƿ� root �� ���� ū����)
//    	//���� ���� �� �ܰ迡�� root���(�ִ�)�� �� ���Ҹ� ��ȯ�ϰ�, �� ��ġ�� ������ �κ� Ʈ���� ���� ���� �����ϵ��� �籸���ϴ� ���̴�.
//    	for (int i = size-1; i > 0; i--) {
//    		swap(scoville, 0, i);
//			heapify(scoville, 0, i - 1);
//		}
    	/////////////////////////////////////////////////////////////

    	
    	
        return answer;
    }
    
    // ���ں� ���� ���
    int calc(int first, int second) {
    	return first + (second * 2);
    }
    
	
    
    	 
	// �θ� �ε����� ��� �Լ�
	private int getParent(int child) {
	    return (child - 1) / 2;  // (n-1)/2 �ܿ��� Ʈ�������� �θ���
	}
 
	// �� �ε����� ���Ҹ� ��ȯ�ϴ� �Լ�
	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
 
	// �ִ� �� ����� (heapify==sift-sown) �ִ� ���� ����� �Լ�
	private void heapify(int[] a, int parentIdx, int lastIdx) {
		
		/*
		 * ���� Ʈ������ �θ� ����� �ڽĳ�� �ε����� ���� �����ش�.
		 * ���� �θ� �ε����� ���� ū ���� �����ִٰ� �����Ѵ�.
		 */
		int leftChildIdx = 2 * parentIdx + 1;
		int rightChildIdx = 2 * parentIdx + 2;
		int largestIdx = parentIdx;
		
		/*
		 *  left child node�� ��
		 *  
		 *  �ڽĳ�� �ε����� ���� ���� �ε����� �Ѿ�� �����鼭
		 *  ���� ���� ū �ε������� ���� �ڽĳ���� ���� �� Ŭ���
		 *  ���� ū �ε����� ����Ű�� largestIdx�� ���� �ڽĳ���ε����� �ٲ��ش�.
		 *  
		 */
		if(leftChildIdx < lastIdx && a[largestIdx] < a[leftChildIdx]) {
			largestIdx = leftChildIdx;
		}
		
		/*
		 *  left right node�� ��
		 *  
		 *  �ڽĳ�� �ε����� ���� ���� �ε����� �Ѿ�� �����鼭
		 *  ���� ���� ū �ε������� ������ �ڽĳ���� ���� �� Ŭ���
		 *  ���� ū �ε����� ����Ű�� largestIdx�� ������ �ڽĳ���ε����� �ٲ��ش�.
		 *  
		 */
		if(rightChildIdx < lastIdx && a[largestIdx] < a[rightChildIdx]) {
			largestIdx = rightChildIdx;
		}
		
		/*
		 * largestIdx �� �θ��尡 ���� �ʴٴ� ����
		 * �� �ڽĳ�� �� �������� ���� �θ��庸�� ū ��尡 �����Ѵٴ� ���̴�.
		 * �׷� ��� �ش� �ڽ� ���� �θ��带 ��ȯ���ְ�,
		 * ��ȯ �� �ڽĳ�带 �θ���� ���� ����Ʈ���� �˻��ϵ��� ��� ȣ�� �Ѵ�.
		 */
		if(parentIdx != largestIdx) {
			swap(a, largestIdx, parentIdx);
			heapify(a, largestIdx, lastIdx);
		}
     
    }
	
    // ������ �켱���� ť (���� �����ϳ� �޸𸮸� ����ϴٸ�)
    void prioriQueueTest(int[] arr) {
//    	for (int i : arr) {
//    		System.out.print(i);
//		}
//    	System.out.println();
    	
    	PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
    	
    	for (int i = 0; i < arr.length; i++) {
			heap.add(arr[i]);
		}
    	for (int i = 0; i < arr.length; i++) {
    		arr[i] = heap.poll();
		}
    	
//    	for (int i : arr) {
//    		System.out.print(i);
//		}
    }
	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		
		int[] array = {1, 2, 3, 9, 10, 12};
		int k = 7;
		
		
		System.out.println(sol.solution(array, k));

	}

}
