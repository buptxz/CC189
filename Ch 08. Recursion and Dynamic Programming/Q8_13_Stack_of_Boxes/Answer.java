package Q8_13_Stack_of_Boxes;

import java.util.ArrayList;

/**
 * Created by xiong on 11/17/2016.
 */
public class Answer {

    public static int createStack(ArrayList<Box> boxes) {
        int height = 0;
        if (boxes.isEmpty()) {
            return height;
        }
        for (int index = 0; index < boxes.size(); index++) {
            ArrayList<Box> smallBoxes = new ArrayList<Box>();
            for (int i = 0; i < boxes.size(); i++) {
                if (i != index && boxes.get(index).canBeUnder(boxes.get(i))) {
                    smallBoxes.add(boxes.get(i));
                }
            }
            int subHeight = createStack(smallBoxes);
            if (subHeight + boxes.get(index).height > height){
                height = subHeight + boxes.get(index).height;
            }
        }
        return height;
    }

    public static void main(String[] args) {
        Box[] boxList = { new Box(6, 4, 4), new Box(8, 6, 2), new Box(5, 3, 3), new Box(7, 8, 3), new Box(4, 2, 2), new Box(9, 7, 3)};
        ArrayList<Box> boxes = new ArrayList<Box>();
        for (Box b : boxList) {
            boxes.add(b);
        }

        int height = createStack(boxes);
        System.out.println(height);
    }
}
