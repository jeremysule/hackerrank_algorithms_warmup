package codility;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

/**
 * Created by jeremy on 20/08/16.
 */
public class Task1 {

    class Tree {
        public int x;
        public Tree l;
        public Tree r;
    }

    public int solution(Tree T) {
        LinkedList<Integer> visible = new LinkedList<>();

        Stack<Tree> stack = new Stack();

        Set<Tree> visited = new HashSet<>();
        LinkedList<Tree> pathValues = new LinkedList<>();

        stack.push(T);

        while(!stack.isEmpty()) {}



        // write your code in Java SE 8
        return 0;
    }

    public static void main(String[] args) {
        Task1 t = new Task1();
        System.out.println();
    }



}
