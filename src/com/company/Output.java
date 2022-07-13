package com.company;

public class Output extends Context{
    public static String evaluate(String s) {
         if (s.contains("{")) {
            s = Context.evaluate(s);
        }
        if (s.startsWith("[")) {
            s=Context.evaluate(s);
        }
        System.out.println(s);
         return s;
    }
      }


