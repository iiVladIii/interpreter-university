package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Context context = new Context();
        Scanner scan = new Scanner(System.in);
        List<String> buffer = new ArrayList<>();
        while (scan.hasNextLine()){
            String myContext = scan.nextLine();
            if(myContext.equals("")){
                break;
            }
            expression expression = context.evaluet(myContext);
            buffer.add(String.valueOf(expression.interpreted()));
        }
        for(int i =0; i< buffer.size();i++){
            System.out.println(buffer.get(i));
        }
    }
}