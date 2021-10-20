package task2613.command;

import task2613.CashMachine;
import task2613.ConsoleHelper;
import task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command {
    private String cardNumber, pin;
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.verifiedCards");

    @Override
    public void execute() throws InterruptOperationException {
        while (true) {
            ConsoleHelper.writeMessage("Введите номер карты:");
            cardNumber = ConsoleHelper.readString();
            if (validCreditCards.containsKey(cardNumber)) {
                ConsoleHelper.writeMessage("Введите пин-код:");
                pin = ConsoleHelper.readString();
                if (validCreditCards.getString(cardNumber).equals(pin)) {
                    ConsoleHelper.writeMessage("Верификация пройдена.");
                    break;
                } else ConsoleHelper.writeMessage("Неверный пин. Повторите");
            } else ConsoleHelper.writeMessage("Неверный номер карты. Повторите");
        }
    }
}
