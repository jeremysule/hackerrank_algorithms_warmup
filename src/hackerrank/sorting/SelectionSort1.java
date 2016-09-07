package hackerrank.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/insertionsort1
 */
public class SelectionSort1 {

    public static void insertIntoSorted(int[] ar) {
        int arraySize = ar.length;
        int eletToIns = ar[arraySize-1];

        for (int i = arraySize-2; i >= 0 ; i--) {
            if (ar[i] > eletToIns) {
                ar[i+1] = ar[i];
                printArray(ar);
            } else {
                ar[i+1] = eletToIns;
                printArray(ar);
                break;
            }
        }
        if (eletToIns <= ar[0]) {
            ar[0] = eletToIns;
            printArray(ar);
        }
    }

    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertIntoSorted(ar);
    }


    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }

}


