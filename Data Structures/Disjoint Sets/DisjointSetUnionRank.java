/*
This is an implementation of disjoint sets data structure. The following code was implemented based on an online course from coursera
-Data Structures and Algorithms- 
The code represents the -Union by Rank- method
*/


import java.io.*;
import java.util.*;

class DisjointUnionSets{

	int[] rank, parent;
	int n;

	public DisjointUnionSets(int n){
		rank = new int[n];
		parent = new int[n];
		this.n = n;
		makeSet();
	}

	void makeSet(){
		for (int i=0; i<n; i++){
			parent[i] = i;
		}
	}

	int find(int i){
		while(parent[i] != i){
			i = parent[i];

		}
		return i;
	}

	void union(int source, int destination){
		int sourceId = find(source);
		int destinationId = find(destination);

		if(sourceId == destinationId){
			return;
		}

		if(rank[sourceId] > rank[destinationId]){
			parent[destinationId] = sourceId;
		}

		else{
			parent[sourceId] = destinationId;
			if(rank[sourceId] == rank[destinationId]){
				rank[destinationId] += 1;
			}
		}

	}

	void printChild(){
		System.out.print("Child  : ");
		for(int i=0; i<this.n; i++){
			System.out.print(i + " ");
		}
		System.out.println();
	}

	void printParent(){
		System.out.print("Parent : ");
		for(int i : parent){
			System.out.print(i + " ");
		}
		System.out.println();
	}

	void printRank(){
		System.out.print("Rank   : ");
		for(int i : rank){
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("--------------------");

	}
}

// Driver code
public class DisjointSetUnionRank
{
	public static void main(String[] args)
	{

		int n = 7;
		DisjointUnionSets dus = new DisjointUnionSets(n);

		dus.printChild();
		dus.printParent();
		dus.printRank();


        /*
        dus.union(2,4);
        dus.printChild();
        dus.printParent();
        dus.printRank();

        dus.union(5,2);
        dus.printChild();
        dus.printParent();
        dus.printRank();

        dus.union(3,1);
        dus.printChild();
        dus.printParent();
        dus.printRank();

        dus.union(2,3);
        dus.printChild();
        dus.printParent();
        dus.printRank();

        dus.union(2,6);
        dus.printChild();
        dus.printParent();
        dus.printRank();
        */





    }
}
