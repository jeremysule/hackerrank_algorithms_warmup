package hackerrank.algorithms.implementation;

import com.landawn.abacus.util.N;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by jeremy on 7/5/16.
 */
public class EqualStacks {
    public static void main(String[] args) {



        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        Integer h1[] = new Integer[n1];
        for(int h1_i=0; h1_i < n1; h1_i++){
            h1[h1_i] = in.nextInt();
        }
        Integer h2[] = new Integer[n2];
        for(int h2_i=0; h2_i < n2; h2_i++){
            h2[h2_i] = in.nextInt();
        }
        Integer h3[] = new Integer[n3];
        for(int h3_i=0; h3_i < n3; h3_i++){
            h3[h3_i] = in.nextInt();
        }
        Queue<Integer> s1 = new LinkedList<Integer>(Arrays.asList(h1));
        Queue<Integer> s2 = new LinkedList<Integer>(Arrays.asList(h2));
        Queue<Integer> s3 = new LinkedList<Integer>(Arrays.asList(h3));

        if (checkEqualSize(s1,s2,s3)) {//in case final condition is already met
            System.out.println(s1.size());
            return;
        }
        while (( sizeOf(s1) !=0 || sizeOf(s2) !=0 || sizeOf(s3) != 0) && checkEqualSize(s1,s2,s3)==false)
            {
                Queue<Integer> highest= findHighest(s1, s2, s3);
                highest.remove();
            };
        if (checkEqualSize(s1,s2,s3)) {//in case final condition is already met
            System.out.println(sizeOf(s1));
            return;
        } else {
            System.out.println(-1);
        }



    }

    public static int sizeOf(Queue<Integer> stack) {
        return stack.stream().mapToInt(Integer::intValue).sum();
    }

    private static boolean checkEqualSize(Queue<Integer> s1, Queue<Integer> s2, Queue<Integer> s3) {
        return sizeOf(s1) == sizeOf(s2) && sizeOf(s1) == sizeOf(s3);
    }

    private static Queue<Integer> findHighest(Queue<Integer> s1, Queue<Integer> s2, Queue<Integer> s3) {
        return findHighest(findHighest(s1,s2),s3);
    }

    private static  Queue<Integer> findHighest(Queue<Integer> s1, Queue<Integer> s2) {

        if ( sizeOf(s1) > sizeOf(s2)) {
            return s1;
        } else {
            return s2;
        }
    }
}
