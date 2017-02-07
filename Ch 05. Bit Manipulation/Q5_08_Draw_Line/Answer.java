/**
 * Created by xiong on 11/8/2016.
 */
public class Answer {

    public static int computeByteNum(int width, int x, int y) {
        return (width * y + x) / 8;
    }

    public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int numOfByte = screen.length;
        int height = numOfByte / (width / 8);
        if (x1 > x2 || x2 > width - 1 || y > height - 1) return;
        int start = y * width / 8 + x1 / 8;
        int end = y * width /8 + x2 / 8;
        if (start == end) {
            screen[start] |= (byte) ((0xFF >> (x1 % 8)) & (0xFF << (7 - x2 % 8)));
        } else {
            screen[start] |= (byte) (0xFF >> (x1 % 8));
            screen[end] |= (byte) (0xFF << (7 - x2 % 8));
            for (int i = start + 1; i < end; i++) {
                screen[i] = (byte)0xFF;
            }
        }

    }

    public static void printByte(byte b) {
        for (int i = 7; i >= 0; i--) {
            char c = ((b >> i) & 1) == 1 ? '1' : '_';
            System.out.print(c);
        }
    }

    public static void printScreen(byte[] screen, int width) {
        int height = screen.length * 8 / width;
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c+=8) {
                byte b = screen[computeByteNum(width, c, r)];
                printByte(b);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int width = 8 * 2;
        int height = 2;
        for (int r = 0; r < height; r++) {
            for (int c1 = 0; c1 < width; c1++) {
                for (int c2 = c1; c2 < width; c2++) {
                    byte[] screen = new byte[width * height / 8];

                    System.out.println("row: " + r + ": " + c1 + " -> " + c2);
                    drawLine(screen, width, c1, c2, r);
                    printScreen(screen, width);
                    System.out.println("\n\n");
                }
            }
        }

    }
}
