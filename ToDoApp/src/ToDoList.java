import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ToDoList {
  Path listtasksText;
  Path printusageText;

  public void ListTask() {
    try {
      listtasksText = Paths.get("listtasks.txt");
      List<String> orderedList = Files.readAllLines(listtasksText);
      for (int i = 0; i < orderedList.size(); i++) {
        System.out.println(i + 1 + " " + orderedList.get(i));
      }
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Uh-oh, could not read the file!");
    }
  }

  public void NoArgument() {
    try {
      printusageText = Paths.get("printusage.txt");
      List<String> noArgument = Files.readAllLines(printusageText);
      for (int i = 0; i < noArgument.size(); i++) {
        System.out.println(noArgument.get(i));
      }
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Uh-oh, could not read the file!");
    }
  }
}

