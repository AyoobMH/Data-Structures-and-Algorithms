/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

public class FastScanner{

    private int number;
    private String name;
    private String holdToken;
    private BufferedReader reader;
    private StringTokenizer tokenizer;
    int queries;
    String queryType;


    public FastScanner(){
        this.number = 0;
        this.name = "";
        this.holdToken = "";
        this.queries = 0;
        this.queryType = "";
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    int getNumber(){
        return this.number;
    }

    String getName(){
        return this.name;
    }

    void queriesNumber() throws IOException{
        this.tokenizer = new StringTokenizer(this.reader.readLine());
        this.holdToken = this.tokenizer.nextToken();

        this.queries = Integer.parseInt(this.holdToken);
    }

    void readQueries() throws IOException{
        this.tokenizer = new StringTokenizer(this.reader.readLine());

        this.queryType = this.tokenizer.nextToken();

        if(this.queryType.equals("add")){
            //add the number and name to the phone book
            //NOTE : if the number already exists, override the name.
            this.number = Integer.parseInt(this.tokenizer.nextToken());
            this.name = this.tokenizer.nextToken();
        }

        else if(this.queryType.equals("find")){
            //find the number
            this.number = Integer.parseInt(this.tokenizer.nextToken());

        }

        else{
            //delete the number record from the phone book.
            this.number = Integer.parseInt(this.tokenizer.nextToken());
        }

    }





}