package com.company;

import java.util.HashMap;

public class Assignment extends Context {
    private static String varName;
    private static String varVal;
    public static HashMap<String,String> vars = new HashMap<>();
    public static String evaluate(String value) {
           while (value.contains("[")) {
               int pos = value.indexOf('[');
               int startpos = pos;
                   while (value.charAt(pos) != ']') {
                       pos++;
                   }
                   varName=value.substring(startpos,pos+1);
               switch (value.charAt(pos+1)){
                   case '=':
                       varVal = value.substring(pos+2);
                       if(varVal.contains("[")){
                           varVal=change(varVal);
                       }
                       if(varVal.contains("{")){
                           varVal = Context.evaluate(varVal);
                       }
                       if(!varVal.contains("{")&&varVal.contains("}")){
                           varVal.replace('}',' ');
                       }
                       vars.put(varName, varVal);
                       value = change(value);;
                       value = value.replace("=","");
                       break;
                   case 'i': double a = Double.parseDouble(String.valueOf(vars.get(varName)));
                             a++;
                             vars.put(varName,String.valueOf(a));
                             value = change(value);
                             value = value.replace("i","");
                             break;
                   case 'd':double b = Double.parseDouble(vars.get(varName).toString());
                       b--;
                       vars.put(varName,String.valueOf(b));
                       value= change(value);
                       value = value.replace("d","");
                       break;
                   default: value = change(value);
               }
               value = change(value);

    }
           //Context.evaluate(value);
        return change(value);
}
public static String change(String rep){
    for (String Name: vars.keySet()) {
        if (rep.contains(Name)){
         rep = rep.replace(Name,vars.get(Name));
        }
    }
    return rep;
}
}
