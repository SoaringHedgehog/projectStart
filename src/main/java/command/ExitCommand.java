package command;

public class ExitCommand implements Command{
    String pattern = "exit";
    @Override
    public void process() {
        System.exit(0);
    }

    @Override
    public String description() {
        String description = pattern + " - Команда реализовывает завершение работы приложения";
        return description;
    }

    @Override
    public String getName() {
        return pattern;
    }
}
