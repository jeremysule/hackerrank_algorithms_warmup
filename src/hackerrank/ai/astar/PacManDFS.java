package hackerrank.ai.astar;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


public class PacManDFS {

    //Todo: problem statement seems to expect a Path, not shortest, but sample output does...

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        Node origin = new Node(in.nextInt(), in.nextInt());
        Node food= new Node(in.nextInt(),in.nextInt());

        int rows = in.nextInt();
        int columns = in.nextInt();

        boolean[][] grid = new boolean[rows][columns];

        //finish consume line
        in.nextLine();

        //Construct grid from input
        for (int i = 0; i < rows; i++) {
            String line = in.nextLine();
            for (int j = 0; j < columns; j++) {
                char charInput = line.charAt(j);
                if (charInput != '%') {
                    grid[i][j] = true;
                }
            }
        }

        //check neighbours for origin
        origin.populateNeighbours(grid);

        Deque<Node> pathSoFar = new LinkedList<>();
//        pathSoFar.add(origin);
        Node currentNode = origin;
        while (!currentNode.equals(food)){
            if (currentNode.hasNextNotInPath(pathSoFar)) {
                pathSoFar.push(currentNode);
                currentNode = currentNode.popNextNeighbourNotInPath(pathSoFar);
                currentNode.populateNeighbours(grid);
            } else {
                currentNode = pathSoFar.pop();
            }
        }

        pathSoFar.push(currentNode);
        //We arrived at food, print the PATH
        System.out.println(pathSoFar.size());
        do {
            System.out.println(pathSoFar.removeLast());
        } while (!pathSoFar.isEmpty());

    }

    private static class Node{
        private int x,y;

        private LinkedList<Node> neigbours = new LinkedList<>();

        public Node(int x, int y) {
            this.y = y;
            this.x = x;
        }


        public void populateNeighbours(boolean[][] grid){
            if (x-1>0 && grid[x-1][y])
                neigbours.add(new Node(x-1,y));
            if (x+1<grid.length && grid[x+1][y])
                neigbours.add(new Node(x+1,y));
            if (y+1<grid[0].length && grid [x][y+1])
                neigbours.add(new Node(x,y+1));
            if (y-1>0 && grid[x][y-1])
                neigbours.add(new Node(x,y-1));
        }



        public boolean hasNext() {
            return !neigbours.isEmpty();
        }


        public Node popNextNeighbourNotInPath( Deque<Node> pathSoFar) {
            Node nextNode;
            do {
                nextNode = neigbours.pop();
            } while (pathSoFar.contains(nextNode));
            return nextNode;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (x != node.x) return false;
            return y == node.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }

        public boolean hasNextNotInPath(Deque<Node> pathSoFar) {
            return !pathSoFar.containsAll(neigbours);
        }
    }


}
