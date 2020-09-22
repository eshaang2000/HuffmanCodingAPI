import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap {
    PriorityQueue<HeapNode> heap;


    public Heap(){
        heap = new PriorityQueue<HeapNode>(3, new HeapComparator());
    }

    public void add1(HeapNode a){
        heap.add(a);
    }

    public HeapNode getNode(){
        return heap.poll();
    }

    public void print(){
        while(!heap.isEmpty()){
            HeapNode temp= heap.poll();
            System.out.println(temp.freq+temp.data);
        }
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size(){
        return heap.size();
    }
}

class HeapComparator implements Comparator<HeapNode>{
    public int compare(HeapNode s1, HeapNode s2){
        if(s1.freq >= s2.freq)
            return 1;
        else if(s1.freq < s2.freq)
            return -1;
        return 0;
    }
}//class closed
