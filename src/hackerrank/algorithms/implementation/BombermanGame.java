package hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class BombermanGame {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int rows = in.nextInt();
        int columns = in.nextInt();
        int nSeconds = in.nextInt();

        in.nextLine(); // consume rest of line

        boolean[][] initgrid = new boolean[rows][columns]; //true-> bomb present

        boolean[][] stateA = new boolean[rows][columns];
        for (boolean columnA[] : stateA) {
            Arrays.fill(columnA, true);
        }

        boolean[][] stateB = new boolean[rows][columns];
        for (boolean columnB[] : stateB) {
            Arrays.fill(columnB, true);
        }

        for (int r = 0; r < rows; r++) {
            String line = in.nextLine();
            for (int c = 0; c < columns; c++) {
                initgrid[r][c] = (line.charAt(c) == 'O');
                if (initgrid[r][c]) { //compute A from init state
                    stateA[r][c] = false;
                    if (r > 0) stateA[r - 1][c] = false;
                    if (r < rows - 1) stateA[r + 1][c] = false;
                    if (c > 0) stateA[r][c - 1] = false;
                    if (c < columns - 1) stateA[r][c + 1] = false;
                }
            }
        }


        //Compute stateB from stateA
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (stateA[r][c]) { //compute A from init state
                    stateB[r][c] = false;
                    if (r > 0) stateB[r - 1][c] = false;
                    if (r < rows - 1) stateB[r + 1][c] = false;
                    if (c > 0) stateB[r][c - 1] = false;
                    if (c < columns - 1) stateB[r][c + 1] = false;
                }
            }
        }


        if (nSeconds == 0 || nSeconds == 1) {
            printGrid(rows, columns, initgrid);
            return;
        }
        if (nSeconds % 2 == 0) {
            printFull(rows, columns);
            return;
        }
        if (nSeconds % 4 == 3) {
            printGrid(rows, columns, stateA);
            return;
        }
        if (nSeconds % 4 == 1) {
            printGrid(rows, columns, stateB);
            return;
        }
    }

    private static void printGrid(int rows, int columns, boolean[][] grid) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                System.out.print(grid[r][c] ? 'O' : '.');
            }
            System.out.println();
        }
    }


    private static void printFull(int rows, int columns) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                System.out.print('O');
            }
            System.out.println();
        }
    }


}
