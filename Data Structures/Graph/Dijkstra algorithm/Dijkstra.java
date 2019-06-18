import java.util.*;

public class Dijkstra {

    private static int distance(ArrayList<Integer>[] adj, int s, int t, int[][] weight) {

        int cost = dijkstra(adj, s, t, weight);

        return (cost != Integer.MAX_VALUE) ? cost : -1;
    }

    private static int minimumVertex(int[] vertecies, boolean[] visited){

        int minmum = Integer.MAX_VALUE;
        int index = -1;
        for(int i=1; i<vertecies.length; i++){
            if(!visited[i]){
                if(vertecies[i] < minmum){
                    minmum = vertecies[i];
                    index = i;
                }
            }
        }
        return index;
    }

    private static int dijkstra(ArrayList<Integer>[] adj, int s, int t, int[][] weight){

        int[] cost = new int[adj.length];
        boolean[] visited = new boolean[adj.length];
        boolean[] alreadyInQueue = new boolean[adj.length];
        Queue<Integer> queue = new LinkedList<>();

        Arrays.fill(cost, Integer.MAX_VALUE);
        queue.add(s);
        cost[s] = 0;
        alreadyInQueue[s] = true;
        int node= s;

        while(! queue.isEmpty()){
            queue.remove();
            visited[node] = true;

            Iterator<Integer> vertex = adj[node].listIterator();

            while(vertex.hasNext()){
                int neighborNode = vertex.next();
                if(!visited[neighborNode]){
                    int checkCost = cost[node] + weight[node][neighborNode];

                    if(!alreadyInQueue[neighborNode]){
                        queue.add(neighborNode);
                        alreadyInQueue[neighborNode] = true;
                    }

                    if(checkCost < cost[neighborNode]){
                        cost[neighborNode] = checkCost;
                    }
                }
            }
            node = minimumVertex(cost,visited);
        }

        return cost[t];
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
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        System.out.println(distance(adj, x, y, weight));
    }

}

