/**
 * Created by xiong on 11/7/2016.
 */
package Q4_11_Random_Node;

import java.util.Random;

public class BST {
    BSTNode root;

    public BST() {};

    public BST(BSTNode root){
        this.root = root;
    }

    public void insertInOrder(int val) {
        if (root == null) {
            root = new BSTNode(val);
        } else {
            root.insert(val);
        }
    }

    public BSTNode getRandomNode() {
        if (root == null) return null;
        return root.getRandomNode();
    }

    public int size() {
        if (root == null) return 0;
        return root.size();
    }

}
