//package week4;

import java.util.*;
import java.io.*;

public class MajorityElement {

	public static void main(String[] args) throws IOException{
		System.out.println(getMajorityElement());
		
	}
	
	
	public static long[] Input() throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer str = new StringTokenizer(br.readLine());
	    String s = str.nextToken();
	    
	    int length = Integer.parseInt(s);
	    
	    long[] elements = new long[length];
	    str = new StringTokenizer(br.readLine());
	    int i=0;
	    while(str.hasMoreTokens()){
	        s = str.nextToken();
	        elements[i] = Long.parseLong(s);
	        i++;
	    }
	    
	    return elements;
	}
	
	
	public static int getMajorityElement() throws IOException{
	    long[] ar = Input();
	    int occurance=1;
	    Arrays.sort(ar);
	    //System.out.print(Arrays.toString(ar));
	    for(int i=1; i<ar.length; i++){
	        //System.out.println("Ocuurance --> " + occurance);
	    	if(ar[i] == ar[i-1]){
	            occurance++;
	        }
	        
	        if(occurance > (ar.length/2)){
	            return 1;
	        }
	        
	        else if(ar[i] != ar[i-1]){
	            occurance=1;
	        }  
	        
	    }
	    return 0;
	}

    
}
