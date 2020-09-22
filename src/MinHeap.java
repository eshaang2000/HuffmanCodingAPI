//public class MinHeap {
//
//    private HeapNode[] Heap;
//    private int size;
//    private int maxsize;
//
//    private static final int FRONT = 1;
//
//    public MinHeap(int maxsize)
//    {
//        this.maxsize = maxsize;
//        this.size = 0;
//        Heap = new HeapNode[this.maxsize + 1];
//        Heap[0]=new HeapNode(null, 0);
//        Heap[0].freq = Integer.MIN_VALUE;
//    }
//
//    // Function to return the position of
//    // the parent for the node currently
//    // at pos
//    private int parent(int pos)
//    {
//        return pos / 2;
//    }
//
//    // Function to return the position of the
//    // left child for the node currently at pos
//    private int leftChild(int pos)
//    {
//        return (2 * pos);
//    }
//
//    // Function to return the position of
//    // the right child for the node currently
//    // at pos
//    private int rightChild(int pos)
//    {
//        return (2 * pos) + 1;
//    }
//
//    // Function that returns true if the passed
//    // node is a leaf node
//    private boolean isLeaf(int pos)
//    {
//        if (pos >= (size / 2) && pos <= size) {
//            return true;
//        }
//        return false;
//    }
//
//    // Function to swap two nodes of the heap
//    private void swap(int fpos, int spos)
//    {
//        HeapNode tmp;
//        tmp = Heap[fpos];
//        Heap[fpos] = Heap[spos];
//        Heap[spos] = tmp;
//    }
//
//    // Function to heapify the node at pos
//    private void minHeapify(int pos)
//    {
//
//        // If the node is a non-leaf node and greater
//        // than any of its child
//        if (!isLeaf(pos)) {
//            if (Heap[pos].freq > Heap[leftChild(pos)].freq
//                    || Heap[pos].freq > Heap[rightChild(pos)].freq) {
//
//                // Swap with the left child and heapify
//                // the left child
//                if (Heap[leftChild(pos)].freq < Heap[rightChild(pos)].freq) {
//                    swap(pos, leftChild(pos));
//                    minHeapify(leftChild(pos));
//                }
//
//                // Swap with the right child and heapify
//                // the right child
//                else {
//                    swap(pos, rightChild(pos));
//                    minHeapify(rightChild(pos));
//                }
//            }
//        }
//    }
//
//    // Function to insert a node into the heap
//    public void insert(HeapNode element)
//    {
//        if (size >= maxsize) {
//            return;
//        }
//        Heap[++size] = element;
//        int current = size;
//
//        while (Heap[current].freq < Heap[parent(current)].freq) {
//            swap(current, parent(current));
//            current = parent(current);
//        }
//    }
//
//    // Function to print the contents of the heap
//    public void print()
//    {
//        for (int i = 1; i <= size / 2; i++) {
//            System.out.print(" PARENT : " + Heap[i].data
//                    + " LEFT CHILD : " + Heap[2 * i].data
//                    + " RIGHT CHILD :" + Heap[2 * i + 1].data);
//            System.out.println();
//        }
//    }
//
//    // Function to build the min heap using
//    // the minHeapify
//    public void minHeap()
//    {
//        for (int pos = (size / 2); pos >= 1; pos--) {
//            minHeapify(pos);
//        }
//    }
//
//    // Function to remove and return the minimum
//    // element from the heap
//    public HeapNode remove()
//    {
//        HeapNode popped = Heap[FRONT];
//        Heap[FRONT] = Heap[size--];
//        minHeapify(FRONT);
//        return popped;
//    }
//    //fucntion to generate heapNodes
//    public HeapNode make(String data, int freq){
//        HeapNode ans = new HeapNode(data, freq);
//        return ans;
//    }
//    // Driver code
//    public static void main(String[] arg)
//    {
//        System.out.println("The Min Heap is ");
//        MinHeap minHeap = new MinHeap(15);
////        minHeap.insert(5);
////        minHeap.insert(3);
////        minHeap.insert(17);
////        minHeap.insert(10);
////        minHeap.insert(84);
////        minHeap.insert(19);
////        minHeap.insert(6);
////        minHeap.insert(22);
////        minHeap.insert(9);
//        HeapNode ans = new HeapNode("Eshaan", 5);
//        minHeap.insert(ans);
//        ans = new HeapNode("Garrett", 3);
//        minHeap.insert(ans);
//        ans = new HeapNode("Kailash", 8);
//        minHeap.insert(ans);
//        ans = new HeapNode("Cole", 7);
//        minHeap.insert(ans);
//        ans = new HeapNode("Vrathan", 2);
//        minHeap.insert(ans);
//
//        minHeap.minHeap();
//
//        minHeap.print();
//        System.out.println("The Min val is " + minHeap.remove().freq);
//        minHeap.minHeap();
//        System.out.println("The Min val is " + minHeap.remove().freq);
//        minHeap.minHeap();
//        System.out.println("The Min val is " + minHeap.remove().freq);
//        minHeap.minHeap();
//        System.out.println("The Min val is " + minHeap.remove().freq);
//        minHeap.minHeap();
//        System.out.println("The Min val is " + minHeap.remove().freq);
////        System.out.println("The Min val is " + minHeap.remove());
//    }
//}