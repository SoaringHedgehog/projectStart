package command;

// TODO 5.3.4 Сюда передавать загрузчик приложения в конструктор?
public interface Command {
    void process();
    String description();
    String getName();
}
