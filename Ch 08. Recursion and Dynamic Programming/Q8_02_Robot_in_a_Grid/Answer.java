/**
 * Created by xiong on 11/12/2016.
 */
package Q8_02_Robot_in_a_Grid;

import java.util.ArrayList;
import java.util.HashSet;

public class Answer {

    public static ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null) return null;
        ArrayList<Point> path = new ArrayList<Point>();
        HashSet<Point> failedPoints = new HashSet<Point>();
        if (getPathHelper(maze, path, maze.length - 1, maze[0].length - 1, failedPoints)) {
            return path;
        }
        return null;
    }

    public static boolean getPathHelper(boolean[][] maze, ArrayList<Point> path, int i, int j, HashSet<Point> failedPoints) {
        if (i < 0 || j < 0 || !maze[i][j] || failedPoints.contains(new Point(i, j))) return false;
        if ((i == 0 && j == 0) || getPathHelper(maze, path, i, j - 1, failedPoints) || getPathHelper(maze, path, i - 1, j, failedPoints)) {
            path.add(new Point(i, j));
            return true;
        }
        failedPoints.add(new Point(i, j));
        return false;
    }
}
