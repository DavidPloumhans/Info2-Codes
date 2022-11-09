import java.util.ArrayList;
import java.util.List;
import java.util.Stack; // this should give you a hint for the iterative version

public class Traversal {

    public static void recursiveInorder(Node root, List<Integer> res) {
        /*
        if (root.left != null && root.right != null) {
            if (root.left.isLeaf() && root.right.isLeaf()) {
                res.add(root.left.val);
                res.add(root.val);
                res.add(root.right.val);
            }
            else if (root.left.isLeaf()) {
                res.add(root.left.val);
                res.add(root.val);
                recursiveInorder(root.right, res);
            } else if (root.right.isLeaf()){
                res.add(root.val);
                res.add(root.right.val);
                recursiveInorder(root.left, res);
            } else { // aucun n'est leaf
                recursiveInorder(root.left, res);
                res.add(root.val);
                recursiveInorder(root.right, res);
            }
        }
        else if (root.right != null) {
            res.add(root.val);
            if (root.right.isLeaf()) {
                res.add(root.right.val);
            } else {
                recursiveInorder(root.right, res);
            }
        } else if (root.left != null) {
            if (root.left.isLeaf()) {
                res.add(root.left.val);
                res.add(root.val);
            } else {
                recursiveInorder(root.left, res);
            }
        }*/
        if(root != null){
            recursiveInorder(root.left, res);
            res.add(root.val);
            recursiveInorder(root.right, res);
        }
    }


    public static void iterativeInorder(Node root, List<Integer> res){
        Stack<Node> previous = new Stack<>();  // yeah baby, using my skills
        previous.add(root);
        while (previous.size() > 0 && root != null) {
            if (root.left != null) {
                previous.push(root);
                root = root.left;
            } else if (root.right != null){
                res.add(root.val);
                root = root.right;
            }
            else {
                res.add(root.val);
                res.add(previous.peek().val);
                root = previous.pop().right;
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(5);
        root.right.right = new Node(9);
        root.right.right.left = new Node(8);
        List<Integer> list = new ArrayList<Integer>(10);
        iterativeInorder(root, list);
        for (int number : list) {
            System.out.println(number);
        }
    }
}
