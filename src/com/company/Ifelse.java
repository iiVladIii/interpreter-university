package com.company;

public class Ifelse extends Context{
    private static boolean Conditional;
    private static String success;
    private static String failure;

    public static String evaluate(String s){
        String[] operators = s.split(":");
        if (!operators[0].contains("<") && !operators[0].contains(">") && !operators[0].contains("?") && !operators[0].contains("~")) {
            return Context.evaluate("#3");
        }
        else if(operators.length!=3){
            return Context.evaluate("#1");
        }
        else{
        Conditional = exec(operators[0]);
        success = operators[1];
        failure = operators[2];
          if(Conditional){
            return Context.evaluate(success);
        }
           else {
            return Context.evaluate(failure);
        }
        }
    }

    static boolean exec(String conditional){
        if(conditional.contains("[")){
            conditional = Assignment.change(conditional);
        }
        switch (conditional){
            case "true": return true;
            case "false": return false;
            default:
                int pos = 0;
                boolean findPosition = false;
                while (!findPosition){
                    if (conditional.charAt(pos) != '>' && conditional.charAt(pos) != '<' && conditional.charAt(pos) != '?' && conditional.charAt(pos) != '~' ) {
                        pos++;
                    } else  findPosition = true;
                }
                double FirstValue = Double.parseDouble(conditional.substring(0,pos));
                double SecondValue = Double.parseDouble(conditional.substring(pos+1));
                switch (conditional.charAt(pos)){
                    case '<': return FirstValue<SecondValue;
                    case '>': return FirstValue>SecondValue;
                    case '?': return FirstValue==SecondValue;
                    case '~': return FirstValue!=SecondValue;
                }
        }
        return false;
    }
   }

