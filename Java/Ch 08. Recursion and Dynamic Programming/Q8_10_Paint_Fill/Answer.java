/**
 * Created by xiong on 11/16/2016.
 */
public class Answer {

    public enum Color {
        Black, White, Red, Yellow, Green
    }

    public static String PrintColor(Color c) {
        switch(c) {
            case Black:
                return "B";
            case White:
                return "W";
            case Red:
                return "R";
            case Yellow:
                return "Y";
            case Green:
                return "G";
        }
        return "X";
    }

    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }

    public static void PrintScreen(Color[][] screen) {
        for (int r = 0; r < screen.length; r++) {
            for (int c = 0; c < screen[0].length; c++) {
                System.out.print(PrintColor(screen[r][c]));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int N = 10;
        Color[][] screen = new Color[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                screen[i][j] = Color.Black;
            }
        }
        for (int i = 0; i < 100; i++) {
            screen[randomInt(N)][randomInt(N)] = Color.Green;
        }
        PrintScreen(screen);
        PaintFill(screen, 2, 2, Color.White);
        System.out.println();
        PrintScreen(screen);
    }
    public static void PaintFill(Color[][] screen, int row, int col, Color newColor) {
        if (screen == null) return;
        Color oldColor = screen[row][col];
        PaintFill(screen, row, col, newColor, oldColor);
    }


    public static void PaintFill(Color[][] screen, int row, int col, Color newColor, Color oldColor) {
//        int height = screen.length;
//        int width = screen[0].length;
//        if (row < 0 || col < 0 || row >= height || col >= width) {
//            return;
//        }
        screen[row][col] = newColor;
        if (row > 0 && screen[row - 1][col] == oldColor) {
            PaintFill(screen, row - 1, col, newColor, oldColor);
        }
        if (col > 0 && screen[row][col - 1] == oldColor) {
            PaintFill(screen, row, col - 1, newColor, oldColor);
        }
        if (row < screen.length - 1 && screen[row + 1][col] == oldColor) {
            PaintFill(screen, row + 1, col, newColor, oldColor);
        }
        if (col < screen[0].length - 1 && screen[row][col + 1] == oldColor) {
            PaintFill(screen, row, col + 1, newColor, oldColor);
        }
    }
}
