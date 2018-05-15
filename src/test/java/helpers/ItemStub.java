package helpers;

import shop.Item;

public class ItemStub extends Item {
    public ItemStub(int id, String name, float price, String category) {
        super(id, name, price, category);
    }

    @Override
    public int getLoyaltyPoints() {
        return 0;
    }

    public ItemStub() {
        super(0, "stubName", 10, "stubCategory");
    }
}
