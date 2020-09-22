import java.util.PriorityQueue;

class AVLTree {

    HeapNode root;
    int count;
    // A utility function to get the height of the tree

    AVLTree(){
        count = 0;
    }
    int height(HeapNode N) {
        if (N == null)
            return 0;

        return N.height;
    }

    // A utility function to get maximum of two integers 
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // A utility function to right rotate subtree rooted with y 
    // See the diagram given above. 
    HeapNode rightRotate(HeapNode y) {
        HeapNode x = y.left;
        HeapNode T2 = x.right;

        // Perform rotation 
        x.right = y;
        y.left = T2;

        // Update heights 
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root 
        return x;
    }

    // A utility function to left rotate subtree rooted with x 
    // See the diagram given above. 
    HeapNode leftRotate(HeapNode x) {
        HeapNode y = x.right;
        HeapNode T2 = y.left;

        // Perform rotation 
        y.left = x;
        x.right = T2;

        //  Update heights 
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root 
        return y;
    }

    // Get Balance factor of node N 
    int getBalance(HeapNode N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    HeapNode insert(HeapNode node, String data) {

        /* 1.  Perform the normal BST insertion */
        if (node == null)
            return (new HeapNode(data, 1));

        if (data.compareTo(node.data)<0)//
            node.left = insert(node.left, data);
        else if (data.compareTo(node.data)>0)
            node.right = insert(node.right, data);
        else {
            node.freq++;
            return node;
        }

        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left),
                height(node.right));
  
        /* 3. Get the balance factor of this ancestor 
              node to check whether this node became 
              unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there 
        // are 4 cases Left Left Case 
        if (balance > 1 && data.compareTo(node.data)<0)
            return rightRotate(node);

        // Right Right Case 
        if (balance < -1 && data.compareTo(node.data)>0)
            return leftRotate(node);

        // Left Right Case 
        if (balance > 1 && data.compareTo(node.data)>0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case 
        if (balance < -1 && data.compareTo(node.data)<0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    // A utility function to print preorder traversal 
    // of the tree. 
    // The function also prints height of every node 
    void preOrder(HeapNode node) {
        if (node != null) {
            preOrder(node.left);
            System.out.println(node.freq + " "+ node.data);
            preOrder(node.right);


        }
    }

    public void putHeap (HeapNode node, Heap heap){
        if(node != null){
            putHeap(node.left, heap);
            heap.add1(node);
            putHeap(node.right, heap);
        }
    }

//    public static void main(String[] args) {
//        AVLTree tree = new AVLTree();
//        Heap heap = new Heap();
//        /* Constructing tree given in the above figure */
//        tree.root = tree.insert(tree.root,  "Eshaan");
//        tree.root = tree.insert(tree.root,  "Eshaan");
//        tree.root = tree.insert(tree.root,  "Eshaan");
//        tree.root = tree.insert(tree.root,  "is");
//        tree.root = tree.insert(tree.root,  "is");
//        tree.root = tree.insert(tree.root,  "Fdsfsdfs");
//        tree.root = tree.insert(tree.root,  "fdsfsdf");
//        tree.putHeap(tree.root, heap);
//        heap.print();
////        tree.preOrder(tree.root);
//
//    }
}