import java.io.FileNotFoundException;
import java.util.PriorityQueue;

public class Build {

    public static void main(String args[]) throws FileNotFoundException {
//        /*
//        * 1. first get all the things from the file and put it in the AVL tree
//        * 2. Put them in the heap*/
        Build obj = new Build();
        AVLTree tree = FileHandle.getFromFile("src/test.txt");
//////        tree.root - this is a heap node
//        tree.preOrder(tree.root);
//        PriorityQueue<HeapNode> heap = new PriorityQueue<HeapNode>(200, new HeapComparator());
        Heap heap = new Heap();
        tree.putHeap(tree.root, heap);
        HeapNode ans = build(heap);
//        tree.preOrder(ans);
        printCode(ans, "");
//        System.out.println(ans.freq);
//        heap.print();
    }

    public static HeapNode build (Heap heap){
        HeapNode a;// = heap.getNode();
        HeapNode b; //= heap.getNode();
        HeapNode ans = null; //= new HeapNode("", a.freq+b.freq);
//        HeapNode ans1;
//        ans.left=a;
//        ans.right=b;
//        heap.add1(ans);
//        heap.print();
//        a=heap.getNode();
//        b=heap.getNode();
////        heap.print();
//        ans = new HeapNode("", a.freq+b.freq);
//        ans.left=a;
//        ans.right=b;
//        heap.add1(ans);
//        a=heap.getNode();
//        b=heap.getNode();
////        heap.print();
//        ans = new HeapNode("", a.freq+b.freq);
//        ans.left=a;
//        ans.right=b;

//        heap.add1(ans);

//        heap.print();
        while(heap.size()>1){
            a=heap.getNode();
            b=heap.getNode();
//            System.out.println(a.data+a.freq);
//            System.out.println(b.data+b.freq);
            ans = new HeapNode("", a.freq+b.freq);
            ans.left=a;
            ans.right=b;
//            if(!heap.isEmpty()){
//                break;
//            }
            heap.add1(ans);
        }
//        ans
        return ans;
    }


    public static void printCode(HeapNode root, String s)
    {

        // base case; if the left and right are null
        // then its a leaf node and we print
        // the code s generated by traversing the tree.
        if (root.left == null || root.right== null) {
            // c is the character in the node
            System.out.println(root.data + ":" + s);
            return;
        }
        // if we go to left then add "0" to the code.
        // if we go to the right add"1" to the code.

        // recursive calls for left and
        // right sub-tree of the generated tree.
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

}