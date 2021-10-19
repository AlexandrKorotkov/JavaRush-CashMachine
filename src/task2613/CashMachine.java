package task2613;

import task2613.command.CommandExecutor;

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
        Operation operation;
        do {
            CommandExecutor.execute(operation = ConsoleHelper.askOperation());
        } while (operation != Operation.EXIT);

    }
}
