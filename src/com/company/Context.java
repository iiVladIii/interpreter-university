package com.company;

public class Context {
    private static String[] commands = new String[]{"math","log","assignment","if-else","while"};

    static String ContextValue;
    public static String evaluate(String s){
        int pos = 0;
        if (s.startsWith("[")) {
            if (!s.endsWith("[]i") && !s.endsWith("[]d")){
                if (s.contains("=") && !s.endsWith("=")) {
                    s = Assignment.evaluate(s);
                } else if (s.contains("]i") || s.contains("]d")) {
                    s = Assignment.evaluate(s);
                } else  Output.evaluate(Errors.getError("#3"));
            } else Output.evaluate(Errors.getError("#3"));
        } else
        while (pos < s.length()) {
                if (s.charAt(pos) != '{') {
                    pos++;
                } else {
                    String expression = s.substring(0, pos);
                    for (int i = 0; i < commands.length; i++) {
                        if (expression.contains(commands[i])) {
                            expression = commands[i];
                        }
                    }
                    String value = s.substring(pos + 1, s.length() - 1);
                    ContextValue = value;
                    switch (expression) {
                        case "math":
                            value = Mathem.evaluate(value);
                            return value;
                        case "log":
                            if (s.contains("[")) {
                                value = Assignment.change(value);
                            }
                            Output.evaluate(value);
                            return value;
                        case "if-else":
                            value = Ifelse.evaluate(value);
                            return value;
                        case "assignment":
                            value = Assignment.evaluate(value);
                            return value;
                        case "while":
                            While.evaluate(value);
                            return value;
                        case "#1":
                            Output.evaluate(Errors.getError("#1"));
                        case "#2":
                            Output.evaluate(Errors.getError("#2"));
                        case "#3":
                            Output.evaluate(Errors.getError("#3"));
                            return value;
                        default:
                            System.out.println(Errors.getError("#3"));
                            return value;

                    }
                }
            }
        return ContextValue;}

    }

