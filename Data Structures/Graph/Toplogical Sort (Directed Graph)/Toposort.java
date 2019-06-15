import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Toposort {
    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        boolean used[] = new boolean[adj.length];
        ArrayList<Integer> order = new ArrayList<Integer>();
        for (int i=1; i<adj.length; i++){
            if(!(used[i])){
                dfs(adj, used, order, i);
            }
        }

        return order;
    }

    private static void dfs(ArrayList<Integer>[] adj, boolean[] used, ArrayList<Integer> order, int s) {
        used[s] = true;
        Iterator<Integer> vertex = adj[s].listIterator();

        while (vertex.hasNext()){
            int n = vertex.next();
            if(!(used[n])){
                dfs(adj, used, order, n);
            }
        }
        order.add(s);
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
        }

//        for(int i=1; i<adj.length; i++){
//            System.out.println(i + " : " + adj[i]);
//        }

        ArrayList<Integer> order = toposort(adj);
        for (int i=n-1; i>=0; i--) {
            System.out.print(order.get(i) + " ");
        }
    }
}

