public class ItemToPurchase {

    private String itemName;
    private String itemDescription;
    private int itemPrice;
    private int itemQuantity;


    public ItemToPurchase() {
        itemName = "None";
        itemDescription = "None";
        itemPrice = 0;
        itemQuantity = 0;
    }

    public ItemToPurchase(String userName, String userDescription, int userPrice, int userQuantity) {
        itemName = userName;
        itemDescription = userDescription;
        itemPrice = userPrice;
        itemQuantity = userQuantity;
    }

    public void setName(String userName) {
        itemName = userName;
    }

    public void setPrice(int userPrice) {
        itemPrice = userPrice;
    }

    public void setQuantity(int userQuantity) {
        itemQuantity = userQuantity;
    }

    public void setDescription(String userDescription) {
        itemDescription = userDescription;
    }

    public String getName() {
        return itemName;
    }

    public String getDescription() {
        return itemDescription;
    }

    public int getPrice() {
        return itemPrice;
    }

    public int getQuantity() {
        return itemQuantity;
    }

    public String printItemCost() {
        String cost = ("\n" + itemName + " " + itemQuantity + " @ $" + itemPrice + " = $" + (itemQuantity * itemPrice));
        return cost;
    }

    public String printItemDescription() {
        String description = (itemName + ": " + itemDescription);
        return description;
    }
}
