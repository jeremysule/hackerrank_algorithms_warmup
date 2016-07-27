package hackerrank.contest.rookierank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by jeremy on 7/26/16.
 */
public final class BirthdayCakeCandles {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final int totalCandles = in.nextInt();
        final ArrayList<Integer> allCandles = new ArrayList<>(totalCandles);
        for (int i = 0; i < totalCandles; i++) {
            allCandles.add(in.nextInt());
        }

        Collections.sort(allCandles, (x,y) -> y-x);
        final int tallestCandleheight = allCandles.get(0);
        int count = 0;

        for (int candle :
                allCandles) {
            if  (candle == tallestCandleheight) {
                count++;
                continue;
            }
        }
        System.out.println(count);


    }
}
