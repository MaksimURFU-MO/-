package Adapters;

import Users.User;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Adapter implements OrderSource{
    private final Path FILEPATH;
    private final String SEPARATOR;

    Adapter(Path FILEPATH, String SEPARATOR){
        this.FILEPATH = FILEPATH;
        this.SEPARATOR = SEPARATOR;
    }
    public List<User> parseOrders() {
        List<User> listOrders = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(this.FILEPATH);
            for (String line : lines) {
                String[] element = line.split(this.SEPARATOR);
                if(element.length != 3){
                    System.out.println("В файле некорректная строка");
                    continue;
                }
                String dateTimeString = element[0];
                LocalDateTime dateTime = LocalDateTime.parse(dateTimeString);
                String nameCompany = element[1].trim();
                try{
                    int weight = Integer.parseInt(element[2].trim());
                    User user = new User(dateTime, nameCompany, weight);
                    listOrders.add(user);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: строку " + element[2] + " нельзя превратить в число");
                }
            }
        } catch (java.io.IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
        return listOrders;
    }
}
