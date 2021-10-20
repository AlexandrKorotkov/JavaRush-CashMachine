package task2613.command;

import task2613.ConsoleHelper;
import task2613.exception.InterruptOperationException;

class ExitCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Вы действительно хотите выйти? y/n");
        String answer = ConsoleHelper.readString().toLowerCase();
        if(answer.equals("y")) ConsoleHelper.writeMessage("До свидания.");


    }
}
