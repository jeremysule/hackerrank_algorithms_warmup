package codility;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by jeremy on 19/08/16.
 */
public class ArrayRotation {

    public int[] solution(int[] A, int K) {
        //No focus on performance
        //not in place
        //max 100 elements

        int[] res = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            res[i] = A[Math.floorMod(i-K,A.length)];
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayRotation sol = new ArrayRotation();
        int[] test = {3, 8, 9 ,7, 6,4,3,2};

        int[] result = sol.solution(test,3);
        System.out.println(result);
    }
}
