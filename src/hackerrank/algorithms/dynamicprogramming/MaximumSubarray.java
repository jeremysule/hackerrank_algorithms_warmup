package hackerrank.algorithms.dynamicprogramming;

import java.util.Scanner;

/**
 * Created by Jeremy on 21/07/2016.
 */
public class MaximumSubarray {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int numberOfTests = in.nextInt();

        for (int t = 0; t < numberOfTests; t++) {
            //Load data
            int sizeN = in.nextInt();
            int[] array = new int[sizeN];

            boolean hasNeg = false;
            boolean hasPos = false;

            int sumAll = 0;
            int sumAllPos = 0;
            int maxIfAllNeg = Integer.MIN_VALUE;

            for (int i = 0; i < sizeN; i++) {
                array[i] = in.nextInt();
                if (array[i] >=0) {
                    hasPos = true;
                    sumAllPos += array[i];
                } else {
                    hasNeg = true;
                    maxIfAllNeg = Math.max(maxIfAllNeg, array[i]);
                }
                sumAll += array[i];
            }

            ////
            if (! hasNeg) {
                //No negative, both results are the sum of all elements
                System.out.printf("%d %d%n", sumAll, sumAll);
            } else if (!hasPos) {
                //No Positive, only negatives, both results is the maximum
                System.out.printf("%d %d%n", maxIfAllNeg, maxIfAllNeg);
            } else {
                //Both Neg and Positives
                //already have sumAllPos for non-contiguous array
                //need to compute max subaray

                // consider maximum of any subarray ending at the current position!
                int maxEndCurrent = 0;
                int maxSoFar = 0 ;
                for (int i = 0; i < sizeN; i++) {
                    maxEndCurrent = Math.max(0, maxEndCurrent + array[i]);
                    maxSoFar = Math.max(maxSoFar,maxEndCurrent);
                }
                System.out.printf("%d %d%n", maxSoFar, sumAllPos);


// This is slow, computes the same value several time
//                int maxSoFar = Integer.MIN_VALUE;
//                for (int i = 0; i < sizeN; i++) {
//                    for (int j = 0; j <sizeN-i ; j++) {
//                        //array from i to i+j
//                        int sumOfContSubarray = 0;
//                        for (int k = i; k < i+j+1; k++) {
//                            sumOfContSubarray += array[k];
//                        }
//                        maxSoFar = Math.max(maxSoFar,sumOfContSubarray);
//                    }
//                }
            }
        }

    }
}
