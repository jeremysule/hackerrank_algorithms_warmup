package hackerrank.algorithms.graphtheory;

import java.util.*;

/**
 * Created by jeremy on 7/20/16.
 */
public class BFSShortestReach {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int numberOfTests = in.nextInt();

        for (int t = 0; t < numberOfTests; t++) {
            /*Load data for the test*/
            int totalNodes = in.nextInt();
            int totalEdges = in.nextInt();
            Map<Integer, Set<Integer>> edges = new HashMap<>();
            for (int edge = 0; edge < totalEdges; edge++) {
                int origin = in.nextInt();
                int target = in.nextInt();

                //edges are undirected, load in both orders
                if (!edges.containsKey(origin)) {
                    edges.put(origin, new HashSet<>());
                }
                edges.get(origin).add(target);
                if (!edges.containsKey(target)) {
                    edges.put(target, new HashSet<>());
                }
                edges.get(target).add(origin);
            }
            int startS = in.nextInt();

            /* Solve accessibility */
            int round = 0;
            //Map<Integer, Integer> accessibleNodes = new HashMap<>();
//            accessibleNodes.put(startS, 0);

            Map<Integer, Integer> previousAccessibleNodes;
            Map<Integer, Integer> newlyAccessibleNodes =  new HashMap<>();
            newlyAccessibleNodes.put(startS, 0);
            do {
                previousAccessibleNodes = newlyAccessibleNodes;
                newlyAccessibleNodes = new HashMap<>(previousAccessibleNodes); //depp copy
                for (Integer currentNode : previousAccessibleNodes.keySet()) {
                    int currentWeight = previousAccessibleNodes.get(currentNode);
                    if (edges.containsKey(currentNode)) {
                        for (Integer destination : edges.get(currentNode)) {
                            if (!newlyAccessibleNodes.containsKey(destination)) {
                                newlyAccessibleNodes.put(destination, currentWeight + 6);
                            }
                        }
                    }

                }


            }
            while (previousAccessibleNodes.equals(newlyAccessibleNodes) == false); //once origin and destination result in the same sets, stop, going nowhere

            for (int i = 1; i <= totalNodes; i++) {
                if (i == startS)
                    continue;
                System.out.print(newlyAccessibleNodes.getOrDefault(i,-1) + " ");

            }
            System.out.println();
        }
    }
}

