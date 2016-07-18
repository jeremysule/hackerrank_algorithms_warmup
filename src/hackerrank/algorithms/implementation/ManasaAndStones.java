package hackerrank.algorithms.implementation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by jeremy on 7/18/16.
 */
public class ManasaAndStones {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numberOfTests = in.nextInt();

        for (int i = 0 ; i<numberOfTests; i++){
            int n = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();

            TreeSet<Integer> possibleValues = new TreeSet<>();

            for (int coeffA = 0; coeffA <= n-1; coeffA++) { // first stone is 0 but count from 1 to n
                int newPossibleValue=  coeffA * a + (n-1-coeffA) * b;
                if (!possibleValues.contains(newPossibleValue)) {
                    possibleValues.add(newPossibleValue);
                }
            }

            possibleValues.stream().forEach( x -> System.out.print(x + " "));
            System.out.println();

        }
    }
}
