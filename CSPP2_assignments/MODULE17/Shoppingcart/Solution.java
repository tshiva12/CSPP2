import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShoppingCart shopcart = new ShoppingCart();
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String[] tokens = input.split(" ");
            switch(tokens[0]) {
                case "Item":
                String[] data = tokens[1].split(",");
                shopcart.addToCatalog(new Item(data[0],
                 Integer.parseInt(data[1]),
                  Double.parseDouble(data[2])));
                break;
                case "catalog":
                shopcart.showCatalog();
                break;
                case "add":
                data = tokens[1].split(",");
                shopcart.addToCart(new Item(data[0],
                 Integer.parseInt(data[1])));
                break;
                case "show":
                shopcart.showCart();
                break;
                case "totalAmount":
                System.out.println("totalAmount: " +
                 shopcart.getTotalAmount());
                break;
                case "remove":
                data = tokens[1].split(",");
                shopcart.removeFromCart(new Item(data[0],
                 Integer.parseInt(data[1])));
                break;
                case "payableAmount":
                System.out.println("Payable amount: "
                 + shopcart.getPayableAmount());
                break;
                case "print":
                shopcart.printInvoice();
                break;
                case "coupon":
                shopcart.applyCoupon(tokens[1]);
                break;
            }
        }
    }
}