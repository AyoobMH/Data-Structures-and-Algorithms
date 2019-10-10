/*
In order to make a heap sort algorithm you need to perform two main actions:
1- create a heap.
2- start extracting the maximum elements and reconstruct the heap.

- In order to construct a heap, you will need the following.
1- Accepting an array input.
2-

*/

import java.io.*;
import java.util.*;

class MinimumHeap {
	public static void main (String[] args) throws IOException{

		FastScanner scanner = new FastScanner();
		int[] arr = scanner.readInput();
		int[] arrCopy = new int[arr.length];

		System.arraycopy( arr, 0, arrCopy, 0, arr.length );

		Heap heap = new Heap();

		heap.createMinimumHeap(arr);

		if(compare(arr, arrCopy)){
		    System.out.print(0);
		}
		else{
		    heap.printResult();
		}


	}

	public static boolean compare(int[] arr, int[] arrCopy){
	    for(int i=0; i<arr.length; i++){
	        if(arr[i] != arrCopy[i]){
	            return false;
	        }
	    }
	    return true;
	}
}

class Heap{
    int count=0;
    ArrayList<Integer> result = new ArrayList<Integer>();

    public void createMinimumHeap(int[] arr){
        int n = arr.length;
        //Firslty, construct the heap.
        for(int i=(n/2)-1; i>=0; i--){
            heapify(arr, n, i);
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
        if(leftChild < n && arr[leftChild] < arr[parent]){
            parent = leftChild;
        }

        // Check if the rightChild value is not greater than parent value, and make sure that its index belongs to the array.
        if(rightChild < n && arr[rightChild] < arr[parent]){
            parent = rightChild;
        }

        //Check if the current parent is not the same as the updated parent.
        if(parent != i){

            this.count++;
            result.add(i); result.add(parent);

            //System.out.println(i + " " + parent);
            int swap = arr[parent];
            arr[parent] = arr[i];
            arr[i] = swap;


            heapify(arr, n, parent);
        }

    }

    public void printResult(){
        System.out.println(this.count);
        for(int i=0; i<result.size(); i++){
            System.out.print(result.get(i) + " ");
            System.out.print(result.get(++i) + " ");
            System.out.println();
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
