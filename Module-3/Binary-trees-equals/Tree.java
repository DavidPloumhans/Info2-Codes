public class Tree {
    public Node root;

    public Tree(Node root) {
        this.root = root;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tree)) {
            return false;
        }
        if (this.root == null && ((Tree) o).root == null){
            return true;
        }
        if (this.root == null) {
            return false;
        }
        if (this.root.equals(((Tree) o).root)){
            return true;
        }else {
            return false;
        }

    }
}
