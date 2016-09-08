package hackerrank.contest.gr;

import java.util.Arrays;
import java.util.Scanner;

public class CountBits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int N = in.nextInt();
            char[] binRe = Integer.toBinaryString(N).toCharArray();
            int count = 0;
            for (int i = 0; i < binRe.length; i++) {
                char c = binRe[i];
                if (c=='1')
                    count++;

            }
            System.out.println(count);
        }
    }
}
