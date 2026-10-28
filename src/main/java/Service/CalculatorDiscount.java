package Service;

import Users.User;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculatorDiscount {
    private BigDecimal discount = BigDecimal.valueOf(50);
    private final BigDecimal STEP = BigDecimal.valueOf(5);
    private final BigDecimal PRICE = BigDecimal.valueOf(10);
    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);

    public Map<String, BigDecimal> ProcessOrders(List<User> listUsers){
        Map<String, BigDecimal> result = new HashMap<>();
        listUsers.sort(null);
        for(User user : listUsers){
            String nameCompany = user.getNameCompany();
            BigDecimal sizeDiscount = HUNDRED.subtract(discount).divide(HUNDRED, 2, RoundingMode.HALF_UP);
            BigDecimal sumBuy = BigDecimal.valueOf(user.getWeight())
                    .multiply(PRICE)
                    .multiply(sizeDiscount);
            if(!result.containsKey(nameCompany)) {
                result.put(nameCompany,sumBuy);
            } else {
                BigDecimal value = result.get(nameCompany);
                value=value.add(sumBuy);
                result.put(user.getNameCompany(), value);
            }
            if(discount.compareTo(STEP)>=0){
                discount = discount.subtract(STEP);
            } else {
                discount = BigDecimal.ZERO;
            }
        }
        return result;
    }
}
