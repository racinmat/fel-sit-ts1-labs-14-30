package shop;

import java.util.ArrayList;
import java.util.List;

import static shop.ShoppingCart.POINTS_PER_DISCOUNT;

public class Customer {

    private String name;
    private String address;
    private int loyaltyPoints;
    private List<Order> orders;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
        this.loyaltyPoints = 0;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void subtractPoints() {
        loyaltyPoints -= POINTS_PER_DISCOUNT;
    }

    public void addOrder(Order order) {
        orders.add(order);
        loyaltyPoints += order.getItems().stream()
            .mapToInt(Item::getLoyaltyPoints)
            .sum();
    }
}
