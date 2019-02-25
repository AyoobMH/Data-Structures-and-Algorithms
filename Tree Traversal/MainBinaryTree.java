import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainBinaryTree {

    public static void main(String[] args) throws IOException{


        FastScanner in = new FastScanner();

        int key[], left[], right[];
        int n = in.nextInt();

        key = new int[n];
        left = new int[n];
        right = new int[n];

        for (int i = 0; i < n; i++) {
            key[i] = in.nextInt();
            left[i] = in.nextInt();
            right[i] = in.nextInt();
        }

        new Thread(null, new Runnable() {
            public void run() {
                try {
                    getOrders(key, left, right);
                } catch (Exception e) {
                }
            }
        }, "1", 1 << 26).start();
    }

    public static void getOrders(int[] key, int[] left, int[] right){
        traverseInOrder(0, key, left, right);
        System.out.println();
        traversePreOrder(0, key, left, right);
        System.out.println();
        traversePostOrder(0, key, left, right);
    }

    public static void traverseInOrder(int root, int[] key, int[] left, int[] right) {

        if(left[root] != -1){
            traverseInOrder(left[root], key, left, right);
        }

        System.out.print(key[root] +" ");

        if(right[root] != -1){
            traverseInOrder(right[root], key, left, right);
        }
    }

    public static void traversePreOrder(int root, int[] key, int[] left, int[] right) {
        System.out.print(key[root] + " ");

        if(left[root] != -1){
            traversePreOrder(left[root], key, left, right);
        }

        if(right[root] != -1){
            traversePreOrder(right[root], key, left, right);
        }
    }

    public static void traversePostOrder(int root, int[] key, int[] left, int[] right) {
        if(left[root] != -1){
            traversePostOrder(left[root], key, left, right);
        }

        if(right[root] != -1){
            traversePostOrder(right[root], key, left, right);
        }

        System.out.print(key[root] + " ");


    }
}

class FastScanner {
    StringTokenizer tok = new StringTokenizer("");
    BufferedReader in;

    FastScanner() throws IOException{
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() throws IOException {
        while (!tok.hasMoreElements())
            tok = new StringTokenizer(in.readLine());
        return tok.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}
