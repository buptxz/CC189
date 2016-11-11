package Q4_09_BST_Sequences;

import java.util.ArrayList;
import java.util.LinkedList;

import CtCILibrary.TreeNode;

/**
 * Created by xiong on 11/1/2016.
 */
public class Answer {
    public static ArrayList<LinkedList<Integer>> sequence(TreeNode node) {
        ArrayList<LinkedList<Integer>> arr = new ArrayList<>();
        if (node == null) {
            arr.add(new LinkedList<Integer>());
            return arr;
        }
        if (node.left == null && node.right == null) {
            LinkedList<Integer> list = new LinkedList<>();
            list.addLast(node.data);
            arr.add(list);
            return arr;
        }
        arr = weave(sequence(node.left), sequence(node.right));
        for (LinkedList<Integer> item : arr) {
            item.addFirst(node.data);
        }
        return arr;
    }

    public static ArrayList<LinkedList<Integer>> weave(ArrayList<LinkedList<Integer>> arr1,
                                                       ArrayList<LinkedList<Integer>> arr2) {
        if (arr1 == null || arr2 == null) {
            return arr1 == null ? arr2 : arr1;
        }
        ArrayList<LinkedList<Integer>> arr = new ArrayList<>();
        for (LinkedList<Integer> list1 : arr1) {
            for (LinkedList<Integer> list2 : arr2) {
                LinkedList<Integer> pre = new LinkedList<>();
                weaveHelper(arr, list1, list2, pre);
            }
        }
        return arr;
    }

    public static void weaveHelper(ArrayList<LinkedList<Integer>> arr,
                                   LinkedList<Integer> n1,
                                   LinkedList<Integer> n2,
                                   LinkedList<Integer> pre) {
        if (n1.isEmpty()) {
            while (!n2.isEmpty()) {
                pre.add(n2.removeFirst());
            }
            arr.add(pre);
        } else {
            int headFirst = n1.removeFirst();
            pre.add(headFirst);
            weaveHelper(arr, n1, n2, pre);
            pre.removeLast();
            n1.addFirst(headFirst);
        }
        if (n2.isEmpty()) {
            while (!n1.isEmpty()) {
                pre.add(n1.removeFirst());
            }
            arr.add(pre);
        } else {
            int headSecond = n2.removeFirst();
            pre.add(headSecond);
            weaveHelper(arr, n1, n2, pre);
            pre.removeLast();
            n2.addFirst(headSecond);
        }

    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(100);
        int[] array = {100, 50, 20, 75, 150, 120, 170};
        for (int a : array) {
            node.insertInOrder(a);
        }
        ArrayList<LinkedList<Integer>> allSeq = sequence(node);
        for (LinkedList<Integer> list : allSeq) {
            System.out.println(list);
        }
        System.out.println(allSeq.size());
    }
}
