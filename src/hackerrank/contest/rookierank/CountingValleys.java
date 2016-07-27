package hackerrank.contest.rookierank;

import java.util.Scanner;

/**
 * Created by jeremy on 7/26/16.
 */
public class CountingValleys {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final int totalSteps = in.nextInt();

        int diffToSeaLevel = 0;
        int valleyCount = 0;
        in.nextLine(); // consume End Of Line
        String allSteps = in.nextLine();
        for (int i = 0; i < totalSteps; i++) {
            char step = allSteps.charAt(i);
            if (step == 'U') {
                diffToSeaLevel++;
            } else {
                diffToSeaLevel--;
                if (diffToSeaLevel == -1) //new valley
                    valleyCount++;
            }
        }
        System.out.println(valleyCount);
    }
}
