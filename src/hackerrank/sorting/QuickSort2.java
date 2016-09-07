package hackerrank.sorting;

import com.landawn.abacus.util.N;

import java.util.Scanner;

public class QuickSort2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arrSize =  in.nextInt();
        int[] ar = new int[arrSize];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = in.nextInt();
        }

        ar = partition(ar);


//        System.out.println(N.join(ar, " "));

    }

    private static int[] partition(int[] ar) {
        if (ar.length == 0 || ar.length == 1) {
            return ar;
        }
        int pivot = ar[0];
        int[] left = {};
        int[] right = {};
        int[] equals = {};

        for (int i = 0; i < ar.length; i++) {
            int elt = ar[i];
            if (elt < pivot ) {
               left = N.add(left,elt);
            } else if (elt == pivot) {
                equals = N.add(equals,elt);
            } else {
                right = N.add(right,elt);
            }
        }

        left = partition(left);
        right = partition(right);
        int[] merged =  N.concat(N.concat(left,equals),right);
        System.out.println(N.join(merged, " "));
        return merged;

    }


}
