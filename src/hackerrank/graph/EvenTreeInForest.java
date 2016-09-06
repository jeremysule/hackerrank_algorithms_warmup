package hackerrank.graph;

import com.landawn.abacus.util.Multimap;
import com.landawn.abacus.util.N;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jeremy on 21/08/16.
 * https://www.hackerrank.com/challenges/even-tree
 *
 * Checked editorial, all tests pass
 *
 */
public class EvenTreeInForest {

    private static Multimap<Integer, Integer, List<Integer>> adjList = N.newListLinkedMultimap();

    private static int maxEdgeToRemove = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner((System.in));

        int NVertices = in.nextInt();
        int MEdges = in.nextInt();


        for (int edge = 0; edge < MEdges; edge++) {
            int o = in.nextInt();
            int t = in .nextInt();
            //not directed
            adjList.put(o,t);
            adjList.put(t,o);
        }

        //pick a root
        int r = adjList.keySet().iterator().next();

        countSubTreeSizeRec(r, new boolean[NVertices+1]);

        System.out.println(maxEdgeToRemove);




    }

    /* side effect on maxEdgeToRemove*/
    private static int countSubTreeSizeRec (int r, boolean[] visited) {
        int numVertices = 0;
        visited[r] = true;
        for (int neighbour : adjList.get(r)) {
            if (!visited[neighbour]){
                int numVerticesInNB = countSubTreeSizeRec(neighbour,visited);
                if (numVerticesInNB % 2 == 0) {
                    maxEdgeToRemove++;
                }
                numVertices += numVerticesInNB;
            }

        }
        return numVertices+1;
    }


}

