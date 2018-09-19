class Foodlog {
	private String fooditem;
	private String quantity;
	private String date;
	private String time;
	Foodlog(String fooditem, String quantity, String date, String time) {
		this.fooditem = fooditem;
		this.quantity = quantity;
		this.date = date;
		this.time = time;
	}
	public String getFoodItem() {
		return this.fooditem;
	}
	public String getQuantity() {
		return this.quantity;
	}
	public String getDate() {
		return this.date;
	}
	public String getTime() {
		return this.time;
	}

}