package command;

import java.util.HashMap;
import java.util.Map;

public class HelpCommand implements Command{
    HashMap<String, Command> commandMap;
    String pattern = "help";

    public HelpCommand(HashMap<String, Command> commandMap){
        this.commandMap = commandMap;
    }

    @Override
    public void process() {
        for(Map.Entry<String, Command> command : commandMap.entrySet()){
            System.out.println(command.getValue().description());
        }
    }

    @Override
    public String description() {
        String description = pattern + " - Команда показывает набор всех команд";
        return description;
    }

    @Override
    public String getName() {
        return pattern;
    }
}
