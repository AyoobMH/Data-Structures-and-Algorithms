/*
In order to make a heap sort algrithm you need perform two main actions: 
1- create a heap.
2- start extracting the maximum elements and reconstruct the heap.

- In order to construct a heap, you will need the following.
1- Accepting an array input.
2- 

*/

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) throws IOException{
	    
		FastScanner scanner = new FastScanner();
		int[] arr = scanner.readInput();
		
		HeapSort heapSort = new HeapSort();
		
		heapSort.sort(arr);
		
		printArray(arr);
	}
	
	public static void printArray(int[] arr){
	    for(int i=0; i<arr.length; i++){
	        System.out.print(arr[i] + " ");
	    }
	}
}

class HeapSort{
    
    public void sort(int[] arr){
        int n = arr.length;
        //Firslty, construct the heap.
        for(int i=(n/2)-1; i>=0; i--){
            heapify(arr, n, i);
        }
        
        //Start extracting the maximum elements from the tree
        for(int i=n-1; i>=0; i--){
            
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            heapify(arr, i, 0);
            
        }
    }
    
    public void heapify(int[] arr, int n, int i){
        /*
        1-n represents the length of the array. 
        2-i represents the index of the largest element in the heap.
        3-Usually we represent elements by their index.
        */
        
        int parent = i;
        int leftChild = 2*i + 1;
        int rightChild = 2*i + 2;
        
        // Check if the leftChild value is not greater than parent value, and make sure that its index belongs to the array.
        if(leftChild < n && arr[leftChild] > arr[parent]){
            parent = leftChild;
        }
        
        // Check if the rightChild value is not greater than parent value, and make sure that its index belongs to the array.
        if(rightChild < n && arr[rightChild] > arr[parent]){
            parent = rightChild;
        }
        
        //Check if the current parent is not the same as the updated parent.
        if(parent != i){
            
            int swap = arr[parent];
            arr[parent] = arr[i];
            arr[i] = swap;
            
            
            heapify(arr, n, parent);
        }
        
    }
}

class FastScanner{
    int[] array;
    
    public FastScanner(){
    }
    
    public int[] readInput() throws IOException{
        
        String holdToken = "";
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        holdToken = str.nextToken();
        int size = Integer.parseInt(holdToken);
        
        this.array = new int[size];
        
        str = new StringTokenizer(br.readLine());
        
        for(int i=0; i<size; i++){
            holdToken = str.nextToken();
            this.array[i] = Integer.parseInt(holdToken); 
        }
        
        return this.array;
    }
    
    public int[] getArray(){
        return this.array;
    }
    
}