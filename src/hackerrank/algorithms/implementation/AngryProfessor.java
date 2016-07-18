package hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by jeremy on 7/3/16.
 *
 2
 4 3
 -1 -3 4 2
 4 2
 0 -1 2 1
 *
 */
public class AngryProfessor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numberOfTests = in.nextInt();

        for (int i = 0 ; i<numberOfTests; i++){
            int nbStudents = in.nextInt();
            int threshold = in.nextInt();

            in.nextLine(); // finish consuming the line

            String[] line = in.nextLine().split(" ");
           IntStream streamOFArrivals = Arrays.stream(line).mapToInt( Integer::parseInt );
            long totalPresentAtStart = streamOFArrivals.filter( x -> x <= 0).count();

            if (totalPresentAtStart >= threshold) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }


        }


    }
}
