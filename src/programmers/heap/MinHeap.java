package programmers.heap;

import java.util.ArrayList;

public class MinHeap {
    private ArrayList<Integer> heap;

    //�ּ��� ������
    public MinHeap() {
        heap = new ArrayList<Integer>();
        heap.add(0); // 0��° �ε����� ��� ����
    }

    //����
    public void insert(int val) {
        heap.add(val);
        int p = heap.size()-1;    //p�� ���� ������ ����� �ε��� ����
        while(p>1 && heap.get(p/2)>heap.get(p)) {
            //���� ������ ����� ��ġ�� 1 �ʰ��̰� �θ� �ڽĺ��� ũ�� ���� ->���� ������ ����� ��ġ�� ��Ʈ���� ���ų� ���� ������ ��尡 �θ𺸴� Ŭ������ ����
            int tmp = heap.get(p/2);//�θ� ����� ��
            heap.set(p/2, val);
            heap.set(p, tmp);

            p /= 2;    //���� ������ ��尡 �� ���� ��������� �ε��� �θ� ��� �ε��� ������ ����
        }
    }
    //����
    public int delete() {
        //�� �� ��������� 0����
        if(heap.size()-1 < 1) {
            return 0;
        }

        //������ ���, ��Ʈ ���
        int deleteitem = heap.get(1);

        //������ ��带root�� �����ϰ� ������ ��� ����
        heap.set(1,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int pos = 1; //��Ʈ�� ���� ������ ����� �ε��� ����

        //pos*2�� �����ڽ��� �ε��� ��, �ڽ��� �ε��� ���� ���� ������ ������ ũ�ٴ°��� ���̻� ������ ��ġ�� ����ٴ¶� 
        while((pos*2)<heap.size()) {
            int min = heap.get(pos*2);//���� �ڽ��� ��
            int minPos = pos*2;// ���� �ڽ��� �ε��� ��

            //������ �ڽ��� �ε����� ������� �۰� ���� ���� �� ������ ������ �ڽ��� �θ�� �ٲ��� �ڽ����� ����
            if(((pos*2+1)<heap.size()) && min > heap.get(pos*2+1)) {    
                min = heap.get(pos*2 +1);
                minPos = pos*2 +1;
            }

            //�θ� �� ������ �׸�
            if(min > heap.get(pos))
                break;

            //�θ� �ڽ� ��ȯ
            int tmp = heap.get(pos);
            heap.set(pos,heap.get(minPos));
            heap.set(minPos, tmp);
            pos = minPos;
        }

        return deleteitem;
    }

}