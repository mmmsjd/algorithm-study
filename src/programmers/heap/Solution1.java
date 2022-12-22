package programmers.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// 힙 1.더 맵게 
public class Solution1 {
    public int solution(int[] scoville, int K) {
    	
    	/** 섞은 음식의 스코빌 지수 
    		= 가장 맵지 않은 음식의 스코빌 지수 
    		+ (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
    	*/

    	// 1. 운선순위 큐 (제일 간단), 저장한 순서에 관계 없이 우선순위가 높은 것부터 꺼내게 됨.
    	Queue<Integer> pq = new LinkedList<Integer>();
    	/*
    	 * 기본 오름차순
    	 */
//    	Arrays.sort(scoville);
    	
    	/* 내림차순 String, Integer, Double 등과 같은 obj 타입의 배열은 Collections.reverseOrder() 이 가능하고 
    	 * 기본타입인 int, double, char, float 사용이 불가하므로
    	 * 기본타입의 배열을 obj를 상속하는 wrapper class 로 박싱해주면 역순정렬이 가능하다.
    	 * Integer[] tmp = Arrays.stream(scoville).boxed().toArray(Intger[]::new); 
    	*/
    	
//    	Integer[] tmp = Arrays.stream(scoville).boxed().toArray(Integer[]::new);
//    	Arrays.sort(tmp, Collections.reverseOrder());
    	
    	for (int i : scoville) {
    		pq.add(i);
    	}
    	
    	int answer = 0;
    	while(pq.peek() < K) {
    		if(pq.size() == 1) return -1; // 다 쳐 했는데도 K에도 못미치면 -1 
    		answer++;
    		int new_scoville = pq.poll() + (pq.poll() * 2);
    		pq.add(new_scoville);
    	}
    	
    	/////////////////////////////////////////////////////////////
    	// 2. 힙정렬
//    	
//    	// 가장 마지막 노드의 부모 IDX
//    	int parentIdx = getParent(size -1) ;
//    	
//    	// 최대힙 만들기(역for문)
//    	for (int i = parentIdx; i >= 0; i--) {
//			heapify(scoville, i, size -1);
//		}
//    	for (int i : scoville) {
//    		System.out.print(i);
//		}
//    	System.out.println();
//    	
//    	//정렬 (최대 힙을 만들었으므로 root 가 가장 큰값임)
//    	//위와 같이 각 단계에서 root노드(최댓값)와 뒷 원소를 교환하고, 그 위치를 제외한 부분 트리에 대해 힙을 만족하도록 재구성하는 것이다.
//    	for (int i = size-1; i > 0; i--) {
//    		swap(scoville, 0, i);
//			heapify(scoville, 0, i - 1);
//		}
    	/////////////////////////////////////////////////////////////

    	
    	
        return answer;
    }
    
    // 스코빌 지수 계산
    int calc(int first, int second) {
    	return first + (second * 2);
    }
    
	
    
    	 
	// 부모 인덱스를 얻는 함수
	private int getParent(int child) {
	    return (child - 1) / 2;  // (n-1)/2 외워라 트리에서의 부모노드
	}
 
	// 두 인덱스의 원소를 교환하는 함수
	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
 
	// 최대 힙 만들기 (heapify==sift-sown) 최대 힙을 만드는 함수
	private void heapify(int[] a, int parentIdx, int lastIdx) {
		
		/*
		 * 현재 트리에서 부모 노드의 자식노드 인덱스를 각각 구해준다.
		 * 현재 부모 인덱스를 가장 큰 값을 갖고있다고 가정한다.
		 */
		int leftChildIdx = 2 * parentIdx + 1;
		int rightChildIdx = 2 * parentIdx + 2;
		int largestIdx = parentIdx;
		
		/*
		 *  left child node와 비교
		 *  
		 *  자식노드 인덱스가 끝의 원소 인덱스를 넘어가지 않으면서
		 *  현재 가장 큰 인덱스보다 왼쪽 자식노드의 값이 더 클경우
		 *  가장 큰 인덱스를 가리키는 largestIdx를 왼쪽 자식노드인덱스로 바꿔준다.
		 *  
		 */
		if(leftChildIdx < lastIdx && a[largestIdx] < a[leftChildIdx]) {
			largestIdx = leftChildIdx;
		}
		
		/*
		 *  left right node와 비교
		 *  
		 *  자식노드 인덱스가 끝의 원소 인덱스를 넘어가지 않으면서
		 *  현재 가장 큰 인덱스보다 오른쪽 자식노드의 값이 더 클경우
		 *  가장 큰 인덱스를 가리키는 largestIdx를 오른쪽 자식노드인덱스로 바꿔준다.
		 *  
		 */
		if(rightChildIdx < lastIdx && a[largestIdx] < a[rightChildIdx]) {
			largestIdx = rightChildIdx;
		}
		
		/*
		 * largestIdx 와 부모노드가 같지 않다는 것은
		 * 위 자식노드 비교 과정에서 현재 부모노드보다 큰 노드가 존재한다는 뜻이다.
		 * 그럴 경우 해당 자식 노드와 부모노드를 교환해주고,
		 * 교환 된 자식노드를 부모노드로 삼은 서브트리를 검사하도록 재귀 호출 한다.
		 */
		if(parentIdx != largestIdx) {
			swap(a, largestIdx, parentIdx);
			heapify(a, largestIdx, lastIdx);
		}
     
    }
	
    // 간단한 우선순위 큐 (제일 간단하네 메모리만 충분하다면)
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
