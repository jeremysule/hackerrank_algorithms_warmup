package hackerrank.algorithms.dynamicprogramming;

import com.landawn.abacus.util.N;

import java.math.BigInteger;
import java.util.Scanner;

public class FindTheSeed {
    //todo: not fully working with test cases

    
    private static final long MOD = 5L;
//    public static final long MOD = 1_000_000_007L;

    private static long findModInverse(final long x){
        return BigInteger.valueOf(x).modInverse(BigInteger.valueOf(MOD)).longValueExact();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final int N_NUMBERS = in.nextInt();
        int k = in.nextInt();

        long[] lastNnumbers = new long[N_NUMBERS];
        for (int i = 0; i < N_NUMBERS; i++) {
            lastNnumbers[i] = in.nextLong();
        }

        long[] coeff = new long[N_NUMBERS];
        for (int i = 0; i < N_NUMBERS; i++) {
            coeff[i] = in .nextLong();
        }

        long modInverse = findModInverse(coeff[N_NUMBERS-1]);
        while (k - N_NUMBERS > -1){
            long fKMinusN = lastNnumbers[0]; //Fk
            for (int i = 0; i < N_NUMBERS-1; i++) {
                fKMinusN -= coeff[i]*lastNnumbers[N_NUMBERS-1-i]; //Ci*Fk-i
//                fKMinusN = Math.floorMod(fKMinusN,MOD);

            }
//            fKMinusN = Math.floorMod(fKMinusN,MOD);
            fKMinusN *= modInverse;
            fKMinusN = Math.floorMod(fKMinusN,MOD);
//            fKMinusN /= coeff[N_NUMBERS-1];
            lastNnumbers = N.delete(lastNnumbers,0);
            lastNnumbers = N.add(lastNnumbers,fKMinusN);
            k--;
        }

        N.forEach(lastNnumbers, x -> System.out.print( x + " "));

    }


}
