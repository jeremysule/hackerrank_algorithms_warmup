package hackerrank.contest.gr;

import java.util.Scanner;

public class PrimeNumbersN {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int N = in.nextInt();
            String allPrimesupToN = "";

            for (int candidate = 2; candidate <= N; candidate++) {

                if (candidate <= N && isPrime(candidate)){
                    allPrimesupToN = allPrimesupToN + candidate + " ";
                }

            }
            System.out.println(allPrimesupToN);
        }


    }

    private static boolean isPrime(int n) {
        for (int i = 2; i*i <= n; i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }
}
