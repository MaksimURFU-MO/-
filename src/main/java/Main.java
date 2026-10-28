import Adapters.ChoiceAdapter;
import Adapters.OrderSource;
import Service.CalculatorDiscount;
import UnloadToFile.UnloadInFile;
import Users.User;

import java.nio.file.Path;
import java.util.List;

public class Main {
    static void main() {
        Path loadFile = Path.of("src/main/resources/OrdersNotType");
        Path unloadFile = Path.of("src/main/resources/Result");
        OrderSource file = ChoiceAdapter.choiceAdapter(loadFile);
        List<User> listUsers = file.parseOrders();
        CalculatorDiscount logic = new CalculatorDiscount();
        UnloadInFile.unload(logic.ProcessOrders(listUsers),unloadFile);
    }
}
