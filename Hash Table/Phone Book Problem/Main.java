import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        //System.out.println("Hello World!");
        FastScanner scanner = new FastScanner();
        scanner.queriesNumber();

        Hashtable<Integer,String> phoneBook = new Hashtable<Integer,String>();

        for(int i=0; i<scanner.queries; i++){

            scanner.readQueries();

            if(scanner.queryType.equals("add")){
                phoneBook.put(scanner.getNumber(), scanner.getName());
            }
            else if(scanner.queryType.equals("find")){
                if(phoneBook.containsKey(scanner.getNumber())){
                    System.out.println(phoneBook.get(scanner.getNumber()));
                }
                else{
                    System.out.println("not found");
                }
            }
            else{
                phoneBook.remove(scanner.getNumber());
            }

        }
    }
}
