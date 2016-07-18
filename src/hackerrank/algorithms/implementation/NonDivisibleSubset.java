package hackerrank.algorithms.implementation;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by jeremy on 7/9/16.
 */
public class NonDivisibleSubset {
    public static void main(String[] args) {
        //init
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k= in.nextInt();
        Set<Integer> setS= new TreeSet<>();
//        Set<Integer> largestSubset= new TreeSet<>();

        for (int i = 0; i < n; i++) {
            setS.add(i);
        }

        int minValuesToRemove;
        outer: for (Integer element1: setS){
            remainer1 = element1 % k
            for (Integer element2: setS) {
                if (element1+element2%k==0){
                    setS.remove(element1);
//                    setS.remove(element2);
                    break outer;
                }
            }
        }
        System.out.println(setS.size());
    }
}
