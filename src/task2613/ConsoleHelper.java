package task2613;

import task2613.exception.InterruptOperationException;

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

    public static String readString() throws InterruptOperationException {
        String in = "";
        try {
            in = bis.readLine();
            if (in.equalsIgnoreCase("exit")) throw new InterruptOperationException();
        } catch (IOException e) {
            //по заданию "ничего не делать при возникновении исключения".
        }
        return in;
    }

    /*
    Запрашивает у пользователя код валюты и проверят правильность ввода.
     */
    public static String askCurrencyCode() throws InterruptOperationException {
        String code;
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
    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        while (true) {
            ConsoleHelper.writeMessage("Введите требуемый номинал и количество купюр в " + currencyCode + ": ");
            String s = ConsoleHelper.readString();
            String[] arr = s.split(" ");
            try {
                int i1 = Integer.parseInt(arr[0]);
                int i2 = Integer.parseInt(arr[1]);
                if (i1 > 0 & i2 > 0) return arr;
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Данные некорректны. Повторите.");
            }
        }
    }

    /*
    Запрос операции у пользователя. Принимает значения [1:4], иначе IllegalArgumentException.
     */
    public static Operation askOperation() throws InterruptOperationException {
        while (true) {
            writeMessage("Введите номер операции (1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT): ");
            try {
                Integer i = Integer.parseInt(readString());
                return Operation.getAllowableOperationByOrdinal(i);
            } catch (IllegalArgumentException e) {
                writeMessage("Неверная операция. Повторите.");
            }
        }
    }
}
