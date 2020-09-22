public class HeapNode {
    String data;
    int freq;
    HeapNode left;
    HeapNode right;
    int height;

    HeapNode(String data, int freq){
        this.data=data;
        this.freq=freq;
        left=null;
        right=null;
    }

    public void setLeft(HeapNode left){
        this.left=left;
    }

    public void setRight(HeapNode right){
        this.right=right;
    }
}
