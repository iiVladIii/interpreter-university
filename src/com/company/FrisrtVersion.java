package com.company;

import java.text.DecimalFormat;

public class FrisrtVersion {
    public static void main(String[] args){
        Context context = new Context ();
        DecimalFormat dc = new DecimalFormat("######.######"); // для округления
        Expression expr = context.evaluate("5/2");
        System.out.println(dc.format(expr.interpret()));
    }

    interface Expression {
        double interpret();
    }

    static class NumberExpression implements Expression {
        double number;

        public NumberExpression(double number) {
            this.number = number;
        }

        public double interpret() {
            return number;
        }


    }

    static class MinusExpression implements Expression {
        Expression left;
        Expression right;

        public MinusExpression(Expression left, Expression right) {
            this.right = right;
            this.left = left;
        }

        public double interpret() {
            return left.interpret() - right.interpret();
        }
    }

    static class PlusExpression implements Expression {
        Expression left;
        Expression right;

        public PlusExpression(Expression left, Expression right) {
            this.right = right;
            this.left = left;
        }

        public double interpret() {
            return left.interpret() + right.interpret();
        }
    }

    static class MultiplicationExpression implements Expression {
        Expression left;
        Expression right;

        public MultiplicationExpression(Expression left, Expression right) {
            this.right = right;
            this.left = left;
        }

        public double interpret() {
            return left.interpret() * right.interpret();
        }
    }

    static class DivisionExpression implements Expression {
        Expression left;
        Expression right;

        public DivisionExpression(Expression left, Expression right) {
            this.right = right;
            this.left = left;
        }

        public double interpret() {
            return left.interpret() / right.interpret();
        }
    }
    public static class Context {
        Expression evaluate(String s) {
            int pos = s.length() - 1;
            while (pos > 0) {
                if (Character.isDigit(s.charAt(pos))  || s.charAt(pos) == '.')  {
                    pos--;
                } else {
                    Expression left = evaluate(s.substring(0, pos));
                    Expression right = new NumberExpression(Double.valueOf(s.substring(pos + 1, s.length())));
                    char operator = s.charAt(pos);
                    switch (operator) {
                        case '*':
                            return new MultiplicationExpression(left, right);
                        case '/':
                            return new DivisionExpression(left, right);
                        case '+':
                            return new PlusExpression(left, right);
                        case '-':
                            return new MinusExpression(left, right);
                    }
                }
            }
            double result = Double.valueOf(s);

            return new NumberExpression(result);
        }
    }
}




