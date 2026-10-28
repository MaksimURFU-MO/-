package UnloadToFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UnloadInFile {
    public static void unload(Map<String,Double> result, Path unloadFile){
        List<String> tempList = new ArrayList<>();
        for(Map.Entry<String,Double> entry : result.entrySet()) {
            String line = entry.getKey() + " - " + entry.getValue();
            tempList.add(line);
        }
        try{
                Files.write(unloadFile, tempList);
        } catch (IOException e){
                throw new RuntimeException("Ошибка записи в файл: " + unloadFile, e);
        }
    }
}
