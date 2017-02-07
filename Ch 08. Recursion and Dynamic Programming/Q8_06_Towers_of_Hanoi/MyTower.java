/**
 * Created by xiong on 11/15/2016.
 */
import java.util.Stack;

public class MyTower {
    private Stack<Integer> disks;
    private int index;
    public MyTower(int i) {
        disks = new Stack<>();
        index = i;
    }

    public int index() {return index;}

    public void add(int data) {
        if (!disks.isEmpty() && disks.peek() <= data) {
            System.out.println("Error placing disk " + data);
        }
        disks.push(data);
    }

    public void moveDisks(int n, MyTower destination, MyTower buffer) {
        if (n == 1) {
            destination.add(disks.pop());
        } else {
            moveDisks(n - 1, buffer, destination);
            moveTopTo(destination);
//            destination.add(disks.pop());

            // I still don't figure out thy this doesn't work, or how to make this method work.
//            disks = buffer.disks;
//            buffer.disks = new Stack<>();
            buffer.moveDisks(n - 1, destination, this);
        }
//        if (n > 0) {
//            moveDisks(n - 1, buffer, destination);
//            moveTopTo(destination);
//            buffer.moveDisks(n - 1, destination, this);
//        }
    }

    public void moveTopTo(MyTower t) {
        int top = disks.pop();
        t.add(top);
    }

    public void print() {
        System.out.println("Contents of Tower " + index() + ": " + disks.toString());
    }

    public static void main(String[] args) {
        // Set up code.
        int n = 5;
        MyTower[] towers = new MyTower[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new MyTower(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            towers[0].add(i);
        }

        // Copy and paste output into a .XML file and open it with internet explorer.
        towers[0].print();
        towers[0].moveDisks(n, towers[2], towers[1]);
        towers[2].print();
    }

}
