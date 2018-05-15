package shop;

import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 * Order is created, when an user purchases the content of the shopping cart.
 * 
 */
public class Order {

    private ArrayList<Item> items;
    String customerName;
    String customerAddress;
    OrderState state;
    LocalDateTime created;
    ShoppingCart cart;


    public Order(ShoppingCart cart, String customerName, String customerAddress, OrderState state) {
        items = cart.getCartItems();
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.state = state;
        this.created = DateTimeFactory.getNow();
        this.cart = cart;
    }

    public Order(ShoppingCart cart, String customerName, String customerAddress) {
        items = cart.getCartItems();
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.state = OrderState.CREATED;
        this.created = DateTimeFactory.getNow();
        this.cart = cart;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> goods) {
        this.items = goods;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    
    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void processOrder(Customer customer) {
        if (cart.getDiscount(customer) != 0) {
            customer.subtractPoints();
        }
        customer.addOrder(this);

    }
}
