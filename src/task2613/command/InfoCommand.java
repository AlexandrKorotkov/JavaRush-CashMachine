package task2613.command;

import task2613.ConsoleHelper;
import task2613.CurrencyManipulator;
import task2613.CurrencyManipulatorFactory;

/*
Выводит информацию о имеющихся в банкомате купюрах.
 */
class InfoCommand implements Command {
    @Override
    public void execute() {
        boolean hasMoney = false;
        for (CurrencyManipulator man : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
            if (man.hasMoney()) {
                hasMoney = true;
                ConsoleHelper.writeMessage(man.getCurrencyCode() + " - " + man.getTotalAmount());
            }
        }
        if (!hasMoney) ConsoleHelper.writeMessage("No money available.");

    }
}
