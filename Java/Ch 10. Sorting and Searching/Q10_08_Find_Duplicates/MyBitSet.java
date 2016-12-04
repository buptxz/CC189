/**
 * Created by xiong on 12/3/2016.
 */
package Q10_08_Find_Duplicates;

public class MyBitSet {
    public int size;
    public boolean[] map;

    public MyBitSet(int size) {
        this.size = size;
        this.map = new boolean[size];
    }

    public boolean get(int index) {
        return map[index];
    }

    public void set(int index) {
        map[index] = true;
    }
}
