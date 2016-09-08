package hackerrank.contest.gr;

import java.util.HashSet;
import java.util.Scanner;

public class Fraction {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashSet baseSet = new HashSet<Integer>();
        baseSet.add(in.nextInt());
        while (in.hasNextInt()){
            baseSet.add(in.nextInt());
        }
    }


}
