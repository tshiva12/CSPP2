class Weight {
	private double weight;
	private double fat;
	private String date;
	Weight(double weight, double fat, String date) {
		this.weight = weight;
		this.fat = fat;
		this.date = date;
	}
	public double getWeight() {
		return this.weight;
	}
	public double getFat() {
		return this.fat;
	}
	public String getDate() {
		return this.date;
	}
}