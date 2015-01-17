package com.twu.biblioteca.model;
import com.twu.biblioteca.Item;
import com.twu.biblioteca.Customer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

    private List<Item> ItemList;
    private List<Item> availableItemList;


    Map<Item,Customer> customerItemMap = new HashMap<>();

    public Library(List<Item> availableItemList, List<Item> ItemList) {
        this.availableItemList = availableItemList;
        this.ItemList = ItemList;
    }

    public List<Item> getAvailableItemList() {
        return availableItemList;
    }

    public Map<Item, Customer> getCustomerItemMap(){
        return customerItemMap;
    };

    public void updateCustomerItemMap(Customer customer,Item Item) {
      customerItemMap.put(Item, customer);
    }

    public void checkOut(Item Item) {
        availableItemList.remove(Item);
    }

    public Item find(String ItemName) {
        for (Item Item : availableItemList) {
            if (Item.getName().equals(ItemName)) {
                return Item;
            }
        }
        return null;
    }
    public Item findForReturn(String ItemName) {
        for (Item Item : ItemList) {
            if (Item.getName().equals(ItemName)) {
                return Item;
            }
        }
        return null;
    }

    public boolean returnItem(Item Item) {
        availableItemList.add(Item);
        return true;
    }

    public void removeItemFromItemCustomerMap(Item Item) {
        customerItemMap.remove(Item);
    }
}

