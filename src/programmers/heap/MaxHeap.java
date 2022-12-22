package programmers.heap;

import java.util.ArrayList;

public class MaxHeap {
    private ArrayList<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<Integer>();
        heap.add(0); //ù��° �ε����� ������� ����
    }

    //����
    public void insert(int val) {
        //�� ������ ��ġ�� ����
        heap.add(val);

        int  p = heap.size()-1; //���� ���� ����� �ε��� ��ġ ����
        //��Ʈ���� �̵� �ڽ��� �� ũ�� ��ȯ
        while(p>1 && heap.get(p)> heap.get(p/2)) {
            int tmp = heap.get(p/2);
            heap.set(p/2, heap.get(p));
            heap.set(p, tmp);

            p /= 2;
        }
    }
    //����
    public int delete() {
        //�� �� ��������� 0����
        if(heap.size()-1 < 1) {
            return 0;
        }

        //������ ��Ʈ ��� �� ����
        int deleteitem = heap.get(1);

        //�� ������ �ڽ� ��Ʈ�� �ְ� ������ �� ����
        heap.set(1,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        //��Ʈ�� ���� ���� ����� �ε��� ����
        int pos = 1;
        while((pos*2)<heap.size()) {

            int max = heap.get(pos*2);
            int maxPos = pos*2;

            //������ �ڽ��� �����ϰ� ������ �ڽ��� ���� �ڽĺ��� Ŭ�� �ٲ� �ڽ� ���������� ����
            if((pos*2 +1)<heap.size() && max < heap.get(pos*2+1)) {
                max = heap.get(pos*2+1);
                maxPos = pos*2+1;
            }

            //�θ� �� ũ�� ��
            if(heap.get(pos) > max){
                break;
            }

            //�ڽ��� �� ũ�� ��ȯ
            int tmp = heap.get(pos);
            heap.set(pos, max);
            heap.set(maxPos, tmp);
            pos = maxPos;
        }
        return deleteitem;
    }
}