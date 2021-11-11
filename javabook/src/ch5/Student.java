package ch5;

public class Student {
	private int code;
	private String name;
	private int korean;
	private int english;
	private int math;
	
	
	
	public Student(int code, String name, int korean, int english, int math) {
		super();
		this.code = code;
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
}
