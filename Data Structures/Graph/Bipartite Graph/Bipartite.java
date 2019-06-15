import java.util.*;

public class Bipartite {
    private static int bipartite(ArrayList<Integer>[] adj, int[] colors) {
        //write your code here
        Iterator<Integer> vertex = null;
        for(int i=1; i<adj.length; i++){
            vertex = adj[i].listIterator();
            while (vertex.hasNext()){
                int node = vertex.next();
                if(colors[i] == colors[node]){
                    return 0;
                }
            }
        }
        return 1;
    }

    private static int[] colorGraph(ArrayList<Integer>[] adj, int[] colors){
        Iterator<Integer> vertex = null;
        for(int i=1; i<adj.length; i++){
            vertex = adj[i].listIterator();
            if(colors[i] == -1){
                colors[i] = 0;
                while (vertex.hasNext()){
                    int node = vertex.next();
                    colors[node] = 1;
                }
            }
            else{
                while(vertex.hasNext()){
                    int node = vertex.next();
                    if(colors[node] == -1){
                        if(colors[i] == 0){
                            colors[node] = 1;
                        }
                        if(colors[i] == 1){
                            colors[node] = 0;
                        }
                    }
                }

            }
        }
        return colors;
    }

    public static void main(String[] args) {
        // For colors values, in the colores array, 0 refers to white and 1 refers to black...

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] colors = new int[n+1];
        Arrays.fill(colors, -1);
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

        colors = colorGraph(adj, colors);

//        for(int i=1; i<colors.length; i++){
//            System.out.println(i + " " + colors[i]);
//        }

        System.out.println(bipartite(adj, colors));
    }
}

