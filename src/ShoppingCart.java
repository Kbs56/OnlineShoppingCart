import java.util.ArrayList;
public class ShoppingCart {

    private String customerName;
    private String currentDate;
    private ArrayList<ItemToPurchase> cartItems = new ArrayList<>();

    public ShoppingCart() {
        customerName = "none";
        currentDate = "January 1, 2016";
    }

    public ShoppingCart(String userName, String userDate) {
        customerName = userName;
        currentDate = userDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDate() {
        return currentDate;
    }

    public void addItem(ItemToPurchase ItemToPurchase) {
        this.cartItems.add(cartItems.size(), ItemToPurchase);
    }

    public void removeItem(String itemToRemove) {
        int count = 0;
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getName().equalsIgnoreCase(itemToRemove)) {
                cartItems.remove(i);
                ++count;
            }
        }
        if (count == 0) {
            System.out.print("\nItem not found in cart. Nothing removed.");
        }
    }

    public void modifyItem(ItemToPurchase itemToPurchase) {
        int count = 0;
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getName().equals(itemToPurchase.getName())) {
                cartItems.get(i).setQuantity(itemToPurchase.getQuantity());
                ++count;
            }
        }
        if (count == 0) {
            System.out.println("\nItem not found in cart. Nothing modified.");
        }
    }

    public int getNumItemsInCart() {
        int numItems = 0;
        for (int i = 0; i < cartItems.size(); i++) {
            numItems = numItems + cartItems.get(i).getQuantity();
        }
        return  numItems;
    }

    public int getCostOfCart() {
        int totalCost = 0;
        for (int i = 0; i < cartItems.size(); i++) {
            totalCost = totalCost + cartItems.get(i).getPrice()*cartItems.get(i).getQuantity();
        }
        return totalCost;
    }

    public void printTotal() {
        for (int i = 0; i < cartItems.size(); i++) {
            System.out.print(cartItems.get(i).printItemCost());
        }
        System.out.println();
    }

    public void printDescriptions() {
        System.out.println("Item Descriptions");
        for(int i = 0; i < cartItems.size(); i++) {
            System.out.println(cartItems.get(i).printItemDescription());
        }
    }
}
