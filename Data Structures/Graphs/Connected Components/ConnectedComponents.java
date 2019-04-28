import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<Integer>[] adj) {

        int count=0;
        boolean[] visited = new boolean[adj.length+1];

        //Perform a Depth First Search for every unvisited vertex.
        for(int i=1; i<adj.length; i++){
            if(!visited[i]){
                count++;
                DFS(adj, visited, i);
            }
        }

        return count;
    }

    private static void DFS(ArrayList<Integer>[] adj, boolean[] visited, int n){

        visited[n] = true;

        Iterator<Integer> vertex = adj[n].listIterator();

        while(vertex.hasNext()){

            n = vertex.next();

            if(!visited[n]){
                DFS(adj, visited, n);
            }
        }
    }

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
            adj[y].add(x);
        }
        System.out.println(numberOfComponents(adj));
    }
}
