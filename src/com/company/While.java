package com.company;

public class While extends Context{
    private static boolean Conditional;
    public static String evaluate(String value) {
            String[] operators = value.split(":");
            Conditional = exec(operators[0]);
            while (Conditional){
                for(int i =1;i<operators.length;i++){
                    Context.evaluate(operators[i]);
                }
                Conditional=exec(operators[0]);
        }
        return "log{end with while}";
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
                if (conditional.substring(pos+1, conditional.length()-1).contains(".")) {
                    SecondValue = Double.parseDouble(conditional.substring(pos+1, conditional.length()-1));
                }
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
