
public class App {

  public static void main(String[] args) {

    ToDoList toDoList;
    toDoList = new ToDoList();

    if (args.length == 0) {
      toDoList.NoArgument();
    } else if (args[0].contains("-l")) {
      toDoList.ListTask();
    } else if (args[0].contains("-a")){
      toDoList.AddTask(args);
    }
  }
}
