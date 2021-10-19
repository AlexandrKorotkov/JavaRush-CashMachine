package task2613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

 */
public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    //метод такой по заданию.
    public static String readString() {
        String in = "";
        try {
            in = bis.readLine();
        } catch (IOException e) {
        }
        return in;
    }

    /*
    Запрашивает у пользователя код валюты и проверят правильность ввода.
     */
    public static String askCurrencyCode() {
        String code = "";
        while (true) {
            writeMessage("Введите код валюты, состоящий из 3-х символов: ");
            code = readString();
            if (code.length() == 3) break;
            writeMessage("Введен неверный код. Повторите ввод: ");
        }
        return code.toUpperCase();
    }

    /*
    Предлагает ввести 2 целых положительных числа. Первое - номинал, второе - количество банкнот.
     */
    public static String[] getValidTwoDigits(String currencyCode) {
        while (true) {
            ConsoleHelper.writeMessage("Введите требуемый номинал и количество купюр в " + currencyCode+": ");
            String s = ConsoleHelper.readString();
            String[] arr = s.split(" ");
            try {
                Integer i1 = Integer.parseInt(arr[0]);
                Integer i2 = Integer.parseInt(arr[1]);
                if (i1 >0 & i2 >0) return arr;
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Данные некорректны. Повторите.");
            }
        }
    }
}
