package hackerrank.contest.misc;

import java.util.Scanner;

/**
 * Created by jeremy on 8/4/16.
 */
public class Rods {
    public static void main(String[] args) {
        Scanner in = new Scanner((System.in));
        int cut_cost = in.nextInt();
        int unit_price = in.nextInt();
        int how_manyrods = in.nextInt();
        int[] rods = new int[how_manyrods];
        for (int i = 0; i < how_manyrods; i++) {
            rods[i] = in.nextInt();
        }
        int maxProfitSofar = maxProfit(cut_cost, unit_price, rods);

        System.out.println(maxProfitSofar);

    }

    static int maxProfit(int cost_per_cut, int metal_price, int[] lengths) {


        //Find max length
        int max_length = 0;
        for(int r : lengths){
            max_length = Math.max(r,max_length);
        }

        int maxProfitSofar = Integer.MIN_VALUE;
        for (int possibleLength = 1; possibleLength < max_length+1; possibleLength++) {

            //Compute total profit for that lenght
            int profitForL = 0;
            for (int r : lengths){
                if (possibleLength > r)
                    continue;
                // length to cut <= r
                int howManypieces = r / possibleLength;
                int leftpieces = r % possibleLength;
                profitForL += howManypieces * possibleLength * metal_price;
                if (leftpieces != 0) {
                    //extra cut
                    profitForL -= howManypieces * cost_per_cut;
                } else {
                    profitForL -= (howManypieces - 1) * cost_per_cut;
                }
            }

            maxProfitSofar = Math.max(maxProfitSofar, profitForL);
        }
        return maxProfitSofar;


    }
}
