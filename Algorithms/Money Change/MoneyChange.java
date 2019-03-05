import java.io.*;
import java.math.*;
import java.util.*;


public class MoneyChange {

    public static void main(String[] args) throws IOException{
        System.out.print(ChangeMoney());
    }

    public static int ChangeMoney()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int num = Integer.parseInt(line);

        int countChange=0;
        int count=0;

        if(num/10 >=1){
            count += (num/10 );
            num %= 10;
            System.out.println(count + " " + num+"  ");
        }
        if(num/5 >=1){
            count += (num/5);
            num %= 5;
            System.out.println(count + " " + num+"  ");
        }

        count += num;
        System.out.println(count + " " + num+"  ");

        return count;
    }
}
