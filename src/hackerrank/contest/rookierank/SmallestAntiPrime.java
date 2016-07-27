package hackerrank.contest.rookierank;

import com.landawn.abacus.util.N;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by jeremy on 7/26/16.
 */
public class SmallestAntiPrime {

    public static final TreeSet<Integer> allHCNs = new TreeSet<>(Arrays.asList(1, 2, 4, 6, 12, 24, 36, 48, 60, 120, 180, 240, 360, 720, 840, 1260, 1680, 2520, 5040, 7560, 10080, 15120, 20160, 25200, 27720, 45360, 50400, 55440, 83160, 110880, 166320, 221760, 277200, 332640, 498960, 554400, 665280, 720720, 1081080, 1441440, 2162160, 2882880, 3603600, 4324320, 6486480, 7207200, 8648640, 10810800));

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int Q = in.nextInt();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            //find first value above a
            result.append(allHCNs.ceiling(in.nextInt()));
            result.append(N.LINE_SEPARATOR);
        }
        System.out.println(result);
    }
}



