//package week3;

import java.util.*;
import java.io.*;

public class MaximumNumberPrizes {

	public static void main(String[] args) throws IOException{
		list();
	}
	
	
	
	public static int list() throws IOException{
		Scanner inp = new Scanner(System.in);
		long n = inp.nextLong();
		
		if (n == 0 ) {
			System.out.println(n + "\n" + n);
			return (int) n;
		}
		Long num=1L;
		long sum=0;
		long c=0;
		StringBuilder whole = new StringBuilder();
		while(true) {
			sum+=num;
			long check = (n-sum);
			//System.out.print(sum + " ");
			if(num >= check) {
				if(check == 0) {
					whole.append(n-(sum-num) + " ");
					c++;
					break;
				}
				whole.append(n-(sum-num) + " ");
				c++;
				break;
			}
			whole.append(num + " ");
			c++;
			num++;
			
		}
		
		System.out.println(c);
		System.out.println(whole);
		
		return 0;
		
		
	}
}
