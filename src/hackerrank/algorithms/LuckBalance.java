package hackerrank.algorithms;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//This solution is using a greedy approach

//todo: ended up a big boiler plate, simplify?
public class LuckBalance {

    public static class Contest {
        public final int luck;

        public final boolean important;


        public Contest(int luck, boolean important) {

            this.luck = luck;
            this.important = important;


        }

        @Override
        public String toString() {
            return "" + luck + important;
        }

        public static final Comparator<Contest> COMPARATOR = new Comparator<Contest>() {
            @Override
            public int compare(Contest o1, Contest o2) {
                return Integer.compare(o1.luck,o2.luck);
            }
        };
    }

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        int numContests = in.nextInt();
        int kMaxImportantLosses = in.nextInt();

        int maxPossibleLuck = 0;

        PriorityQueue<Contest> allImportantContests = new PriorityQueue<Contest>(Contest.COMPARATOR);

        for (int i = 0; i < numContests; i++) {
            Contest newContest = new Contest(in.nextInt(),in.nextInt()==1);
            if (newContest.important) {
                if (allImportantContests.size()<kMaxImportantLosses) {
                    allImportantContests.add(newContest);
                    maxPossibleLuck += newContest.luck;
                } else {
                    if (kMaxImportantLosses>0) {
                        Contest minContest = allImportantContests.peek();
                        if (Contest.COMPARATOR.compare(minContest,newContest)<0){
                            allImportantContests.remove(minContest);
                            allImportantContests.add(newContest);
                            maxPossibleLuck -= 2*minContest.luck;
                            maxPossibleLuck += newContest.luck;
                        } else {
                            maxPossibleLuck -= newContest.luck;
                        }
                    } else {
                        maxPossibleLuck -= newContest.luck;
                    }

                }
            } else {
                maxPossibleLuck+=newContest.luck;
            }
        }

        //baaaad asserts
        assert allImportantContests.size() <= kMaxImportantLosses;


        System.out.println(maxPossibleLuck);

    }
}
