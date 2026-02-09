package command;

import java.util.HashMap;
import java.util.Map;

public class HelpCommand implements Command{
    HashMap<String, Command> commandMap;
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
        String description = "Команда показывает набор всех команд";
        return description;
    }
}
