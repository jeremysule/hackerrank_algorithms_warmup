package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by jeremy on 7/19/16.
 */
public class BiggerIsGreater {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int numberOfTests = in.nextInt();

        for (int t = 0; t < numberOfTests; t++) {

            char[] word = in.next().toCharArray();
            int n = word.length;

            //identify pivot
            //find largest dreasing suffix (start from the back go up until you can't)

            //find pivot position
            int i = n - 2;
            while (i>-1 && word[i] >= word[i+1]) {
                i = i - 1;
            }

            if (i == -1) {
                System.out.println("no answer");
                continue;
            }

            //swap i with the proper place in the subarray [i...n]
            int newPosition = i;
            while (newPosition < n-1  && word[i] < word[newPosition+1]) {
                newPosition = newPosition + 1;
            }

            // swap NP and i
            char temp = word[i];
            word[i] = word[newPosition];
            word[newPosition] = temp;


            //reverse from i+1 to n-1
            for (int j = 1; j <= (n-i-1) / 2; j++) {
                char temp2 = word[i + j];
                word[i + j] = word[n - j];
                word[n - j] = temp2;
            }

            String nextPerm = new String(word);
            System.out.println(word);

        }
    }
}
