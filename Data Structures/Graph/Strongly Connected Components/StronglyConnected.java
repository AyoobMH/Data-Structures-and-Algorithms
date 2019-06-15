import java.util.*;

public class StronglyConnected {

    static ArrayList<Integer> visitedPostOrder;


    // Method to compute the number of strongly connected components in a directed graph
    private static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj) {

        /*
        1. Run a DFS on the graph and record post occurrence of each node...
        2. Reverse the original graph
        3. Run a DFS on the reversed graph based from the largest post number to the smallest one, and for every unvisited node it counts as s strongly connected component.
         */

        visitedPostOrder = new ArrayList<Integer>(adj.length);

        boolean[] visited = new boolean[adj.length];

        for(int i=1; i<adj.length; i++){

            if(!visited[i]){
                DFS(adj, visited, i);
            }
        }

        adj = reversAdj(adj, adj.length);

        visited = new boolean[adj.length];
        int length = visitedPostOrder.size();
        int connectedComponents = 0;

        for(int i=length-1; i>=0; i--){
            if(!visited[visitedPostOrder.get(i)]){
                connectedComponents++;
                reverseGraphDFS(adj, visited, visitedPostOrder.get(i));
            }
        }

        return connectedComponents;
    }

    // A method to run DFS on the graph
    private static void DFS(ArrayList<Integer>[] adj, boolean[] visited, int n){

        visited[n] = true;
        Iterator<Integer> vertex = adj[n].listIterator();

        while(vertex.hasNext()){
            int x = vertex.next();
            if(!visited[x]){
                DFS(adj, visited, x);
            }
        }

        visitedPostOrder.add(n);
    }

    // A method to run DFS on the reversed graph
    private static void reverseGraphDFS(ArrayList<Integer>[] adj, boolean[] visited, int n){

        visited[n] = true;
        Iterator<Integer> vertex = adj[n].listIterator();

        while(vertex.hasNext()){
            int x = vertex.next();
            if(!visited[x]){
                reverseGraphDFS(adj, visited, x);
            }
        }
    }

    // A method to reverse a directed graph...
    public static ArrayList<Integer>[] reversAdj(ArrayList<Integer>[] adj, int vertecies){

        ArrayList<Integer>[] reversAdj = (ArrayList<Integer>[])new ArrayList[vertecies];

        for (int i=1; i<vertecies; i++){
            reversAdj[i] = new ArrayList<Integer>();
        }

        for (int i=1; i<vertecies; i++){
            Iterator<Integer> vertex = adj[i].listIterator();
            while (vertex.hasNext()){
                int n = vertex.next();
                reversAdj[n].add(i);
            }
        }

        return reversAdj;

    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x].add(y);
        }

        System.out.println(numberOfStronglyConnectedComponents(adj));
    }
}
