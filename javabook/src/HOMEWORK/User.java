package HOMEWORK;

public class User {
	int group;
	int num;
	int score;
	
	public User(int group, int num, int score) {
		this.group = group;
		this.num = num;
		this.score = score;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
