//package theMain;

import java.io.*;
import java.util.*;
public class FibonacciNumber {

	public static void main(String[] args) throws IOException{
		System.out.print(getFibonacci());
	}

	public static long getFibonacci() throws IOException{
	    	
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    long n = Long.parseLong(br.readLine());
	    n = n%60;
	    long Fibonacci=1,a=0,b=1;
	    
	    if(n==0) {
	    	return 0;
	    }
			
			for(int i=0; i<n-1; i++){
				Fibonacci = a+b;
				a=b;
				b = Fibonacci;
			}
			return Fibonacci;

	}	
}
