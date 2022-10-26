public class Node {

    public int val;
    public Node left;
    public Node right;

    public Node(int val){
        this.val = val;
    }

    public boolean isLeaf(){
        return this.left == null && this.right == null;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Node)) {
            return false;
        }
        Node n = (Node)o;
        if (this.isLeaf() && n.isLeaf()) {
            return this.val == n.val;
        } else if (!(this.isLeaf()) && n.isLeaf()) {
            return false;
        }
        else if (this.isLeaf() && !(n.isLeaf())) {
            return false;
        }
        else if (this.left == null) {
            return this.right.equals(n.right);
        }
        else if (this.right == null) {
            return this.left.equals(n.left);
        }
        else {
            return this.left.equals(n.left) && this.right.equals(n.right);
        }
    }    
}
