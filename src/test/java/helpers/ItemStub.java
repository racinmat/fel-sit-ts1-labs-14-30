package helpers;

import shop.Item;

public class ItemStub extends Item {
    public ItemStub(int id, String name, float price, String category) {
        super(id, name, price, category);
    }

    public ItemStub() {
        super(0, "stubName", 10, "stubCategory");
    }
}
