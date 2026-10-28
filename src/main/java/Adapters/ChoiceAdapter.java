package Adapters;

import java.nio.file.Path;

public class ChoiceAdapter {
    public static OrderSource choiceAdapter(Path file) {
        String fileName = file.getFileName().toString();

        if (fileName.contains("OrdersNotType")) {
            return new Adapter(file, "[#]");
        } else if (fileName.contains("OrdersTxt")) {
            return new Adapter(file,"\\|");
        } else {
            throw new IllegalArgumentException("Неизвестный формат файла" + fileName);
        }
    }
}
