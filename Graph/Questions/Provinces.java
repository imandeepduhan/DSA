// Find Number of Provinces

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Provinces {

    public static void dfs(int n, ArrayList<ArrayList<Integer>> list, boolean[] visited) {
        int node = n;
        visited[node] = true;
        for (int neighbour : list.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour, list, visited);
            }
        }
    }

    public static void bfs(int n, ArrayList<ArrayList<Integer>> list, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbour : list.get(node)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes : ");
        int nodes = sc.nextInt();
        int[][] graph = new int[nodes][nodes];
        System.out.print("Enter number of edges : ");
        int edges = sc.nextInt();

        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        // convert matrix into arraylist
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (graph[i][j] == 1) {
                    adjList.get(i).add(j);
                }
            }
        }

        boolean[] visited = new boolean[nodes];

        int count = 0;

        /* 
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                count++;
                bfs(i, adjList, visited);
            }
        }
            */

        // dfs
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, adjList, visited);
            }
        }
        System.out.println(count);
    }
}