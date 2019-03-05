import java.util.*;
import java.io.*;

public class is_bst {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
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

    class IsBST {

        int nodes;
        int[] key;
        int[] left;
        int[] right;
        int[] inOrderTraverse;
        int track=0;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            key = new int[nodes];
            left = new int[nodes];
            right = new int[nodes];
            inOrderTraverse = new int[nodes];
            
            for (int i = 0; i < nodes; i++) {
                key[i] = in.nextInt();
                left[i] = in.nextInt();
                right[i] = in.nextInt();
            }
        }

        boolean isBinarySearchTree() {
            
          if(key.length > 1){
              traverseInOrder(0, key, left, right);
              for(int i=1; i<inOrderTraverse.length; i++){
                  if(inOrderTraverse[i-1] > inOrderTraverse[i]){
                      return false;
                  }
              }
          }
          
          return true;
        }
        
        void traverseInOrder(int root, int[] key, int[] left, int[] right) {

            if(left[root] != -1){
                traverseInOrder(left[root], key, left, right);
            }
    
            inOrderTraverse[track] = key[root];
            track++;
    
            if(right[root] != -1){
                traverseInOrder(right[root], key, left, right);
            }
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
