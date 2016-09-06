package hackerrank.contest.misc;

import java.util.Scanner;

/**
 * Created by jeremy on 06/09/16.
 */
public class Staircase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 1 ; i <=N; i++) {
            for (int j = 1; j <= N-i ; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i ; k++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
