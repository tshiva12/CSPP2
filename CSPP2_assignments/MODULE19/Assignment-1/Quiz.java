class Quiz {
	public String questiontext;
	public String choice;
	public int correctanswer;
	public int marksawarded;
	public int penality;
	public Quiz() {}
	public Quiz(String questiontext, String choice, int correctanswer, int marksawarded, int penality) {
		this.questiontext = questiontext;
		this.choice = choice;
		this.correctanswer = correctanswer;
		this.marksawarded = marksawarded;
		this.penality = penality;
	}
}