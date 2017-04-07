import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ToDoList {
  Path listtasksText;
  Path printusageText;
  List<String> list;
  String errorNoTask = "System error: No task is provided!";
  String errorNoIndex = "System error: No index is provided!";
  String errorOutIndex = "System error: Index is out of list size!";
  String errorNotNumber = "System error: Index is not a number!";
  String updatedList = "Here is your new list:";
  String taskFile = "listtasks.txt";

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
      listtasksText = Paths.get(taskFile);
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
    listtasksText = Paths.get(taskFile);
    try {
      list = Files.readAllLines(listtasksText);
      if (args.length == 1) {
        System.out.println(errorNoTask);
      } else {
        list.add(list.size(), "[ ]" + args[1]);
        Files.write(listtasksText, list);
      }
      System.out.println("Here is your new list:");
      ListTask();
      System.out.println();
    } catch (Exception e) {
    }
  }

  public void RemoveTask(String[] args) {
    listtasksText = Paths.get(taskFile);
    try {
      list = Files.readAllLines(listtasksText);
      if (args.length == 1) {
        System.out.println(errorNoIndex);
      } else if (Integer.parseInt(args[1]) > list.size()) {
        System.out.println(errorOutIndex);
      } else {
        list.remove(Integer.parseInt(args[1]) - 1);
        Files.write(listtasksText, list);
      }
      System.out.println(updatedList);
      ListTask();
      System.out.println();
    } catch (Exception e) {
      System.out.println(errorNotNumber);
    }
  }

  public void CheckTask(String[] args) {
    listtasksText = Paths.get(taskFile);
    String chosenTask;
    try {
      list = Files.readAllLines(listtasksText);
      if (args.length == 1) {
        System.out.println(errorNoIndex);
      } else if (Integer.parseInt(args[1]) > list.size()) {
        System.out.println(errorOutIndex);
      } else {
        chosenTask = list.get(Integer.parseInt(args[1]) - 1);
        String newString = chosenTask.replaceFirst(" ", "x");
        list.set((Integer.parseInt(args[1]) - 1), newString);
        Files.write(listtasksText, list);
      }
      System.out.println(updatedList);
      ListTask();
      System.out.println();
    } catch (Exception e) {
      System.out.println(errorNotNumber);
    }
  }
}

