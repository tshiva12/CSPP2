class Activity {
	private String name;
	private String starttime;
	private String endtime;
	private String notes;
	private String date;
	// Activity(String name, String starttime, String endtime, String date) {
	// 	this.name = name;
	// 	this.starttime = starttime;
	// 	this.endtime = endtime;
	// 	this.date = date;
	// }
	Activity(String name, String starttime, String endtime, String notes, String date) {
		this.name = name;
		this.starttime = starttime;
		this.endtime = endtime;
		this.notes = "";
		this.date = date;
	}
	public String getName() {
		return this.name;
	}
	public String getStarttime() {
		return this.starttime;
	}
	public String getEndtime() {
		return this.endtime;
	}
	public String getNotes() {
		return this.notes;
	}
	public String getDate() {
		return this.date;
	}
}