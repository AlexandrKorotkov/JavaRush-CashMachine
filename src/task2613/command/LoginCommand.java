package task2613.command;

import task2613.ConsoleHelper;
import task2613.exception.InterruptOperationException;

public class LoginCommand implements Command {
    private String cardNumber = "123456789012";
    private String pin = "1234";
    @Override
    public void execute() throws InterruptOperationException {
        while (true){
            ConsoleHelper.writeMessage("Введите номер карты:");
            String card = ConsoleHelper.readString();
            if(card.equals(cardNumber)){
                ConsoleHelper.writeMessage("Введите пин-код:");
                String p = ConsoleHelper.readString();
                if(p.equals(pin)){
                    ConsoleHelper.writeMessage("Верификация пройдена.");
                    break;
                }else ConsoleHelper.writeMessage("Неверный пин. Повторите");
            }else ConsoleHelper.writeMessage("Неверный номер карты. Повторите");

        }

    }
}
