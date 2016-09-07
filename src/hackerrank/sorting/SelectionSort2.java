package hackerrank.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort2 {

    public static void insertIntoSorted(int[] ar, int upTo) {
        int eletToIns = ar[upTo];

        for (int i = upTo-1; i >= 0 ; i--) {
            if (ar[i] > eletToIns) {
                ar[i+1] = ar[i];
//                printArray(ar);
            } else {
                ar[i+1] = eletToIns;
//                printArray(ar);
                break;
            }
        }
        if (eletToIns <= ar[0]) {
            ar[0] = eletToIns;
//            printArray(ar);
        }
    }


    public static void insertionSortPart2(int[] ar)
    {
        for (int k = 1; k < ar.length; k++) {
            insertIntoSorted(ar, k);
            printArray(ar);
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertionSortPart2(ar);

    }
    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
