import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ToDoList {
  Path listtasksText;
  Path printusageText;

  public void NoArgument() {
    try {
      printusageText = Paths.get("printusage.txt");
      List<String> noArgument = Files.readAllLines(printusageText);
      for (int i = 0; i < noArgument.size(); i++) {
        System.out.println(noArgument.get(i));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void ListTask() {
    try {
      listtasksText = Paths.get("listtasks.txt");
      List<String> orderedList = Files.readAllLines(listtasksText);
      if (orderedList.size() == 0) {
        System.out.println("nothing to do today! :)");
      } else {
        for (int i = 0; i < orderedList.size(); i++) {
          if (i < 9) {
            System.out.println(" " + (i + 1) + " - " + orderedList.get(i));

          } else {
            System.out.println(i + 1 + " - " + orderedList.get(i));
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void AddTask(String[] args) {
    Path tasks = Paths.get("listtasks.txt");
    List<String> list;
    try {
      list = Files.readAllLines(tasks);
      if (args.length == 1) {
        System.out.println("System error: No task is provided!");
      } else {
        list.add(list.size(), "[ ]" + args[1]);
        Files.write(tasks, list);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void RemoveTask(String[] args) {
    Path tasks = Paths.get("listtasks.txt");
    List<String> list;
    try {
      list = Files.readAllLines(tasks);
      if (args.length == 1) {
        System.out.println("System error: No index is provided!");
      } else if (Integer.parseInt(args[1]) > list.size()) {
        System.out.println("System error: Index is out of list size!");
      } else {
        list.remove(Integer.parseInt(args[1]) - 1);
        Files.write(tasks, list);
      }
    } catch (Exception e) {
      System.out.println("System error: Index is not a number!");
    }
  }

  public void CheckTask(String[] args) {
    Path tasks = Paths.get("listtasks.txt");
    List<String> list;
    String chosenTask;
    try {
      list = Files.readAllLines(tasks);
      if (args.length == 1) {
        System.out.println("System error: No index is provided!");
      } else if (Integer.parseInt(args[1]) > list.size()) {
        System.out.println("System error: Index is out of list size!");
      } else {
        chosenTask = list.get(Integer.parseInt(args[1]) - 1);
        String newString = chosenTask.replaceFirst(" ", "x");
        list.set((Integer.parseInt(args[1]) - 1), newString);
        Files.write(tasks, list);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

