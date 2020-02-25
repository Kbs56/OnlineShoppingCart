import java.util.Scanner;
public class ShoppingCartManager {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        String customerName;
        String todaysDate;

        System.out.print("Enter Customer's Name:");
        customerName = kb.nextLine();

        System.out.print("\nEnter Today's Date:");
        todaysDate = kb.nextLine();

        ShoppingCart userCart = new ShoppingCart(customerName,todaysDate);
        System.out.println("\nCustomer Name: " + userCart.getCustomerName());
        System.out.println("Today's Date: " + userCart.getDate());


        printMenu(userCart, kb);

        System.exit(0);

    }

    public static void printMenu(ShoppingCart shoppingCart, Scanner scnr){

        char userChoice = ' ';
        boolean done = false;
        String clrScnr;

        String menu = ("\nMENU\n"
                + "a - Add item to cart\n"
                + "d - Remove item from cart\n"
                + "c - Change item quantity\n"
                + "i - Output items' descriptions\n"
                + "o - Output shopping cart\n"
                + "q - Quit\n");
        System.out.print(menu);

        do{
            System.out.print("\nChoose an option:");
            userChoice = scnr.next().charAt(0);


            switch (userChoice) {
                case ('q'): System.out.println();
                    done = true;
                    break;

                case ('o'): System.out.println("\nOUTPUT SHOPPING CART");
                    System.out.println(shoppingCart.getCustomerName() + "'s Shopping Cart - " + shoppingCart.getDate());
                    if(shoppingCart.getNumItemsInCart() == 0){
                        System.out.println("Number of Items: " + shoppingCart.getNumItemsInCart());
                        System.out.print("\nSHOPPING CART IS EMPTY" );
                    }
                    else{
                        System.out.println("Number of Items: " + shoppingCart.getNumItemsInCart());
                    }
                    shoppingCart.printTotal();
                    System.out.println("\nTotal: $" + shoppingCart.getCostOfCart());
                    System.out.print(menu);
                    break;

                case ('i'): System.out.println("\nOUTPUT ITEMS' DESCRIPTIONS");
                    System.out.println(shoppingCart.getCustomerName() + "'s Shopping Cart - " + shoppingCart.getDate()+ "\n");
                    shoppingCart.printDescriptions();
                    System.out.print(menu);
                    break;

                case ('a'): clrScnr = scnr.nextLine();
                    ItemToPurchase newItem = new ItemToPurchase();
                    System.out.println("\nADD ITEM TO CART");
                    System.out.print("Enter the item name:");
                    newItem.setName(scnr.nextLine());
                    System.out.print("\nEnter the item description:");
                    newItem.setDescription(scnr.nextLine());
                    System.out.print("\nEnter the item price:");
                    newItem.setPrice(scnr.nextInt());
                    System.out.print("\nEnter the item quantity:");
                    newItem.setQuantity(scnr.nextInt());
                    shoppingCart.addItem(newItem);
                    System.out.print("\n" + menu);
                    break;

                case ('d'): clrScnr = scnr.nextLine();
                    System.out.println("\nREMOVE ITEM FROM CART");
                    System.out.print("Enter name of item to remove:");
                    shoppingCart.removeItem(scnr.nextLine());
                    System.out.print("\n" + menu);
                    break;

                case ('c'): clrScnr = scnr.nextLine();
                    System.out.println("CHANGE ITEM QUANTITY");
                    ItemToPurchase changeItem = new ItemToPurchase();
                    System.out.print("Enter the item name:");
                    changeItem.setName(scnr.nextLine());
                    System.out.print("\nEnter the new quantity:");
                    changeItem.setQuantity(scnr.nextInt());
                    shoppingCart.modifyItem(changeItem);
                    System.out.print(menu);
                    break;
                default:
                    break;
            }
        }while(!done);
    }
}
