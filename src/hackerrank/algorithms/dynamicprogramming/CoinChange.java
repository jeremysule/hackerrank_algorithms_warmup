package hackerrank.algorithms.dynamicprogramming;


import java.util.*;

public final class CoinChange {

    public static final class SubProblem {
        final int sumToAchieve;
        final List<Integer> coinsAvailable;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SubProblem that = (SubProblem) o;

            if (sumToAchieve != that.sumToAchieve) return false;
            return coinsAvailable.equals(that.coinsAvailable);

        }

        @Override
        public int hashCode() {
            int result = sumToAchieve;
            result = 31 * result + coinsAvailable.hashCode();
            return result;
        }

        public SubProblem(int sumToAchieve, List<Integer> coinsAvailable) {
            this.sumToAchieve = sumToAchieve;
            this.coinsAvailable = new LinkedList<>(coinsAvailable);
        }

        @Override
        public String toString() {
            return sumToAchieve + coinsAvailable.toString();
        }


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int sumToAchieve = in.nextInt();
        int numCoins = in.nextInt();

        List<Integer> coinsAvailable = new LinkedList<>();
        for (int i = 0; i < numCoins; i++) {
            coinsAvailable.add(in.nextInt());
        }
        long timestamp = System.nanoTime();
        Collections.sort(coinsAvailable, (x,y) -> y-x);//decreasing order

        Map<SubProblem,Long> solvedProblems = new HashMap<>();

        long result = numWaysToAchieve(sumToAchieve,coinsAvailable, solvedProblems);

        System.out.println(result);

        System.err.println("Time taken: " + (System.nanoTime()-timestamp)/1_000_000 + "ms");

    }

    private static final long numWaysToAchieve(int sumToAchieve, final List<Integer> coinsAvailable, final Map<SubProblem, Long> solvedProblems) {
        //stop cases
        if (sumToAchieve == 0L) {
            return 1L;
        }
        if (coinsAvailable.size()==1 && sumToAchieve%coinsAvailable.get(0)==0) {
            return 1L;
        }
        if (coinsAvailable.isEmpty()) {
            return 0L;
        }

        //check if already solved
        SubProblem subProblem = new SubProblem(sumToAchieve, coinsAvailable);
        if (solvedProblems.containsKey(subProblem)) {
//            System.err.println("subproblem retrieved " + subProblem);
            return solvedProblems.get(subProblem);
        }

        long result = 0L;
        List<Integer> newSetOfCoins = new LinkedList<>(coinsAvailable);
        int firstCoin = coinsAvailable.remove(0);

        do {
            //copy list for each recursive call
            List<Integer> myCoinsAvailable = new LinkedList<>(coinsAvailable);
            result += numWaysToAchieve(sumToAchieve,myCoinsAvailable,solvedProblems);
            sumToAchieve-=firstCoin;
        } while (sumToAchieve >=0 );

        solvedProblems.put(subProblem,result);
        return result;

    }


}


