import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        System.out.print("Enter number of nodes :");
        int nodes = sc.nextInt(); // no of nodes

        for (int i = 0; i <= nodes; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.print("Enter number of edges :");
        int edges = sc.nextInt(); // no of edges

        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // bfs traversal

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[nodes + 1];

        for (int i = 1; i <= nodes; i++) {
            if (!visited[i]) {
                queue.add(i);
                visited[i] = true;

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    System.out.print(node + " ");

                    for (int neighbour : graph.get(node)) {
                        if (!visited[neighbour]) {
                            visited[neighbour] = true;
                            queue.add(neighbour);
                        }
                    }
                }
            }
        }
    }
}