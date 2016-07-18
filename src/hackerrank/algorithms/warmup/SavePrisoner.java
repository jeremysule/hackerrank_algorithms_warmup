package hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * Created by jeremy on 7/1/16.
 */
public class SavePrisoner {



    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int totalNumberOfCases = in.nextInt();

        for (int i = 0; i < totalNumberOfCases; i++) {
            int nbPris = in.nextInt();
            int nbSweets = in.nextInt();
            int startDistrib = in.nextInt();

            int leftAfterFullCircles = nbSweets % nbPris; // 0=<leftAfterFullCircles<nbSweets

            if (leftAfterFullCircles == 0) {
                if (startDistrib == 1) {
                    System.out.println(nbPris);
                } else {
                    System.out.println(startDistrib - 1);
                }
                continue;
            }


            int idPosined = leftAfterFullCircles + startDistrib-1 ;
            System.out.println(idPosined);

        }
    }
}
