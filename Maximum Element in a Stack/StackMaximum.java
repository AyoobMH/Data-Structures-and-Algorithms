import java.io.*;
import java.util.*;

class StackMaximum {
	public static void main (String[] args) {

				// Reading input...
				Scanner inp = new Scanner(System.in);
        String N = inp.nextLine();
        //System.out.println(N);
        String s = "";

        Stack<Integer> mainStack = new Stack<Integer>();
        Stack<Integer> trackStack = new Stack<Integer>();

        while(inp.hasNextLine()){
            s = inp.nextLine();
            String[] type = s.split(" ");

            if(type[0].equals("push")){
                mainStack.push(Integer.parseInt(type[1]));
                if(mainStack.size() == 1){
                    trackStack.push(Integer.parseInt(type[1]));
                }
                else{
                    if(trackStack.empty()){
                        trackStack.push(Integer.parseInt(type[1]));
                    }
                    else{
                        if(Integer.parseInt(type[1]) >= trackStack.peek()){
                            trackStack.push(Integer.parseInt(type[1]));
                        }
                        else{
                            trackStack.push(trackStack.peek());
                        }
                    }
                }

            }

            else if(!mainStack.empty() && type[0].equals("pop") ){
                mainStack.pop();
                trackStack.pop();

            }

            else if(type[0].equals("max")){
                System.out.println(max(trackStack));
            }

        }


	}

	public static int max(Stack<Integer> st){
        return st.peek();
    }
}
