/*
1. index values min = 0, max = array.length - 1
2. start a while loop.. while(max>=min).. when max < min
   it means your targetNumber is not in the list....
3. if guess == target number end and return the index
4. if not, if guess < target numbers
   then, minIndex = guess +1
5. otherwise, maxIndex = guess -1
*/

import java.io.*;
import java.util.*;

public class BinarySearch {

	static int binarySearch(int[] arrayToSearch, int number) {

        int minIndex=0, maxIndex = arrayToSearch.length-1;
        long targetNumber=number;
        int guess=0;

        while(maxIndex >= minIndex){

            guess = (maxIndex + minIndex)/2;
            //System.out.println("minIndex --> " + minIndex + " / guess --> " + guess  + " / maxIndex --> " + maxIndex + " / number to search --> " + targetNumber);
            if(arrayToSearch[guess] == targetNumber){
                return guess;
            }
            else if(arrayToSearch[guess] < targetNumber){
                minIndex = guess +1;
            }
            else{
                maxIndex = guess -1;
            }

        }
        return -1;
        // in case number is not found in the array...
	}

	static int linearSearch(int[] a, int x) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		int m = scanner.nextInt();
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = scanner.nextInt();
		}
		for (int i = 0; i < m; i++) {
			//replace with the call to binarySearch when implemented
			System.out.print(binarySearch(a, b[i]) + " ");
		}
	}
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