//package com.company;
//
//import java.text.DecimalFormat;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
////Единственное чем отличается от видоса, так это возможность работы с double
//
//    public static void main(String[] args) {
//        String expressionText = "122 + 4";
//        List<Lexeme> lexemes = lexAnalyze(expressionText);
//
//        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
//        System.out.println(expr(lexemeBuffer));
//        System.out.println(lexemes);
//    }
//
//    public enum LexemeType {
//        LEFT_BRACKET, RIGHT_BRACKET, OP_MINUS,
//        OP_PLUS, OP_MULTI, OP_DIV,
//        NUMBER, EOF;
//    }
//
//    public static class Lexeme {
//        LexemeType type;
//        String value;
//
//        public Lexeme(LexemeType type, String value) {
//            this.type = type;
//            this.value = value;
//        }
//
//        public Lexeme(LexemeType type, Character value) {
//            this.type = type;
//            this.value = value.toString();
//        }
//
//        @Override
//        public String toString() {
//            return "Lexeme{" +
//                    "type=" + type +
//                    ", value='" + value + '\'' +
//                    '}';
//        }
//    }
//
//    public static class LexemeBuffer {
//        private int pos;
//
//        public List<Lexeme> lexemes;
//
//        public LexemeBuffer(List<Lexeme> lexemes) {
//            this.lexemes = lexemes;
//        }
//
//        public Lexeme next() {
//            return lexemes.get(pos++);
//        }
//
//        public void back() {
//            pos--;
//        }
//
//        public int getPos() {
//            return pos;
//        }
//    }
//
//    public static List<Lexeme> lexAnalyze(String expText) {
//        ArrayList<Lexeme> lexemes = new ArrayList<>();
//        int pos = 0;
//        while (pos < expText.length()) {
//            char c = expText.charAt(pos);
//            switch (c) {
//                case '(':
//                    lexemes.add(new Lexeme(LexemeType.LEFT_BRACKET, c));
//                    pos++;
//                    continue;
//                case ')':
//                    lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, c));
//                    pos++;
//                    continue;
//                case '+':
//                    lexemes.add(new Lexeme(LexemeType.OP_PLUS, c));
//                    pos++;
//                    continue;
//                case '-':
//                    lexemes.add(new Lexeme(LexemeType.OP_MINUS, c));
//                    pos++;
//                    continue;
//                case '*':
//                    lexemes.add(new Lexeme(LexemeType.OP_MULTI, c));
//                    pos++;
//                    continue;
//                case '/':
//                    lexemes.add(new Lexeme(LexemeType.OP_DIV, c));
//                    pos++;
//                    continue;
//                default:
//                    if (c <= '9' && c >= '0') {
//                        StringBuilder sb = new StringBuilder();
//                        do {
//                            sb.append(c);
//                            pos++;
//                            if (pos >= expText.length()) {
//                                break;
//                            }
//                            c = expText.charAt(pos);
//                        } while (c <= '9' && c >= '0');
//                        lexemes.add(new Lexeme(LexemeType.NUMBER, sb.toString()));
//                    } else {
//                        if (c != ' ') {
//                            throw new RuntimeException("Uncexpected character: " + c);
//                        }
//                        pos++;
//                    }
//            }
//        }
//        lexemes.add(new Lexeme(LexemeType.EOF, ""));
//        return lexemes;
//    }
//
//    public static int expr(LexemeBuffer lexemes) {
//        Lexeme lexeme = lexemes.next();
//        if (lexeme.type == LexemeType.EOF) {
//            return 0;
//        } else {
//            lexemes.back();
//            return plusMinus(lexemes);
//        }
//    }
//
//    public static int plusMinus(LexemeBuffer lexemes) {
//        int value = multDiv(lexemes);
//        while (true) {
//            Lexeme lexeme = lexemes.next();
//            switch (lexeme.type) {
//                case OP_PLUS:
//                    value += multDiv(lexemes);
//                case OP_MINUS:
//                    value -= multDiv(lexemes);
//                default:
//                    lexemes.back();
//                    return value;
//            }
//        }
//    }
//
//    public static int multDiv(LexemeBuffer lexemes) {
//        int value = factor(lexemes);
//        while (true) {
//            Lexeme lexeme = lexemes.next();
//            switch (lexeme.type) {
//                case OP_MULTI:
//                    value *= factor(lexemes);
//                case OP_DIV:
//                    value /= factor(lexemes);
//                default:
//                    lexemes.back();
//                    return value;
//            }
//        }
//    }
//
//    public static int factor(LexemeBuffer lexemes) {
//        Lexeme lexeme = lexemes.next();
//        switch (lexeme.type) {
//            case NUMBER:
//                return Integer.parseInt(lexeme.value);
//            case LEFT_BRACKET:
//                int value = expr(lexemes);
//                lexeme = lexemes.next();
//                if (lexeme.type != LexemeType.RIGHT_BRACKET) {
//                    throw new RuntimeException("Unexpected token " + lexeme.value +
//                            "at position: " + lexemes.getPos());
//                }
//                return value;
////            case OP_PLUS:
////                int value = expr(lexemes)
////                return ;
//            default:
//                throw new RuntimeException("Unexpected token " + lexeme.value +
//                        "at position: " + lexemes.getPos());
//        }
//    }
//
//
//}
