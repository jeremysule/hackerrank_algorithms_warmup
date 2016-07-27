package hackerrank.contest.rookierank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by jeremy on 7/26/16.
 */
public class ExtremelyDangerousVirus {

    public static final BigInteger MOD = BigInteger.valueOf(1_000_000_007);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final BigInteger a = BigInteger.valueOf(in.nextLong());
        final BigInteger b = BigInteger.valueOf(in.nextLong());

        BigInteger t = BigInteger.valueOf(in.nextLong());
//        long population = 0L;
//        do {
//            population += 0.5 * (a + b);
//            population %= MOD;
//            t--;
//        } while (t > 0);
//
//        System.out.println(population);

       BigInteger result = a.add(b).divide(BigInteger.valueOf(2L));
        result = result.modPow(t,MOD);
//        result.multiply()
        System.out.println(result.toString());






    }


}
