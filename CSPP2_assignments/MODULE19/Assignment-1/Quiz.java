class Quiz {
	public String questiontext;
	public String choices;
	public int correctanswer;
	public int marksawarded;
	public int penality;
	public Quiz() {}
	public Quiz(String questiontext, String choices, int correctanswer, int marksawarded, int penality) {
		this.questiontext = questiontext;
		this.choices = choices;
		this.correctanswer = correctanswer;
		this.marksawarded = marksawarded;
		this.penality = penality;
	}
}