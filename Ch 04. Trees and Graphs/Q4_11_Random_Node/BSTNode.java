/**
 * Created by xiong on 11/7/2016.
 */
package Q4_11_Random_Node;

import java.util.Random;

public class BSTNode {
    public int data;
    public BSTNode left;
    public BSTNode right;
    public int size;

    public BSTNode(int data) {
        this.data = data;
        this.size = 1;
    }

    public void insert(int val) {
        if (val <= this.data) {
            if (this.left == null) {
                this.left = new BSTNode(val);
            } else {
                this.left.insert(val);
            }
        } else {
            if (this.right == null) {
                this.right = new BSTNode(val);
            } else {
                this.right.insert(val);
            }
        }
        this.size++;
    }

    public BSTNode find(int val) {
        if (val == this.data) {
            return this;
        } else if (val < this.data) {
            if (this.left == null) return null;
            return this.left.find(val);
        } else {
            if (this.right == null) return null;
            return this.right.find(val);
        }
    }

    public int size() {
        return this.size;
    }
    
    public BSTNode getRandomNode() {
        Random rnd = new Random();
        int randomNum = rnd.nextInt(this.size);
        if (randomNum == 0) {
            return this;
        } else if (this.left != null && randomNum > 0 && randomNum <= this.left.size) {
            return this.left.getRandomNode();
        } else if (this.right != null) {
            return this.right.getRandomNode();
        } else {
            return null;
        }
    }
}
