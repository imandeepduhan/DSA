import java.util.ArrayList;

public class BipartiteDFS {

    private static boolean dfs(int node, int col, ArrayList<ArrayList<Integer>> adj, int[] color ) {
        color[node] = col;
        
        for(int it : adj.get(node)) {
            if(color[it] == -1) {
                if(!dfs(it, 1 - col, adj, color)) {
                    return false;
                }
            } else if(color[it] == col) {
                return false;
            }
        }

        return true;
    }
     

    public static boolean isBipartite(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[v];
        for(int i = 0; i < v; i++) {
            color[i] = -1;
        }

        for(int i = 0; i < v; i++) {
            if(color[i] == -1) {
                if(!dfs(i, 0, adj , color)) {
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {

        int v = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        /*
        
        1 -> 2
        2 -> 1,3,6
        3 -> 2,4
        4 -> 3,5,7
        5 -> 4,6,7
        6 -> 2,5
        7 -> 4,8
        8 -> 7
        
        */

        adj.get(0).add(1);

        adj.get(1).add(0);              
        adj.get(1).add(2);              
        adj.get(1).add(5);              

        adj.get(2).add(1);              
        adj.get(2).add(3);              

        adj.get(3).add(2);             
        adj.get(3).add(4);             
        adj.get(3).add(6);              

        adj.get(4).add(3);              
        adj.get(4).add(5);              
        adj.get(4).add(6);              

        adj.get(5).add(1);           
        adj.get(5).add(4);           

        adj.get(6).add(3);            
        adj.get(6).add(7);              

        adj.get(7).add(6);  

        boolean answer = isBipartite(v, adj);

        System.out.println("Is graph bipartite : " + answer);

    }
}
