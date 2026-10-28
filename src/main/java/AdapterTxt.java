import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AdapterTxt implements OrderSource {
    private final Path filePath;

    AdapterTxt(Path filePath){
        this.filePath = filePath;
    }

    public List<User> parseOrders() {
        List<User> listOrders = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(this.filePath);
            for (String line : lines) {
                String[] element = line.split("\\|");
                String dateTimeString = element[0];
                LocalDateTime dateTime = LocalDateTime.parse(dateTimeString);
                String nameCompany = element[1].trim();
                int weight = Integer.parseInt(element[2].trim());
                User user = new User(dateTime, nameCompany, weight);
                listOrders.add(user);
            }
        } catch (java.io.IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
        return listOrders;
    }

}

