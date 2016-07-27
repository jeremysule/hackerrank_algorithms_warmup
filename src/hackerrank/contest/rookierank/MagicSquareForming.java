package hackerrank.contest.rookierank;

import java.util.Scanner;

/**
 * Created by jeremy on 7/26/16.
 */
public class MagicSquareForming {
    public static final int[][] MAGIC_SQUARE1 = { {2 , 7 , 6 },
                                                    {9, 5, 1},
                                                    {4, 3, 8}
                                            };
    public static final int[][] MAGIC_SQUARE2 = { {6 , 1 , 8 },
            {7, 5, 3},
            {2, 9, 4}
    };
    public static final int[][] MAGIC_SQUARE3 = { {8 , 3 , 4 },
            {1, 5, 9},
            {6, 7, 2}
    };
    public static final int[][] MAGIC_SQUARE4 = { {4 , 9 , 2 },
            {3, 5, 7},
            {8, 1, 6}
    };

    public static final int[][] MAGIC_SQUARE5 = { {4 , 3 , 8 },
            {9, 5, 1},
            {2, 7, 6}
    };

    public static final int[][] MAGIC_SQUARE6 = { {6 , 7 , 2 },
            {1, 5, 9},
            {8, 3, 4}
    };
    public static final int[][] MAGIC_SQUARE7 = { {2 , 9 , 4 },
            {7, 5, 3},
            {6, 1, 8}
    };

    public static final int[][] MAGIC_SQUARE8 = { {8 , 1 , 6 },
            {3, 5, 7},
            {4, 9, 2}
    };

    public static int[][][] ALL_MAGIC = {MAGIC_SQUARE1, MAGIC_SQUARE2, MAGIC_SQUARE3, MAGIC_SQUARE4,
            MAGIC_SQUARE5, MAGIC_SQUARE6, MAGIC_SQUARE7, MAGIC_SQUARE8
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final int[][] matrix1 = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix1[i][j] = in.nextInt();
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int[][] magic:  ALL_MAGIC
             ) {
            int cost = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    cost += Math.abs(matrix1[i][j]-magic[i][j]);
                }
            }
            minCost = Math.min(minCost,cost);

        }

        System.out.println(minCost);

    }
}
