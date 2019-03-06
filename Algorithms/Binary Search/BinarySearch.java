import java.util.*;
import java.io.*;
// WORKS perfectly......
public class BinarySearch {

	public static void main(String[] args) throws IOException{
		//1. index values min = 0, max = array.length - 1
        //2. start a while loop.. while(max>=min).. when max < min
        //   it means your targetNumber is not in the list....
        //3. if guess == target number end and return the index
        //4. if not, if guess < target numbers
        //   then, minIndex = guess +1
        //5. otherwise, maxIndex = guess -1


        long[] arrayToSearch = numbers();
        long[] targetNumbers = targetNumbers();
        long result = 0L;
        for(int i=0; i<targetNumbers.length; i++){
            result = (binarySearch(arrayToSearch, targetNumbers[i]));
            System.out.print(result + " ");
        }
	}


	// make reader static to read the whole input...
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// read the input of nuumbers to search it....
	public static long[] numbers() throws IOException{

	    StringTokenizer str = new StringTokenizer(br.readLine());
	    int arrayLength = Integer.parseInt(str.nextToken());
	    long[] numbers = new long[arrayLength];
	    int i=0;
	    while(str.hasMoreTokens()){
	        long number = Long.parseLong(str.nextToken());
	        numbers[i] = number;
	        i++;
	    }
	    return numbers;
	}

	// read the input numbers to be searched....
	public static long[] targetNumbers() throws IOException{

	    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer str = new StringTokenizer(br.readLine());
	    int arrayLength = Integer.parseInt(str.nextToken());
	    long[] targetNumbers = new long[arrayLength];
	    int i=0;
	    while(str.hasMoreTokens()){
	        long number = Long.parseLong(str.nextToken());
	        targetNumbers[i] = number;
	        i++;
	    }
	    return targetNumbers;
	}

	// search
    public static long binarySearch(long[] arrayToSearch, long number) throws IOException{

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


}
