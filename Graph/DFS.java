import java.util.ArrayList;
import java.util.Scanner;

public class DFS {
    public static ArrayList<Integer> dfs(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls,
            boolean[] visited) {
        int num = node;
        visited[num] = true;
        ls.add(num);
        for (int neighbour : adj.get(num)) {
            if (!visited[neighbour]) {
                dfs(neighbour, adj, ls, visited);
            }
        }
        return ls;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> ls = new ArrayList<>();
        System.out.print("Enter nodes:");
        int nodes = sc.nextInt();
        boolean[] visited = new boolean[nodes + 1];
        for (int i = 0; i <= nodes; i++) {
            list.add(new ArrayList<>());
        }
        System.out.print("Enter edges:");
        int edges = sc.nextInt();
        for (int i = 1; i <= edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            list.get(u).add(v);
            list.get(v).add(u);
        }
        for (int i = 1; i <= nodes; i++) {
            if (!visited[i]) {
                dfs(i, list, ls, visited);
            }
        }
         System.out.println(ls);
    }
}
