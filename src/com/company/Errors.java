package com.company;

public class Errors {
    private static String error1 = "Неполная комманда";
    private static String error2 = "Арифметическа ошибка";
    private static String error3 = "Ошибка в синтаксисе";

    public static String getError(String code) {
        return switch (code) {
            case "#1" -> error1;
            case "#2" -> error2;
            case "#3" -> error3;
            default -> "";
        };
    }

}
