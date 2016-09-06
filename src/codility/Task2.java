package codility;

/**
 * Created by jeremy on 19/08/16.
 */
public class Task2 {

    public int solution(int[] A) {

        int longestSoFar = 0;

        if (A.length == 0 || A.length == 1 || A.length == 2)
            return A.length;

        int a,b;
        int firstTimeA, firstTimeB;
        int lastTimeA, lastTimeB;
        int startOfLastSeqA, startofLastSeqB;

        //init a and b
        a = A[0];
        firstTimeA = 0;
        startOfLastSeqA = 0;
        int i = 0;
        while (i <A.length && A[i] == a) {
            i++;
        }
        if (i == A.length-1 || i == A.length-1) //one value only or one different at the end
            return A.length;
        b = A[i];
        firstTimeB = i;
        lastTimeB = i;
        startofLastSeqB = i;

        lastTimeA = i-1;
        startOfLastSeqA = i-1;



        for (int j = i+1; j < A.length; j++) {
            if (A[j]==b) {
                if (A[j-1] == a )
                    startofLastSeqB = j;
                lastTimeB = j;
            } else if ( A[j]==a ) {
                if (A[j-1] == b )
                    startOfLastSeqA = j;
                startOfLastSeqA = j;
                lastTimeA = j;
            } else {
                // We see neither A nor B, a new value

                //add the new value to the oldest of a or b
                if (lastTimeA > lastTimeB) {
                    //replace b
                    b = A[j];
                    firstTimeB = j;
                    lastTimeB = j;
                    startofLastSeqB = j;

                    firstTimeA = startOfLastSeqA;
                } else {
                    //replace a
                    a = A[j];
                    firstTimeA = j;
                    lastTimeA = j;
                    startOfLastSeqA = j;

                    firstTimeB = startofLastSeqB;
                }
            }
            longestSoFar = Math.max(longestSoFar , Math.max(lastTimeA, lastTimeB) - Math.min(firstTimeA,firstTimeB)+1);
        }
        return longestSoFar;


    }

    public static void main(String[] args) {
        Task2 task = new Task2();
        int[] A = {5,5,5,5,5,5,4,5,4,5,4,1,4,4,4,4,4,5,5,5,5,5,5,4,5,4,5,4,1};
        System.out.println(task.solution(A));

    }


}
