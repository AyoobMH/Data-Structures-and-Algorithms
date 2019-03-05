import java.io.*;
import java.util.*;

public class MaximumAdvertisementRevenue {

	public static void main(String[] args) throws IOException{
		input();
	}

	public static long getMaxRevenue(int n, long a[], long b[]) throws IOException{
        Arrays.sort(a); Arrays.sort(b);
        long sum=0;
        for(int i=0; i<n; i++){
            sum += (a[i] * b[i]);
        }

        return sum;

	}

	public static void input() throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    long[] a = new long[n];
	    long[] b= new long[n];

	    String A = "", B="";
	    StringTokenizer str;

	    A = br.readLine();
	    str = new StringTokenizer(A);
	    int i=-1;

	    while(str.hasMoreTokens()){
	        A = str.nextToken();
	        a[++i] = Long.parseLong(A);
	    }

	    i=-1;
	    B = br.readLine();
	    str = new StringTokenizer(B);
	    while(str.hasMoreTokens()){
	        B = str.nextToken();
	        b[++i] = Long.parseLong(B);
	    }

	    System.out.print(getMaxRevenue(n, a, b));
	}

}
