import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Reachability {

    private static int reach(ArrayList<Integer>[] adj, int x, int y) {

        //Make a visited array to check if we were able to visit the vertex...

        boolean[] visited = new boolean[adj.length];

        return DFS(adj, visited, x, y);

    }

    private static int DFS(ArrayList<Integer>[] adj, boolean[] visited, int x, int y){

        int stat = 0;
        if(x==y){
            return 1;
        }

        visited[x] = true;

        Iterator<Integer> vertex = adj[x].listIterator();

        while(vertex.hasNext()){

            int n = vertex.next();

            if(!visited[n]){
                stat = DFS(adj, visited, n, y);
                if(stat == 1){
                    return 1;
                }
            }
        }

        return 0;
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
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        System.out.println(reach(adj, x, y));
    }
}
