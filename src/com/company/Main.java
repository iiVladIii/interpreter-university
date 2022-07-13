package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            String[] words = str.split(" ");
            String command = "";
            for (String word : words) {
                command = command + word;
            }
            int leftBrackFig = 0;
            int rightBrackFig = 0;
            int leftBrackSq = 0;
            int rightBrackSq = 0;
            int leftBrackCi = 0;
            int rightBrackCi = 0;
            for (char elem : command.toCharArray()) {
                if (elem == '{') leftBrackFig++;
                if (elem == '}') rightBrackFig++;
                if (elem == '[') leftBrackSq++;
                if (elem == ']') rightBrackSq++;
                if (elem == '(') leftBrackCi++;
                if (elem == ')') rightBrackCi++;
            }
            if (leftBrackFig == rightBrackFig && leftBrackSq == rightBrackSq && leftBrackCi == rightBrackCi) Context.evaluate(command);
            else Output.evaluate(Errors.getError("#3"));
        }
    }

}