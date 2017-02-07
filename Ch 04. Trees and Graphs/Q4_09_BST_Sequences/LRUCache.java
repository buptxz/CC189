/**
 * Created by xiong on 11/3/2016.
 */
import java.util.HashMap;
//public class LRUCache {
//    private class Node {
//        int key;
//        int val;
//        Node next;
//        Node pre;
//        public Node(int key, int val) {
//            this.key = key;
//            this.val = val;
//        }
//    }
//
//    private Node head;
//    private int maxCapacity;
//    private int size;
//
//    HashMap<Integer, Node> map;
//
//    public LRUCache(int capacity) {
//        maxCapacity = capacity;
//        map = new HashMap<>();
//        head = null;
//        size = 0;
//    }
//
//    public int get(int key) {
////        if (head == null) return -1;
////        Node existNode = checkExist(key);
////        if (existNode != null) {
////            moveTail(existNode);
////            return existNode.val;
////        }
//        if (map.containsKey(key)) return map.get(key).val;
//        return -1;
//    }
//
//    public void set(int key, int value) {
//        if (maxCapacity == 0)
//            return;
//        //check existing node
////        Node existNode = checkExist(key);
//        if (map.containsKey(key)) {
//            Node existNode = map.get(key);
//            existNode.val = value;
//            map.put(key, existNode);
//            moveTail(existNode);
//        } else {
//            if (size == maxCapacity) {
//                removeHead();
//            }
//            addTail(key, value);
//        }
//    }
//
//    private void removeHead() {
//        map.remove(head.key);
//        if (head != null){
//            size--;
//            if (head == tail) {
//
//            }
//            if (head.next != null) head.next.pre = null;
//            head = head.next;
//        }
//    }
//
//    private void addTail(int key, int value) {
//        Node newNode = new Node(key, value);
//        if (head == null) {
//            head = newNode;
//        } else {
//            Node curr = head;
//            while (curr.next != null) {
//                curr = curr.next;
//            }
//
//            curr.next = newNode;
//            newNode.pre = curr;
//        }
//        size++;
//    }
//
//    private void moveTail(Node node) {
//        if (node.next != null) {
//
//            node.next.pre = node.pre;
//            if (node.pre != null) {
//                node.pre.next = node.next;
//            } else {
//                head = node.next;
//            }
//
//            Node curr = head;
//            while (curr.next != null) {
//                curr = curr.next;
//            }
//
//            curr.next = node;
//            node.next = null;
//            node.pre = curr;
//        }
//    }
//
//    private Node checkExist(int key) {
//        if (head == null) return null;
//        Node curr = head;
//
//        while (curr != null) {
//            if (curr.key == key) {
//                return curr;
//            }
//            curr = curr.next;
//        }
//        return null;
//
//    }
//
//    public static void main(String[] args) {
//        LRUCache test = new LRUCache(2);
//        test.set(2, 2);
//        test.set(1, 1);
//        System.out.println(test.get(2));
//        test.set(4, 4);
//        System.out.println(test.get(1));
//        System.out.println(test.get(2));
//
//    }
//}


public class LRUCache {
    private class Node {
        int key;
        int val;
        Node next;
        Node pre;
        private Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int maxCapacity;
    private int size;
    private HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        maxCapacity = capacity;
        head = null;
        tail = null;
        size = 0;
        map = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        // if (head == null) return -1;
        // Node existNode = checkExist(key);
        // if (existNode != null)
        //     moveTail(existNode);
        // return existNode != null ? existNode.val : -1;
        if (map.containsKey(key)) {
            Node existNode = map.get(key);
            moveTail(existNode);
            return map.get(key).val;
        }

        return -1;
    }

    public void set(int key, int value) {
        if (maxCapacity == 0)
            return;
        //check existing node
        // Node existNode = checkExist(key);
        if (map.containsKey(key)) {
            Node existNode = map.get(key);
            existNode.val = value;
            map.put(key, existNode);
            moveTail(existNode);
        } else {
            if (size >= maxCapacity) {
                removeHead();
            }
            addTail(key, value);
        }
    }

    private void removeHead() {
        map.remove(head.key);
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            if (head != null)
                head.pre = null;
        }
    }

    private void addTail(int key, int value) {
        Node newNode = new Node(key, value);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            newNode.pre = tail;
            tail = newNode;
        }
        map.put(key, tail);
        size++;
    }

    private void moveTail(Node node) {
        if (node.next != null) {
            node.next.pre = node.pre;
            if (node.pre != null) {
                node.pre.next = node.next;
            }

            if (node == head)
                head = head.next;

            tail.next = node;
            node.next = null;
            node.pre = tail;
            tail = node;
        }
    }

    private Node checkExist(int key) {
        Node curr = head;
        Node res = null;

        while (curr != null) {
            if (curr.key == key) {
                res = curr;
                break;
            }
            curr = curr.next;
        }
        return res;
    }


    public static void main(String[] args) {
        LRUCache test = new LRUCache(2);
        test.set(2, 2);
        test.set(1, 1);
        System.out.println(test.get(2));
        test.set(4, 4);
        System.out.println(test.get(1));
        System.out.println(test.get(2));

    }
}