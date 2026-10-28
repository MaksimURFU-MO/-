package Adapters;

import Users.User;

import java.util.List;

public interface OrderSource {
    public List<User> parseOrders();
}
