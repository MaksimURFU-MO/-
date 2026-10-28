package UnloadToFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UnloadInFile {
    private static final String DASH = "-";
    public static void unload(Map<String, BigDecimal> result, Path unloadFile){
        List<String> tempList = new ArrayList<>();
        for(Map.Entry<String,BigDecimal> entry : result.entrySet()) {
            String line = entry.getKey() + DASH + entry.getValue();
            tempList.add(line);
        }
        try{
                Files.write(unloadFile, tempList);
        } catch (IOException e){
            System.err.println("Не удалось записать файл: " + e.getMessage());
        }
    }
}
