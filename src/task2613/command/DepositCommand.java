package task2613.command;

import task2613.ConsoleHelper;
import task2613.CurrencyManipulator;
import task2613.CurrencyManipulatorFactory;

class DepositCommand implements Command {
    @Override
    public void execute() {
        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        String[] arr = ConsoleHelper.getValidTwoDigits(code);
        currencyManipulator.addAmount(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
    }
}
