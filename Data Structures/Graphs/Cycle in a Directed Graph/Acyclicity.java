import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Acyclicity {

    private static int acyclic(ArrayList<Integer>[] adj) {
        /*
           1. Run a DFS on the graph (you can run BFS as well it is up to you)....
           2. For every node create a new visited array, if you hit a visited node, then a cycle detected....
         */
        int[] detect;
        boolean[] visited;
        int stat=0;
        for(int i=1; i<adj.length; i++){
            detect = new int[adj.length];
            visited = new boolean[adj.length];
            stat = DFS(adj, detect, visited,i);
            if(stat == 1){
                return 1;
            }
//            System.out.println();

        }
        return stat;

    }

    private static int DFS(ArrayList<Integer>[] adj, int[] detect, boolean[] visited,int n){

//        System.out.print(n + "->");
        int stat = 0;
        visited[n] = true;
        detect[n] = 1;
        Iterator<Integer> vertex = adj[n].listIterator();

        while(vertex.hasNext()){
            int x = vertex.next();

            if(!visited[x]){
                stat = DFS(adj, detect, visited, x);
                if(stat == 1){
                    return 1;
                }
            }
            if(detect[x] == 1){
                return 1;
            }


        }
//        System.out.println("stat now " + stat);
        detect[n] = 0;
        return stat;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= m; i++) {// A Java Program to detect cycle in a graph
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x].add(y);
        }

//         for(int i=1; i<adj.length; i++){
//             System.out.println(i + " : " + adj[i]);
//         }
        System.out.println(acyclic(adj));
    }

}



