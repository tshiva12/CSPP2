import java.util.Scanner;

class Item {
	private String name;
	private int quantity;
	private double price;
	public Item(String name, int quantity, Double price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	public Item(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
		this.price = 0;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return this.name ;
	}
	public int getQuantity() {
		return this.quantity ;
	}
	public Double getPrice() {
		return this.price ;
	}
}
class ShoppingCart {
	public Item[] catalog;
	public int catalogcount;
	public Item[] cart;
	public int cartcount;
	public double discount;
	public ShoppingCart() {
		catalog = new Item[10];
		catalogcount = 0;
		cart = new Item[10];
		cartcount = 0;
		discount = 0;
	}
	public void addToCatalog(Item item) {
		catalog[catalogcount++] = item;
	}
	public void addToCart(Item item) {
		cart[cartcount++] = item;
	}
	public void removeFromCart(Item item) {
		int position = 0, temp = 0;
		for (int i = 0; i < cartcount; i++) {
			if (cart[i].getName().equals(item.getName())) {
				cart[i].setQuantity(cart[i].getQuantity() - item.getQuantity());
				if (cart[i].getQuantity() == 0) {
					position = i;
					temp = 1;
					break;
				}
			}
		}
		if (temp == 1) {
			for (int i = position; i < cartcount; i++) {
				cart[i] = cart[i + 1];				
			}
			cart[cartcount - 1] = null;
			cartcount--;
		}
	}
	public void showCart() {
		for (int i = 0;i < cartcount; i++) {
			System.out.println(cart[i].getName()
			 + " " + cart[i].getQuantity());
			
		}
	}
	public void showCatalog() {
		for (int i = 0; i < catalogcount; i++) {
			System.out.println(catalog[i].getName() +
			 " " + catalog[i].getQuantity() +
			  " " + catalog[i].getPrice());
		}
	}
	public double getTotalAmount() {
		double total = 0;
		for (int i = 0; i < cartcount; i++) {
			for (int j = 0; j < catalogcount; j++) {
				if (catalog[j].getName().equals(cart[i].getName())) {
					total += catalog[j].getPrice() * cart[i].getQuantity();
				}
			}		
		}
		return total;
	}
	public double getPayableAmount() {
		double result = getTotalAmount();
		result -= (result / 100) * this.discount;
		result += (result / 100) * 15;
		return result;
	}
	public void applyCoupon(String coupon) {
		if (this.discount == 0.0) {
			if (coupon.equals("IND10") || coupon.equals("IND20")
		 	|| coupon.equals("IND30") || coupon.equals("IND50")) {
				this.discount = Double.parseDouble(coupon.
					substring(3, coupon.length()));
			} else {
				System.out.println("Invalid coupon");
			}
		}
	}
	public void printInvoice() {
		System.out.println("Name   quantity   Price");
		for (int i = 0; i < cartcount; i++) {
			for (int j = 0; j < catalogcount; j++) {
				if (cart[i].getName().equals(catalog[j].getName())) {
					System.out.println(cart[i].getName()
					 + " " + cart[i].getQuantity()
					  + " " + catalog[j].getPrice());
				}	
			}
		}
		System.out.println("Total:" + getTotalAmount());
		System.out.println("Disc%:" + (getTotalAmount() / 100) * discount);
		System.out.println("Tax:" + (getTotalAmount() - (getTotalAmount() / 100) * discount) * 0.15);
		System.out.println("Payable amount: " + getPayableAmount());
	}
}

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
				System.out.println("totalAmount: " + shopcart.getTotalAmount());
				break;
				case "remove":
				data = tokens[1].split(",");
				shopcart.removeFromCart(new Item(data[0],
				 Integer.parseInt(data[1])));
				break;
				case "payableAmount":
				System.out.println("Payable amount: " + shopcart.getPayableAmount());				
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