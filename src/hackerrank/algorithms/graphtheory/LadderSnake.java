package hackerrank.algorithms.graphtheory;

import java.util.*;

public class LadderSnake {
public static final int TOTAL_BLOCKS = 100;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        //Read number of cases
        int numberOfCases = in.nextInt();
        for (int testCase = 0; testCase < numberOfCases; testCase++) {

            //Load ladders and snakes
            Map<Integer, Integer> laddersAndSnakes = new HashMap<>();

            //Load ladders
            int numberOfLadders = in.nextInt();
            for (int shortcut = 0; shortcut < numberOfLadders; shortcut++) {
                int origin = in.nextInt();
                int destination = in.nextInt();
                laddersAndSnakes.put(origin,destination);
            }

            //Load snakes
            int numberOfSnakes = in.nextInt();
            for (int shortcut = 0; shortcut < numberOfSnakes; shortcut++) {
                int origin = in.nextInt();
                int destination = in.nextInt();
                laddersAndSnakes.put(origin,destination);
            }

            int totalNumberOfRolls = 0; //this is what we display, if we reach 100

            //Use BFS based algorithm to see the first time we reach 100, but we don't keep path, only the current node
            Set<Integer> currentBlocksAtRound = new HashSet<>();
            currentBlocksAtRound.add(1);

            do {
                totalNumberOfRolls++;
                Set<Integer> newSetOfBlocks = new HashSet<>();
                for (Integer possblieCurrentBlock: currentBlocksAtRound){
                    for (int i = 1; i <=6 ; i++) { //dice has six sides
                        int virtualNewBlock = possblieCurrentBlock + i;
                        if (virtualNewBlock <= 100) {
                            newSetOfBlocks.add(laddersAndSnakes.getOrDefault(virtualNewBlock,virtualNewBlock)); //if present, get destination, or get new block
                        }
                    }
                    currentBlocksAtRound=newSetOfBlocks;
                }

            } while (!currentBlocksAtRound.isEmpty()  && !currentBlocksAtRound.contains(100) && totalNumberOfRolls < 100);

            if (currentBlocksAtRound.contains(100)) {
                System.out.println(totalNumberOfRolls);
            } else {
                System.out.println(-1);
            }
        }


    }
}
