package task2613.command;

import task2613.ConsoleHelper;
import task2613.CurrencyManipulator;
import task2613.CurrencyManipulatorFactory;
import task2613.exception.InterruptOperationException;
import task2613.exception.NotEnoughMoneyException;

import java.util.Map;

class WithdrawCommand implements Command {

    @Override
    public void execute() throws InterruptOperationException {
        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        while (true) {
            ConsoleHelper.writeMessage("Введите сумму: ");
            String expectedAmountStr = ConsoleHelper.readString();
            if (expectedAmountStr == null) {
                ConsoleHelper.writeMessage("Введена некорректная сумма. Повторите");
            } else {
                try {
                    int expectedAmount = Integer.parseInt(expectedAmountStr);
                    if (!manipulator.isAmountAvailable(expectedAmount)) {
                        ConsoleHelper.writeMessage("Недостаточная сумма на счете. Повторите.");
                    } else {
                        Map<Integer, Integer> map = manipulator.withdrawAmount(expectedAmount);
                        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                            ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());
                        }
                        ConsoleHelper.writeMessage("Транзакция проведена успешно.");
                        break;
                    }
                } catch (NotEnoughMoneyException e) {
                    ConsoleHelper.writeMessage("Недостаточно банкнот для выдачи указанной суммы.Введите другую сумму.");
                } catch (NumberFormatException e) {
                    ConsoleHelper.writeMessage("Введена некорректная сумма");
                }
            }
        }
    }
}

