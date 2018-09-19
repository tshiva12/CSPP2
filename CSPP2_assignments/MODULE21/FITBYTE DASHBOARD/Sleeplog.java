class Sleep {
	private int begin;
	private int end;
	Sleep(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}
	public int getStarttime() {
		return this.begin;
	}
	public int getEndtime() {
		return this.end;
	}

	public String gethoursSlept() {
		String s="";
		s+=" No of Hours slept ";
		return s + (this.begin - this.end) + " hours slept";
	}
}