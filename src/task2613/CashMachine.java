package task2613;

import java.util.Locale;

/*
Операции, которые будем поддерживать, следующие:
поместить деньги, снять деньги, показать состояние банкомата.
Также будем поддерживать мультивалютность.
Купюрами будем оперировать теми, которые поместим в банкомат.
Если для снятия требуемой суммы будет недостаточно банкнот, то сообщим юзеру об этом.
Понятно, что всё должно быть user friendly, поэтому придется наводить рюшечки.
 */
public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        /*
        хардкодинг п1 задачи №4.
         */
        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        String[] arr = ConsoleHelper.getValidTwoDigits(code);
        currencyManipulator.addAmount(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        //хардкодинг закончен
    }
}
