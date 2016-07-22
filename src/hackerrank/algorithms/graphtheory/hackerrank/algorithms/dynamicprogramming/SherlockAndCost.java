package hackerrank.algorithms.graphtheory.hackerrank.algorithms.dynamicprogramming;

import java.util.Scanner;

public class SherlockAndCost {

    //TODO: not working, check algorithm

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int numberOfTests = in.nextInt();

        for (int t = 0; t < numberOfTests; t++) {
            // Load data
            int arraySizeN = in.nextInt();
            int[] arrayB = new int[arraySizeN];

            for (int i = 0; i < arraySizeN; i++) {
                arrayB[i] = in.nextInt();
            }

            //compute max
            int maxSum = 0;
            for (int i = 1; i < arraySizeN; i++) {
                int previous = arrayB[i - 1];
                int current = arrayB[i];
                if (previous < current) {
                    maxSum += current - 1;
                } else {
                    maxSum += previous - 1;
                }

            }
            System.out.println(maxSum);



        }
    }
}
