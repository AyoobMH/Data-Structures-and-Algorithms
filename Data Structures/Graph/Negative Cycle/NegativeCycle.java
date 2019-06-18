import java.util.*;

public class NegativeCycle {
    static int cost = 0;
    private static int negativeCycle(ArrayList<Integer>[] adj, int[][] weight) {

        /*
            1. Run a DFS on the graph (you can run BFS as well it is up to you)....
            2. For every node create a new visited array, if you hit a visited node, then a cycle detected and if cost when the cycle is detected is < 0 then return 1....
        */

        int[] detect;
        boolean[] visited;
        int stat=0;
        int prevNode = 0;

        for(int i=1; i<adj.length; i++){
            cost = 0;
            detect = new int[adj.length];
            visited = new boolean[adj.length];
            stat = DFS(adj, detect, visited,i, weight, prevNode);
            if(stat == 1){
                return 1;
            }
        }
        return stat;
    }

    private static int DFS(ArrayList<Integer>[] adj, int[] detect, boolean[] visited,int n, int[][] weight, int prevNode){

        int stat = 0;
        visited[n] = true;
        detect[n] = 1;
        Iterator<Integer> vertex = adj[n].listIterator();

        while(vertex.hasNext()){
            int x = vertex.next();
            cost += weight[n][x];
            if(!visited[x]){
                stat = DFS(adj, detect, visited, x, weight, n);
                if(stat == 1){
                    return 1;
                }
            }
            if(detect[x] == 1 && cost < 0){
                return 1;
            }
            else if(detect[x] == 1 && cost > 0){
                cost -= weight[n][x];
                detect[x] = 0;
            }
        }
        detect[n] = 0;
        cost -= weight[prevNode][n];
        return stat;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] weight = new int[n+1][n+1];
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x].add(y);
            weight[x][y] = w;
        }

        System.out.println(negativeCycle(adj, weight));
    }
}

