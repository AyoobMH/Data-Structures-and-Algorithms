import java.util.*;

public class BFS {

    private static int distance(ArrayList<Integer>[] adj, int start, int goal) {

        return  BFS(adj, start, goal);

    }

    private static int BFS(ArrayList<Integer>[] adj, int start, int goal){

        Queue<Integer> queue = new LinkedList<Integer>();

        Iterator<Integer> vertex = null;

        boolean[] visited = new boolean[adj.length];

        int[] distances = new int[adj.length];
        Arrays.fill(distances, -1);

        distances[start] = 0;

        queue.add(start);

        while(! queue.isEmpty()){

            int currentNode = queue.remove();
            visited[currentNode] = true;
            vertex = adj[currentNode].listIterator();

            while(vertex.hasNext()){
                int x = vertex.next();
                if(!visited[x]){
                    queue.add(x);
                    distances[x] = distances[currentNode] + 1;
                    visited[x] = true;
                }
            }
        }
        return distances[goal];
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        System.out.println(distance(adj, x, y));
    }
}

