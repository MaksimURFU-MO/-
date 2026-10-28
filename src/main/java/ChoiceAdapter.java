import java.nio.file.Path;

public class ChoiceAdapter {
    public static OrderSource createAdapter(Path file) {
        String fileName = file.getFileName().toString();

        if (fileName.contains("OrdersNotType")) {
            return new AdapterNotType(file);
        } else if (fileName.contains("OrdersTxt")) {
            return new AdapterTxt(file);
        } else {
            throw new IllegalArgumentException("Неизвестный формат файла" + fileName);
        }
    }
}
