import java.util.Scanner;

public class Task1401 {
    static private int filler = 0;
    static private int[][] field;

    public static void fieldPrinter(){
        for (int[] hehe: field) {
            for (int he : hehe){
                System.out.print(he + " ");
            }
            System.out.print('\n');
        }
    }

    public static void fill (int size, int zerox, int zeroy, int startx, int starty){
        if (size == 2) {
            filler += 1;
            if (zerox == startx && zeroy == starty){
                field[startx + 1][starty] = filler;
                field[startx + 1][starty + 1] = filler;
                field[startx][starty + 1] = filler;
            }
            if (zerox == startx + 1 && zeroy == starty) {
                field[startx][starty] = filler;
                field[startx + 1][starty + 1] = filler;
                field[startx][starty + 1] = filler;
            }
            if (zerox == startx && zeroy == starty + 1) {
                field[startx][starty] = filler;
                field[startx + 1][starty + 1] = filler;
                field[startx + 1][starty] = filler;
            }
            if (zerox == startx + 1 && zeroy == starty + 1) {
                field[startx][starty] = filler;
                field[startx + 1][starty] = filler;
                field[startx][starty + 1] = filler;
            }
        }
        else {
            int leng = size / 2;

            if (zerox<startx+leng && zeroy<starty+leng) {
                filler += 1;
                field[startx + leng][starty + leng - 1] = filler;
                field[startx + leng - 1][starty + leng] = filler;
                field[startx + leng][starty + leng] = filler;
                fill(leng, zerox, zeroy, startx, starty);
                fill(leng, startx + leng, starty + leng - 1, startx + leng, starty);
                fill(leng, startx + leng - 1, starty + leng, startx, starty + leng);
                fill(leng, startx + leng, starty + leng, startx + leng, starty + leng);
            }
            else if (zerox<startx+leng && zeroy>=starty+leng) {
                filler += 1;
                field[startx + leng][starty + leng - 1] = filler;
                field[startx + leng - 1][starty + leng - 1] = filler;
                field[startx + leng][starty + leng] = filler;
                fill(leng, zerox, zeroy, startx, starty + leng);
                fill(leng, startx + leng, starty + leng - 1, startx + leng, starty);
                fill(leng, startx + leng - 1, starty + leng - 1, startx, starty);
                fill(leng, startx + leng, starty + leng, startx + leng, starty + leng);
            }
            else if (zerox>=startx+leng && zeroy<starty+leng) {
                filler += 1;
                field[startx + leng - 1][starty + leng - 1] = filler;
                field[startx + leng - 1][starty + leng] = filler;
                field[startx + leng][starty + leng] = filler;
                fill(leng, zerox, zeroy, startx + leng, starty);
                fill(leng, startx + leng - 1, starty + leng - 1, startx, starty);
                fill(leng, startx + leng - 1, starty + leng, startx, starty + leng);
                fill(leng, startx + leng, starty + leng, startx + leng, starty + leng);
            }
            else if (zerox>=startx+leng && zeroy>=starty+leng) {
                filler += 1;
                field[startx + leng][starty + leng - 1] = filler;
                field[startx + leng - 1][starty + leng - 1] = filler;
                field[startx + leng - 1][starty + leng] = filler;
                fill(leng, zerox, zeroy, startx + leng, starty + leng);
                fill(leng, startx + leng, starty + leng - 1, startx + leng, starty);
                fill(leng, startx + leng - 1, starty + leng - 1, startx, starty);
                fill(leng, startx + leng - 1, starty + leng, startx, starty + leng);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int x = scan.nextInt() - 1;
        int y = scan.nextInt() - 1;
        scan.close();
        field = new int[(int)Math.pow(2,n)][(int)Math.pow(2,n)];
        field[x][y] = 0;
        fill(field.length, x, y, 0, 0);
        fieldPrinter();
    }
}
