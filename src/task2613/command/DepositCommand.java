package task2613.command;

import task2613.ConsoleHelper;
import task2613.CurrencyManipulator;
import task2613.CurrencyManipulatorFactory;
import task2613.exception.InterruptOperationException;

class DepositCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        String[] arr = ConsoleHelper.getValidTwoDigits(code);
        currencyManipulator.addAmount(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
    }
}
