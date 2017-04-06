import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class App {

  public static void main(String[] args) {
    Path text = Paths.get("printusage.txt");
    if (args.length == 0) {
      try {
        List<String> noArgument = Files.readAllLines(text);
        for (int i = 0; i < noArgument.size(); i++) {
          System.out.println(noArgument.get(i));
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
