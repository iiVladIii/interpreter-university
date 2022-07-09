package org.example;

public class Context {
    expression evaluet(String s){
        int pos = s.length()-1;
        while(pos>0){
            if(Character.isDigit(s.charAt(pos))){
                pos--;
            }
            else {
                expression fisrt = evaluet(s.substring(0,pos));
                expression second = evaluet(s.substring(pos+1,s.length()));
                char operator = s.charAt(pos);
                switch(operator){
                    case '+': return new plus(fisrt,second);
                    case '-': return new minus(fisrt,second);
                    case '*': return new multiplication(fisrt,second);
                    case '/': return new division(fisrt,second);
                    default: //todo mistakes
                }
            }
        }
        int result = Integer.valueOf(s);
        return new number(result);
    }
}
