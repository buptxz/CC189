import java.util.ArrayList;
import java.util.HashSet;
/**
 * Created by xiong on 11/17/2016.
 */
public class Answer {
    public static int GRID_SIZE = 8;

    public static void clear(Integer[] columns) {
        for (int i = 0; i < GRID_SIZE; i++) {
            columns[i] = -1;
        }
    }

    private static void drawLine() {
        StringBuilder line = new StringBuilder();
        for (int i=0;i<GRID_SIZE*2+1;i++)
            line.append('-');
        System.out.println(line.toString());
    }

    public static void printBoards(ArrayList<Integer[]> boards) {
        for (int i = 0; i < boards.size(); i++) {
            Integer[] board = boards.get(i);
            printBoard(board);
        }
    }

    public static void printBoard(Integer[] columns) {
        drawLine();
        for(int i = 0; i < GRID_SIZE; i++){
            System.out.print("|");
            for (int j = 0; j < GRID_SIZE; j++){
                if (columns[i] == j) {
                    System.out.print("Q|");
                } else {
                    System.out.print(" |");
                }
            }
            System.out.print("\n");
            drawLine();
        }
        System.out.println("");
    }

    public static HashSet<Integer> checkValid(int row, Integer[] columns) {
        HashSet<Integer> valid = new HashSet<>();
        for (int i = 0; i < columns.length; i++) {
            valid.add(i);
        }
        int index = 0;
        while(index < row) {
            valid.remove(columns[index]);
            valid.remove(columns[index] + (row - index));
            valid.remove(columns[index] - (row - index));
            index++;
        }
        return valid;
    }

    public static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
        if (row < columns.length) {
            if (checkValid(row, columns) != null) {
                for (Integer validCol : checkValid(row, columns)) {
                    columns[row] = validCol;
                    placeQueens(row + 1, columns, results);
                }
            }
        } else {
            results.add(columns.clone());
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer[]> results = new ArrayList<Integer[]>();
        Integer[] columns = new Integer[GRID_SIZE];
        clear(columns);
        placeQueens(0, columns, results);
        printBoards(results);
        System.out.println(results.size());
    }
}
