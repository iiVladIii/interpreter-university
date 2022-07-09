package InputOutput;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        strcontext context = new strcontext();
        Scanner scan = new Scanner(System.in);
        List<String> buffer = new ArrayList<>();
        while (scan.hasNextLine()){
            String myContext = scan.nextLine();
            if(myContext.equals("")){
                break;
            }
            String expression = context.evaluet(myContext);
            buffer.add(String.valueOf(expression));
        }
    }
}
