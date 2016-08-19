package codility;

/**
 * Created by jeremy on 8/18/16.
 */
public class BinaryGap {

    public int solution(int N) {
        int maxSofar = 0;
        int currentGapSize = 0;
        boolean inAGap = false;
        char[] binaryRep = Integer.toBinaryString(N).toCharArray();
        for (int i = 0; i < binaryRep.length; i++) {
            if (binaryRep[i] == '0') {
                currentGapSize++;
                inAGap = true;
            } else {
                if (inAGap) {
                    // Exiting a gap
                    maxSofar = Math.max(maxSofar,currentGapSize);
                    currentGapSize = 0;
                    inAGap = false;
                }
            }
        }
        return maxSofar;
    }

    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();
        System.out.println(binaryGap.solution(2147483600));
    }
}
