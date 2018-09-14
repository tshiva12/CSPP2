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