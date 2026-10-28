import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculatorDiscount {
    private int discount = 50;
    private final int step = 5;
    private final int price = 10;

    public int getDiscount() {
        return discount;
    }
    public int getStep() {
        return step;
    }
    public int getPrice() {
        return price;
    }

    public Map<String,Double> ProccesOrders(List<User> listOrders){
        Map<String, Double> result = new HashMap<>();
        Sort.bubbleSort(listOrders);
        for(User user : listOrders){

            if(!result.containsKey(user.getNameCompany())) {
                double sumBuy = user.getWeight() * price * (1 - discount / 100);
                result.put(user.getNameCompany(),sumBuy);
            } else {
                double sumBuy = user.getWeight() * price * (1 - discount / 100);
                double value = result.get(user.getNameCompany());
                value+=sumBuy;
                result.put(user.getNameCompany(), value);
            }
            if(discount >=getStep()){
                discount-=getStep();
            } else {
                discount = 0;
            }
        }
        return result;
    }
}
