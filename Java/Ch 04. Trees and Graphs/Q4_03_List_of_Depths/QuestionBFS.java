package Q4_03_List_of_Depths;

import CtCILibrary.*;
import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class QuestionBFS {

//	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
//		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
//
//		/* "Visit" the root */
//		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
//		if (root != null) {
//			current.add(root);
//		}
//
//		while (current.size() > 0) {
//			result.add(current); // Add previous level
//			LinkedList<TreeNode> parents = current; // Go to next level
//			current = new LinkedList<TreeNode>();
//			for (TreeNode parent : parents) {
//				/* Visit the children */
//				if (parent.left != null) {
//					current.add(parent.left);
//				}
//				if (parent.right != null) {
//					current.add(parent.right);
//				}
//			}
//		}
//
//		return result;
//	}

	// Method createLevelLinkedList by Zheng
//	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
//		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
//		ArrayList<Integer> levels = new ArrayList<>();
//		int sequence = 0;
//		LinkedList<TreeNode> treeNodeQueue = new LinkedList<>();
//		treeNodeQueue.add(root);
//		levels.add(0);
//		while (!treeNodeQueue.isEmpty()) {
//			TreeNode node = treeNodeQueue.remove();
//			if (lists.size() == levels.get(sequence)) {
//				lists.add(new LinkedList<TreeNode>());
//			}
//			lists.get(levels.get(sequence)).add(node);
//			if (node.left != null) {
//				treeNodeQueue.add(node.left);
//				levels.add(levels.get(sequence)+1);
//			}
//			if (node.right != null) {
//				treeNodeQueue.add(node.right);
//				levels.add(levels.get(sequence)+1);
//			}
//			sequence++;
//		}
//		return lists;
//	}

    // Modified method, it's the duplicate of the solution in the book
    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> currentNode = new LinkedList<>();
        currentNode.add(root);
        while (currentNode.size() != 0) {
            result.add(currentNode);
            LinkedList<TreeNode> temp = currentNode;
            currentNode = new LinkedList<>();
            for (TreeNode node:temp) {
                if (node.left != null) currentNode.add(node.left);
                if (node.right != null) currentNode.add(node.right);
            }
        }
        return result;
    }

	public static void printResult(ArrayList<LinkedList<TreeNode>> result){
		int depth = 0;
		for(LinkedList<TreeNode> entry : result) {
			Iterator<TreeNode> i = entry.listIterator();
			System.out.print("Link list at depth " + depth + ":");
			while(i.hasNext()){
				System.out.print(" " + ((TreeNode)i.next()).data);
			}
			System.out.println();
			depth++;
		}
	}
	

	public static void main(String[] args) {
		int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
		ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
		printResult(list);
	}

}
